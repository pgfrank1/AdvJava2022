package java112.analyzer;

/**
 * This interface is used for classes that process text files and generate
 * information about that file.
 * 
 * @author pgfrank
 * @since 11.0
 * @version 1.1
 */
public interface TokenAnalyzer {
    /**
     * Process the current line of text from the user entered file
     * 
     * @param token user entered file current line of text
     */
    void processToken(String token);

    /**
     * This method is for creating output from the user entered input file.
     * 
     * @param inputFilePath the user entered file path and name.
     */
    void generateOutputFile(String inputFilePath);
}
