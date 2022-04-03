package readability;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {
    public static int[] textProcessor(String filename) {
        File inputFile = new File(filename);
        int[] data = new int[5];
        try (Scanner scanner = new Scanner(inputFile)) {
            int words = 0;
            int sentences = 0;
            int characters = 0;
            int syllables = 0;
            int polysyllables = 0;
            while (scanner.hasNext()) {
                String currentWord = scanner.next().toLowerCase();
                words++;
                if (currentWord.endsWith(".") || currentWord.endsWith("?") || currentWord.endsWith("!")) {
                    sentences++;
                } else if (!scanner.hasNext()) {
                    sentences++;
                }
                characters += currentWord.length();
                int syllableCount = countSyllables(currentWord);
                syllables += syllableCount;
                if (syllableCount > 2) {
                    polysyllables++;
                }
            }
            data[0] = words;
            data[1] = sentences;
            data[2] = characters;
            data[3] = syllables;
            data[4] = polysyllables;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static int countSyllables(String word) {
        int syllableCount = 0;
        if (word.toLowerCase().endsWith("e")) {
            word = word.substring(0, word.length() - 1);
        }

        String regex = "[aeiouy]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(word);
        while (matcher.find()) {
            syllableCount++;
        }
        if (syllableCount == 0) {
            return 1;
        }

        return syllableCount;
    }

    public static void readFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                System.out.println(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
