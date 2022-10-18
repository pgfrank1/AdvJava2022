package java112.analyzer;

import java.io.*;
import java.util.*;

public class LargestTokensAnalyzer implements TokenAnalyzer{

    private Properties properties;
    private Set<String> largestTokens;
    private int minimumTokenLength;

    public LargestTokensAnalyzer() {
        largestTokens = new TreeSet<>();
    }

    public LargestTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        minimumTokenLength = Integer.parseInt(properties
                .getProperty("largest.words.minimum.length"));
    }

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
     * @param outputFilePath path the unique tokens file with be saved to
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
            ioException.printStackTrace();
            System.out.println("There was an error outputting the file.");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
