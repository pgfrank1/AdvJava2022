package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * This class counts the amount of times each distinct token appears within the
 * text file
 * 
 * @author pgfrank
 * @version 1.0
 * @since 11.0
 */
public class DistinctTokenCountsAnalyzer implements TokenAnalyzer{
    /**
     * Holds the properties file values
     */
    private Properties properties;
    /**
     * Holds the unique token and the amount of times it appears
     */
    private Map<String,Integer> distinctTokenCounts;

    /**
     * Initializes the distinctTokenCounts Map variable
     */
    public DistinctTokenCountsAnalyzer() {
        distinctTokenCounts = new HashMap<>();
    }

    /**
     * Initializes the properties variable
     * 
     * @param properties values from the properties file
     */
    public DistinctTokenCountsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * Returns the distinctTokenCounts variable
     * 
     * @return distinctTokenCounts HashMap variable
     */
    public Map<String,Integer> getDistinctTokenCounts() {
        return distinctTokenCounts;
    }

    /**
     * This method recives the tokens from the text file and counts each time
     * the token appears in the file
     *
     * @param token the current distinct token from the text file
     */
    public void processToken(String token) {
        if (distinctTokenCounts.containsKey(token)) {
            distinctTokenCounts.replace(token, distinctTokenCounts.get(token)
                    , distinctTokenCounts.get(token) + 1);
        } else {
            distinctTokenCounts.put(token, 1);
        }
        
    }
    
    /**
     * This method outputs the distinct tokens and how many times they appear
     * in its own text file
     * 
     * @param inputFilePath the user entered text file
     */
    public void generateOutputFile(String inputFilePath) {
        /**
         * Attempt to create a file at the specifed output path
         */
        try(PrintWriter fileOutput = new PrintWriter(new BufferedWriter(
                new FileWriter(properties.getProperty("output.directory")
                        + properties.getProperty("output.file.distinct.counts"))))) {
                    for (Map.Entry<String,Integer> keyValuePair : this.distinctTokenCounts.entrySet()) {
                        /**
                         * Prints each token to the output file
                         */
                        fileOutput.println(keyValuePair.getKey() + "\t"
                                + keyValuePair.getValue());
                    }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("There was an error outputting the file.");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
