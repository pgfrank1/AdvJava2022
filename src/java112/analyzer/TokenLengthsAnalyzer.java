package java112.analyzer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 * This class calculates each time a word of a particular length occurs within
 * any text file. It then outputs each word length and occurance on a line. It
 * then outputs a histogram to the text file using "*" with a max of 80
 *
 * @author pgfrank
 * @version 1.0
 * @since 11
 */
public class TokenLengthsAnalyzer implements TokenAnalyzer{
    private Map<Integer, Integer> tokenLengths;
    private Properties properties;


    /**
     * Instantiates a new Token lengths TreeMap.
     */
    public TokenLengthsAnalyzer() {
        tokenLengths = new TreeMap<>();
    }

    /**
     * Instantiates a new Token lengths analyzer.
     *
     * @param properties analyzer.properties
     */
    public TokenLengthsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * Gets token lengths.
     *
     * @return the token lengths
     */
    public Map<Integer, Integer> getTokenLengths() {
        return tokenLengths;
    }

    /**
     * Checks the length of each token, saves that length, and adds 1 if the
     * length has already been found
     *
     * @param token user entered file current line of text
     */
    public void processToken(String token) {
        int tokenLength = token.length();

        //if (tokenLength == 0) {
        //   return;
        //}

        if (!tokenLengths.containsKey(tokenLength)) {
            tokenLengths.putIfAbsent(tokenLength, 1);

        } else {
            tokenLengths.replace(tokenLength, tokenLengths.get(tokenLength) + 1);
        }
    }

    /**
     * Outputs the occurrence of each string length when it occurs
     *
     * @param inputFilePath the user entered file path and name.
     */
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

    /**
     * Outputs the occurance of each word length in the text file
     *
     * @param fileOutput the file output
     */
    public void printTokenLengths(PrintWriter fileOutput) {
        for (Map.Entry<Integer, Integer> keyValuePair : this.tokenLengths.entrySet()) {
            /**
             * Prints each token to the output file
             */
            fileOutput.println(keyValuePair.getKey() + "\t"
                    + keyValuePair.getValue());
}
    }

    /**
     * Outputs the histogram to the given text file location.
     *
     * @param fileOutput the file output
     */
    public void printTokenHistogram(PrintWriter fileOutput) {
        String star = "*";

        float amountPerStar = (float) Collections.max(tokenLengths.values()) / 75;

        for (Map.Entry<Integer, Integer> keyValuePair :
                this.tokenLengths.entrySet()) {

            float histogramAmount = (float) keyValuePair.getValue() / amountPerStar;

            if (histogramAmount < 1) {
                fileOutput.println(keyValuePair.getKey() + "\t" + star);
            } else {
                fileOutput.println(keyValuePair.getKey() + "\t"
                        + star.repeat(Math.round(histogramAmount)));
            }
        }
    }
}
