package java112.analyzer;

import java.io.*;


/**
 * This class recieves the user entered argument and ensures that only one
 * argument was entered. It then feeds each line of the input file to the
 * openInputFile and writeOutputFiles methods.
 * 
 * @author pgfrank
 */
public class FileAnalysis {
    // Declare needed constants
    static final int COMMAND_ARGS = 1;
    static final String OUTPUT_PATH = "./output/";

    // Initialize 2 classes
    private FileSummaryAnalyzer summaryAnalyzer;
    private DistinctTokensAnalyzer distinctAnalyzer;

    /**
     * This constructor instantiates the two analyzer variables, summaryAnalyzer
     * and distinctAnalyzer
     */
    public FileAnalysis() {
        summaryAnalyzer = new FileSummaryAnalyzer();
        distinctAnalyzer = new DistinctTokensAnalyzer();
    }

    /**
     * This method recieves the user entered argument and determines if there
     * was only one argument passed. If so, send the user's argument to the
     * openInputFile and writeOutputFiles methods.
     * 
     * @param arguments user entered input file
     */
    public void analyze(String[] arguments) {
        passUserFile(testForOneArgument(arguments));
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
                userInputFile))){
                    while (input.ready()) {
                        String fileLineInput = input.readLine();
                        passUserFile(fileLineInput);
                    }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File was not found. Please try again.");
        } catch (IOException ioException) {
            System.out.println("There was an issue trying to open"
                    + "the file.");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    /**
     * This method passes the user entered file to each Analyzer class
     * 
     * @param userInputFile user entered input file
     */
    public void passUserFile(String userInputFile) {
        distinctAnalyzer.processToken(userInputFile);
        summaryAnalyzer.processToken(userInputFile);
    }

    /**
     * This method calls upon the generateOutputFiles from both\
     * distinctAnalyzer and summaryAnalyzer classes. It sends the user entered
     * file and the desired output path to the methods.
     * 
     * @param userInputFile user entered input file
     */
    public void writeOutputFiles(String userInputFile) {
        distinctAnalyzer.generateOutputFile(userInputFile, OUTPUT_PATH
                + "distinct_tokens.txt");
        summaryAnalyzer.generateOutputFile(userInputFile, OUTPUT_PATH
                + "summary.txt");
    }

    public String testForOneArgument(String[] userInput) {
        if (userInput.length != COMMAND_ARGS) {
            System.out.println("You have not entered the correct amount of"
                    + " arguments. Please only enter 1 argument.");
        }
        return userInput[0];
    }
}