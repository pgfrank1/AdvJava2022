package java112.project3;

import java.util.*;
import java.io.*;
import java112.analyzer.*;
import java112.utilities.PropertiesLoader;

public class TokenLengthsAnalyzer implements PropertiesLoader, TokenAnalyzer{

    private Map<Integer, Integer> tokenLengths;
    private Properties properties;

    public TokenLengthsAnalyzer() {
        properties = new Properties(loadProperties("/analyzer.properties"));
    }

    public Map<Integer, Integer> getTokenLengths() {
        return tokenLengths;
    }

    @Override
    public void processToken(String token) {
        int tokenLength = token.length();
        if (tokenLength == 0) {
            return;
        }
        if (tokenLengths.containsKey(tokenLength)) {
            tokenLengths.replace(tokenLength, tokenLengths.get(tokenLength) + 1);
            return;
        }
        tokenLengths.putIfAbsent(tokenLength, 1);

        
    }

    @Override
    public void generateOutputFile(String inputFilePath) {
    /**
     * Attempt to create a file at the specifed output path
     */
        try(PrintWriter fileOutput = new PrintWriter(new BufferedWriter(
                new FileWriter(properties.getProperty("output.directory")
                        + properties.getProperty("output.file.token.lengths"))))) {
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
            System.out.println("There was an error...");
            exception.printStackTrace();
        }
        
    }
}
