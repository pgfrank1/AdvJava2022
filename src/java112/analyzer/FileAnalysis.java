package java112.analyzer;

import java.io.*;
import java.util.*;
import java112.utilities.PropertiesLoader;


/**
 * This class recieves the user entered argument and ensures that only one
 * argument was entered. It then feeds each line of the input file to the
 * openInputFile and writeOutputFiles methods.
 * 
 * @author pgfrank
 * @since 11.0
 * @version 1.1
 */
public class FileAnalysis implements PropertiesLoader{
    /**
     * The amount of arguments the user is allowed to have.
     */
    static final int COMMAND_ARGS = 2;

    /**
     * Holds each of the analyzer classes
     */
    private List<TokenAnalyzer> analyzers;

    /**
     * This constructor instantiates the two analyzer variables, summaryAnalyzer
     * and distinctAnalyzer
     */
    public FileAnalysis() {
        //summaryAnalyzer = new FileSummaryAnalyzer();
        //distinctAnalyzer = new DistinctTokensAnalyzer();
        analyzers = new ArrayList<TokenAnalyzer>();
    }

    /**
     * This method recieves the user entered argument and determines if there
     * was only one argument passed. If so, send the user's argument to the
     * openInputFile and writeOutputFiles methods.
     * 
     * @param arguments user entered input file
     */
    public void analyze(String[] arguments) {
        if (testForTwoArguments(arguments)) {
            createAnalyzerClasses(loadProperties(arguments[1]));
            openInputFile(arguments[0]);
            writeOutputFiles(arguments[0]);
        } else {
            System.out.println("You have not entered the correct amount of"
                    + " arguments. Please only enter 1 argument.");
        }
    }

    /**
     * This method adds each analyzer class to the analyzers List
     * 
     * @param properties the key value pairs from the properties file
     */
    public void createAnalyzerClasses(Properties properties) {
        analyzers.add(new FileSummaryAnalyzer(properties));
        analyzers.add(new DistinctTokensAnalyzer(properties));
        analyzers.add(new LargestTokensAnalyzer(properties));
        analyzers.add(new DistinctTokenCountsAnalyzer(properties));
        //analyzers.add(new LexicalDensityAnalyzer(properties));
    }
    
    /**
     * This method recieves the user entered arguments and ensures that there
     * is only 1 argument entered. If there is only one, it returns true
     * 
     * @param userInput user entered arguments
     * @return true or false if there is only one argument
     */
    public Boolean testForTwoArguments(String[] userInput) {
        // Returns true or false
        return (userInput.length == COMMAND_ARGS);
    }

    /**
     * This class takes the user entered file, attempts to open the file
     * specified then sends each line of the file to the passUserFile method.
     * It also catches any Exception that is likely to occur.
     * 
     * @param userInputFile user entered input file
     */
    public void openInputFile(String userInputFile) {
        try (BufferedReader input = new BufferedReader(new FileReader(
                userInputFile))) {
                    while (input.ready()) {
                        // Reads each line from the user entered file
                        String fileLineInput = input.readLine();
                        // Check the current line of the user entered file
                        passUserFile(fileLineInput);
                    }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File was not found. Please try again.");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("There was an issue trying to open"
                    + "the file.");
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    /**
     * This method passes the user entered file to each Analyzer class if the 
     * length of the current line of text is more than 0
     * 
     * @param userInputFile user entered input file
     */
    public void passUserFile(String userInputFile) {
        if (userInputFile.length() > 0) {
            // Split the text of the current file line
            splitUserFileText(userInputFile);
        }
    }

    /**
     * Splits the current line of text and iterates through each word of the
     * line of text.
     * 
     * @param userText line of text from the user entered file
     */
    public void splitUserFileText(String userText) {
            // Split the token and place the words into an array
            String[] tokenLines = userText.split("\\W");
            // Send the newly made array to the sendTokenForProcessing method
            sendTokenForProcessing(tokenLines);
    }

    /**
     * This method checks to make sure each token has a length more than 0 and
     * sends the current token to distinctAnalyzer and summaryAnalyzer.
     * 
     * @param tokens current line of text from the user entered file now split
     */
    public void sendTokenForProcessing(String[] tokens) {
        // Loops through the recieved array
        for (String splitTokens : tokens) {
            // If the length of the current token is more than 0, process
            // the token
            if (splitTokens.length() > 0) {
                analyzers.get(0).processToken(splitTokens);
                analyzers.get(1).processToken(splitTokens);
                analyzers.get(2).processToken(splitTokens);
                analyzers.get(3).processToken(splitTokens);
            }
        }
    }
    /**
     * This method calls upon the generateOutputFiles from both
     * distinctAnalyzer and summaryAnalyzer classes. It sends the user entered
     * file and the desired output path to the methods.
     * 
     * @param userInputFile user entered input file
     */
    public void writeOutputFiles(String userInputFile) {

        analyzers.get(0).generateOutputFile(userInputFile);
        analyzers.get(1).generateOutputFile(userInputFile);
        analyzers.get(2).generateOutputFile(userInputFile);
        analyzers.get(3).generateOutputFile(userInputFile);
        //analyzers.get(4).generateOutputFile(userInputFile);

        /* distinctAnalyzer.generateOutputFile(userInputFile, OUTPUT_PATH
                + "distinct_tokens.txt");
        summaryAnalyzer.generateOutputFile(userInputFile, OUTPUT_PATH
                + "summary.txt");*/
        
    }
}