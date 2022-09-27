package java112.analyzer;

import java.io.*;



public class FileAnalysis {
    static final int COMMAND_ARGS = 1;
    static final String OUTPUT_PATH = "./output/";


    private FileSummaryAnalyzer summaryAnalyzer;
    private DistinctTokensAnalyzer distinctAnalyzer;
    

    public void analyze(String[] arguments) {
        if (arguments.length != COMMAND_ARGS) {
            System.out.println("You have not entered the correct amount of"
                    + " arguments. Please only enter 1 argument.");
        } else {
            summaryAnalyzer = new FileSummaryAnalyzer();
            distinctAnalyzer = new DistinctTokensAnalyzer();

            openInputFile(arguments[0]);
            writeOutputFiles(arguments[0]);       
        }
    }

    public void openInputFile(String userInputFile) {
        try (BufferedReader input = new BufferedReader(new FileReader(
                userInputFile))){
                    while (input.ready()) {
                        String fileLineInput = input.readLine();
                        distinctAnalyzer.processToken(fileLineInput);
                        summaryAnalyzer.processToken(fileLineInput);
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

    public void writeOutputFiles(String userInputFile) {
        distinctAnalyzer.generateOutputFile(userInputFile, OUTPUT_PATH);
        summaryAnalyzer.generateOutputFile(userInputFile, OUTPUT_PATH);
    }
}