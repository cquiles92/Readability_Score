package readability;

import java.util.Scanner;

import static readability.ScoreCalculator.*;

public class ReaderEvaluator {
    private static int getReaderLevel(double results) {
        int readerLevel;
        if ((int) Math.ceil(results) > 13) {
            readerLevel = 22;
        } else {
            readerLevel = (int) Math.ceil(results) + 5;
        }
        return readerLevel;
    }

    public static String resultStringGenerator(String selection, int[] textData) {
        StringBuilder output = new StringBuilder();
        String test;
        int age;
        double score;
        switch (selection.trim().toUpperCase()) {
            case "ARI":
                test = "Automated Readability Index: ";
                score = calculateARI(textData);
                age = getReaderLevel(score);
                output.append(toStringResult(score, age, test));
                break;
            case "FK":
                test = "Flesch–Kincaid readability tests: ";
                score = calculateFK(textData);
                age = getReaderLevel(score);
                output.append(toStringResult(score, age, test));
                break;
            case "SMOG":
                test = "Simple Measure of Gobbledygook: ";
                score = calculateSMOG(textData);
                age = getReaderLevel(score);
                output.append(toStringResult(score, age, test));
                break;
            case "CL":
                test = "Coleman–Liau index: ";
                score = calculateCL(textData);
                age = getReaderLevel(score);
                output.append(toStringResult(score, age, test));
                break;
            case "ALL":
                double total = 0;

                test = "Automated Readability Index: ";
                score = calculateARI(textData);
                age = getReaderLevel(score);
                total += age;
                output.append(toStringResult(score, age, test));

                test = "Flesch–Kincaid readability tests: ";
                score = calculateFK(textData);
                age = getReaderLevel(score);
                total += age;
                output.append(toStringResult(score, age, test));

                test = "Simple Measure of Gobbledygook: ";
                score = calculateSMOG(textData);
                age = getReaderLevel(score);
                total += age;
                output.append(toStringResult(score, age, test));

                test = "Coleman–Liau index: ";
                score = calculateCL(textData);
                age = getReaderLevel(score);
                total += age;
                output.append(toStringResult(score, age, test));
                output.append("\n");

                total /= 4;
                output.append("This text should be understood in average by ");
                output.append(String.format("%.2f-year-olds.", total));
                break;
            default:

                break;
        }
        return output.toString();
    }

    private static String toStringResult(double score, int age, String selectedTest) {
        StringBuilder output = new StringBuilder(selectedTest);
        String formattedText = String.format("%.2f (about %d-year-olds).\n", score, age);
        output.append(formattedText);
        return output.toString();
    }

    public static void textAssessor(int[] textData) {
        int wordCount = textData[0];
        int sentenceCount = textData[1];
        int characterCount = textData[2];
        int syllableCount = textData[3];
        int polySyllableCount = textData[4];

        System.out.println();
        System.out.println("Words: " + wordCount);
        System.out.println("Sentences: " + sentenceCount);
        System.out.println("Characters: " + characterCount);
        System.out.println("Syllables: " + syllableCount);
        System.out.println("Polysyllables: " + polySyllableCount);

        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String testSelect = new Scanner(System.in).nextLine();
        String readerLevel = resultStringGenerator(testSelect, textData);
        System.out.println();

        System.out.println(readerLevel);
    }
}
