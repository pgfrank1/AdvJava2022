package java112.analyzer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class TokenLengthsAnalyzer implements TokenAnalyzer{

    private Map<Integer, Integer> tokenLengths;
    private Properties properties;


    public TokenLengthsAnalyzer() {
        tokenLengths = new TreeMap<>();
    }

    public TokenLengthsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
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

                    printTokenLengths(fileOutput);

                    fileOutput.println("");

                    printTokenHistogram(fileOutput);

        } catch (IOException ioException) {
            System.out.println("There was an error outputting the file.");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was an error...");
            exception.printStackTrace();
        }
        
    }

    public void printTokenLengths(PrintWriter fileOutput) {
        for (Map.Entry<Integer, Integer> keyValuePair : 
                this.tokenLengths.entrySet()) {
            /**
             * Prints each token to the output file
             */
            fileOutput.println(keyValuePair.getKey() + "\t"
                    + keyValuePair.getValue());
}
    }

    public void printTokenHistogram(PrintWriter fileOutput) {
        String star = "*";

        for (Map.Entry<Integer, Integer> keyValuePair :
                this.tokenLengths.entrySet()) {
            int amountPerStar = Collections.max(tokenLengths.values()) / 80;
            int histogramAmount = keyValuePair.getValue() / amountPerStar;

            if (histogramAmount == 0) {
                histogramAmount = 1;
            }

            // Used https://www.studytonight.com/java-examples/how-to-multiply-string-in-java to be able to repeat the stars
            fileOutput.println(keyValuePair.getKey() + "\t"
                    + star.repeat(histogramAmount));
            }
    }
}
