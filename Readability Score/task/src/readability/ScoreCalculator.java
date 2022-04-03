package readability;

public class ScoreCalculator {
    public static double calculateARI(int[] textData) {
        int wordCount = textData[0];
        int sentenceCount = textData[1];
        int characterCount = textData[2];

        double averageWordsSentences = (double) wordCount / (double) sentenceCount;
        double averageCharactersWords = (double) characterCount / (double) wordCount;

        return (4.71 * averageCharactersWords) + (.5 * averageWordsSentences) - 21.43;
    }

    public static double calculateFK(int[] textData) {
        int wordCount = textData[0];
        int sentenceCount = textData[1];
        int syllableCount = textData[3];

        double averageWordsSentences = (double) wordCount / (double) sentenceCount;
        double averageSyllablesPerWord = (double) syllableCount / (double) wordCount;

        return (0.39 * averageWordsSentences) + (11.8 * averageSyllablesPerWord) - 15.59;
    }

    public static double calculateSMOG(int[] textData) {
        int sentenceCount = textData[1];
        int polySyllableCount = textData[4];

        double polyPerSentence = (float) polySyllableCount * 30 / (float) sentenceCount;

        return 1.043 * Math.sqrt(polyPerSentence) + 3.1291;
    }

    public static double calculateCL(int[] textData) {
        int wordCount = textData[0];
        int sentenceCount = textData[1];
        int characterCount = textData[2];

        double avgCharacters = (double) characterCount / (double) wordCount * 100;
        double avgSentences = (double) sentenceCount / (double) wordCount * 100;

        return 0.0588 * avgCharacters - 0.296 * avgSentences - 15.8;
    }
}
