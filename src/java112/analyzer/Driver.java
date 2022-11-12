package java112.analyzer;

/**
 * This program returns all unique words and file information about a user
 * specified txt file. It outputs distinct_tokens.txt and summary.txt about
 * the user entered txt file.
 * 
 * @author pgfrank
 * @since 11.0
 * @version 1.1
 */
public class Driver {
    /**
     * The main method calls upon the FileAnalysis class to start generating
     * information about the user entered txt file.
     * 
     * @param args 1 user entered file location.
     */
    public static void main(String[] args) {
        // Create an instance of the FileAnalysis class.
        FileAnalysis runLauncher = new FileAnalysis();
        
        // Calls upon the analyze function and starts generating information
        // about the specified file.

        System.out.println("TESTING");
        runLauncher.analyze(args);
    }
}