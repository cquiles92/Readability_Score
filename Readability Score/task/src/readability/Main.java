package readability;

import static readability.FileParser.*;
import static readability.ReaderEvaluator.*;


public class Main {
    public static void main(String[] args) {
        String filename = args[0];
        readFile(filename);
        int[] fileMetaData = textProcessor(filename);
        textAssessor(fileMetaData);
    }
}
