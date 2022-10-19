package java112.analyzer;

import java.io.*;
import java.util.*;

public class DistinctTokenCountsAnalyzer implements TokenAnalyzer{
    private Properties properties;
    private Map<String,Integer> distinctTokenCounts;

    public DistinctTokenCountsAnalyzer() {
        distinctTokenCounts = new HashMap<>();
    }

    public DistinctTokenCountsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    public Map<String,Integer> getDistinctTokenCounts() {
        return distinctTokenCounts;
    }

    @Override
    public void processToken(String token) {
        // TODO Auto-generated method stub
        if (distinctTokenCounts.containsKey(token)) {
            distinctTokenCounts.replace(token, distinctTokenCounts.get(token)
                    , distinctTokenCounts.get(token) + 1);
        } else {
            distinctTokenCounts.put(token, 1);
        }
        
    }

    @Override
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
