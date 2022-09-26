package java112.analyzer;

import java.util.*;

/**
 * This class looks at the input txt file and analyzes each unique token within
 * the file. It then outputs distinct_tokens.txt file of all words on their own
 * line.
 */
public class DistinctTokensAnalyzer implements TokenAnalyzer {
    // Setup the TreeSet variable to keep each unique word in memory
    private Set<String> distinctTokens;

    // This constructor initializes distinctTokens Set<String>
    public DistinctTokensAnalyzer() {
        distinctTokens = new TreeSet<>();
    }

    /**
     * This method returns the value of distinctTokens
     * @return distinctTokens Set for unique words
     */
    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }
    /**
     * This method recieves each line of the user txt file, splits the words up
     * and adds each unique word to distinctTokens
     * 
     * @param token
     */
    public void processToken(String token) {
        // Checks if the current token has any text lines without length
        if (token.length() > 0) {
            // Split the token and place the words into an array
            String[] tokenLines = token.split("\\W");
            // Loops through the tokenLines variable
            for (String splitTokens : tokenLines) {
                // Tests the token length after splitting to make sure there are
                // no lines without length.
                if (splitTokens.length() > 0) {
                    // Splits the text line so individual tokens appear on a
                    // single line.
                    splitTokens.split("\\W");
                    // Checks the distinctTokens variable to ensure no 
                    // duplicates occur
                    if (!distinctTokens.contains(splitTokens)) {
                        // Adds a new unique word to the distinctTokens variable
                        distinctTokens.add(splitTokens);
                    }
                }
            }
        }
    }
    
    public void generateOutputFile(String inputFilePath, String outputFilePath) {
        
    }
}
