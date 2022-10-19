package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * This class finds any unique token that is at or longer than 14 characters
 * 
 * @author pgfrank
 * @version 1.0
 * @since 11.0
 */
public class LargestTokensAnalyzer implements TokenAnalyzer{

    /**
     * Holds the property file values
     */
    private Properties properties;
    /**
     * Holds the tokens that are longer than 14 characters
     */
    private Set<String> largestTokens;
    /**
     * Holds the min length for the unique tokens
     */
    private int minimumTokenLength;

    /**
     * Instantiates the largestTokens  instance variable
     */
    public LargestTokensAnalyzer() {
        largestTokens = new TreeSet<>();
    }

    /**
     * Instantiates the properties and minimumTokenLength instance variables
     * 
     * @param properties property file values
     */
    public LargestTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        minimumTokenLength = Integer.parseInt(properties
                .getProperty("largest.words.minimum.length"));
    }

    /**
     * Returns all tokens that are at least 14 characters long
     * 
     * @return largestTokens holds all tokens that are 14 characters long or 
     * more
     */
    public Set<String> getLargestTokens() {
        return largestTokens;
    }

    /**
     * This method recieves each line of the user txt file and adds each
     * unique word to distinctTokens
     * 
     * @param token current line of text from user 
     */
    public void processToken(String token) {
        // Adds a new unique word to the distinctTokens variable
        if (token.length() >= minimumTokenLength) {
            largestTokens.add(token);

        }
    }

    /**
     * This method creates a print writer object to output each unique token found
     * in the file path specified.
     * 
     * @param inputFilePath user entered input file path
     *  
     */
    public void generateOutputFile(String inputFilePath) {
        /**
         * Attempt to create a file at the specifed output path
         */
        try(PrintWriter fileOutput = new PrintWriter(new BufferedWriter(
                new FileWriter(properties.getProperty("output.directory")
                        + properties.getProperty("output.file.largest.words"))))) {
                    for (String longUniqueTokens : largestTokens) {
                        /**
                         * Prints each token to the output file
                         */
                        fileOutput.println(longUniqueTokens);
                    }
        } catch (IOException ioException) {
            System.out.println("There was an error outputting the file.");
            ioException.printStackTrace();
        } catch (Exception exception) {
            //TODO:
            exception.printStackTrace();
        }
    }
}
