package java112.analyzer;

import java.io.*;
import java.text.*;
import java.util.*;

public class FileSummaryAnalyzer implements TokenAnalyzer{
    private int totalTokensCount;

    public FileSummaryAnalyzer() {
        totalTokensCount = 0;
    }

    public int getTotalTokensCount() {
        return totalTokensCount;
    }


    public void processToken(String token) {
        if (token.length() > 0) {
            // Split the token and place the words into an array
            String[] tokenLines = token.split("\\W");
            // Loops through the tokenLines variable
            for (String splitTokens : tokenLines) {
                // Tests the token length after splitting to make sure there are
                // no lines without length.
                if (splitTokens.length() > 0) {
                    totalTokensCount++;
                }
            }
        }
    }
    
    public void generateOutputFile(String inputFilePath, String outputFilePath)
    {
        try(PrintWriter fileOutput = new PrintWriter(new BufferedWriter(
            new FileWriter(outputFilePath + "summary.txt")));) {
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
