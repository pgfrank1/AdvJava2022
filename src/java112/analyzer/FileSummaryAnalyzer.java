package java112.analyzer;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 * This class implements the TokenAnalyzer interface. It recieves the current
 * line of text from the user entered file, splits the line further, and counts
 * each word.
 */
public class FileSummaryAnalyzer implements TokenAnalyzer{
    // Counts the total words from the user entered file.
    private int totalTokensCount;

    // Constructor that initializes the totalTokensCount variable.
    public FileSummaryAnalyzer() {
        totalTokensCount = 0;
    }

    /**
     * This getter returns the totalTokensCount variable.
     * @return total amount of tokens
     */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }
    /**
     * This method recieves the current line of text from the user entered
     * file, splits the line of text, then counts each word.
     * 
     * @param token current line of text from the user entered file.
     */
    public void processToken(String token) {
        // Checks if the current line of text has a length
        if (token.length() > 0) {
            // Split the token and place the words into an array
            String[] tokenLines = token.split("\\W");
            // Loops through the tokenLines variable
            for (String splitTokens : tokenLines) {
                // Tests the token length after splitting to make sure there are
                // no lines without length.
                if (splitTokens.length() > 0) {
                    // Counts the total tokens
                    totalTokensCount++;
                }
            }
        }
    }
    
    public void generateOutputFile(String inputFilePath, String outputFilePath)
    {
        try(PrintWriter fileOutput = new PrintWriter(new BufferedWriter(
            new FileWriter(outputFilePath)));) {
                File fileInformation = new File(inputFilePath);
                Date currentDate = new Date();
                DateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd "
                        + "HH:mm:ss z yyyy");
                fileOutput.println("Application: Text File Information\nAuthor:"
                        + " Patrick Frank\nAuthor email: pgfrank@madisoncollege"
                        + ".edu\nFile: " + fileInformation.getAbsolutePath() 
                        + "\nDate of analysis: " + currentDate + "\nLast "
                        + "Modified: " + simpleDateFormat.format(fileInformation
                                .lastModified()) + "\nFile Size: "
                        + (fileInformation.length()) + "\nFile URI: "
                        + fileInformation.toURI() + "\nTotal Tokens: "
                        + totalTokensCount);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("There was an error outputting the file.");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}