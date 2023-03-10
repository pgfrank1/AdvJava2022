package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * This class looks at the input txt file and analyzes each unique token within
 * the file. It then outputs distinct_tokens.txt file of all words on their own
 * line.
 * 
 * @author pgfrank
 * @since 11.0
 * @version 1.1
 */
public class DistinctTokensAnalyzer implements TokenAnalyzer {
    /**
     * Stores every unique token from the user entered file.
     */
    private Set<String> distinctTokens;

    /**
     * Stores the key value pairs from the properties file
     */
    private Properties properties;

    /**
     * This constructor initializes the distinctTokens set
     * 
     */
    public DistinctTokensAnalyzer() {
        distinctTokens = new TreeSet<>();
    }

    /**
     * This constructor initializes the distinctTokens array
     * @param properties the key value pair from the properties file
     */
    public DistinctTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * This method returns the value of distinctTokens
     * @return distinctTokens Set for unique words
     */
    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }
    
    /**
     * This method recieves each line of the user txt file and adds each
     * unique word to distinctTokens
     * 
     * @param token current line of text from user 
     */
    public void processToken(String token) {
        // Adds a new unique word to the distinctTokens variable
        distinctTokens.add(token);
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
                        + properties.getProperty("output.file.distinct"))))) {
                    for (String uniqueTokens : distinctTokens) {
                        /**
                         * Prints each token to the output file
                         */
                        fileOutput.println(uniqueTokens);
                    }
        } catch (IOException ioException) {
            System.out.println("There was an error outputting the file.");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was an error...");
            exception.printStackTrace();
        }
    }
}