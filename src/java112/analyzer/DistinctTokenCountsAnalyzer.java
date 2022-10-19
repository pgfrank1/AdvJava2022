package java112.analyzer;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/**
 * This class counts the number of times each unique token appears within a 
 * text file
 * 
 * @author pgfrank
 * @version 1.0
 * @since 11.0
 */
public class DistinctTokenCountsAnalyzer implements TokenAnalyzer{
    /**
     * Stores the key value pairs from the properties file
     */
    private Properties properties;
    /**
     * Holds the tokens and the count of each token
     */
    private Map<String,Integer> distinctTokenCounts;

    /**
     * Instantiates the distinctTokenCounts variable
     */
    public DistinctTokenCountsAnalyzer() {
        distinctTokenCounts = new TreeMap<>();
    }

    /**
     * Instantiates the properties variable
     * @param properties property file keys and values
     */
    public DistinctTokenCountsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * Sends the distinctTokenCounts variable to anything that requests it
     * @return unique tokens and their occurances
     */
    public Map<String,Integer> getDistinctTokenCounts() {
        return distinctTokenCounts;
    }

    /**
     * This method recieves the tokens from the user entered file and sees if
     * distinctTokenCounts does or doesn't have the word
     * 
     * @param token unique token from the user entered file
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
     * This method generates the output file, putting the unique token and its
     * count on each line
     * 
     * @param inputFilePath user entered file location and name
     */
    public void generateOutputFile(String inputFilePath) {
        /**
         * Attempt to create a file at the specifed output path
         */
        try(PrintWriter fileOutput = new PrintWriter(new BufferedWriter(
                new FileWriter(properties.getProperty("output.directory")
                        + properties.getProperty("output.file.distinct.counts"))))) {
                    for (Entry<String, Integer> keyValuePair :
                            this.distinctTokenCounts.entrySet()) {
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
