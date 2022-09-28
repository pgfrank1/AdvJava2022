package java112.analyzer;

import java.util.*;
import java.io.*;

/**
 * This class looks at the input txt file and analyzes each unique token within
 * the file. It then outputs distinct_tokens.txt file of all words on their own
 * line.
 * 
 * @author pgfrank
 * @since 11.0
 * @version 1.0
 */
public class DistinctTokensAnalyzer implements TokenAnalyzer {
    /**
     * Stores every unique token from the user entered file.
     */
    private Set<String> distinctTokens;

    
    /**
     * This constructor initializes the distinctTokens array
     */
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
     * @param token current line of text from user 
     */
    public void processToken(String token) {
        // Tests the token length after splitting to make sure there are
        // no lines without length.
        if (token.length() > 0) {
            // Splits the text line so individual tokens appear on a
            // single line.
            token.split("\\W");
            // Checks the distinctTokens variable to ensure no 
            // duplicates occur
            if (!distinctTokens.contains(token)) {
                // Adds a new unique word to the distinctTokens variable
                distinctTokens.add(token);
            }
        }
    }
    
    /**
     * This method creates a print writer object to output each unique token found
     * in the file path specified.
     * 
     * @param inputFilePath user entered input file path
     * @param outputFilePath path the unique tokens file with be saved to
     *  
     */
    public void generateOutputFile(String inputFilePath, String outputFilePath) {
        /**
         * Attempt to create a file at the specifed output path
         */
        try(PrintWriter fileOutput = new PrintWriter(new BufferedWriter(
                new FileWriter(outputFilePath)))) {
                    for (String uniqueTokens : distinctTokens) {
                        /**
                         * Prints each token to the output file
                         */
                        fileOutput.println(uniqueTokens);
                    }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("There was an error outputting the file.");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
