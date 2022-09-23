package java112.labs1;

import java.io.*;

/**
 * This program takes a file specified by the user and then outputs each line
 * to a new file named by the user
 * 
 * @author pgfrank
 */
public class LabSix {
    /**
     * The main method checks to make sure there are 2 arguments. If there is,
     * call the run method and send the 2 arguments to that method.
     * 
     * @param args user entered arguments for file input and output
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line"
                    + ", an input file name and an output file name");
        } else {
            LabSix output = new LabSix();
            output.run(args[0], args[1]);
        }
    }
    /**
     * The run method takes 2 parameters, reads the specified input file, and
     * outputs each line of the input file to a new file named by the user.
     * 
     * @param inputFilePath user entered file input
     * @param outputFilePath user entered file output
     */
    public void run(String inputFilePath, String outputFilePath) {
        // Create an input and output reader and writer respectfully.
        BufferedReader inputReader = null;
        PrintWriter outputWriter = null;
        // Create a variable to hold each line of the input file
        String line = null;
        // Attempt to open the input file, read each line of the input file,
        // and output each line to the new file.
        try {
            inputReader = new BufferedReader(new FileReader(inputFilePath));
            outputWriter = new PrintWriter(new BufferedWriter(
                    new FileWriter(outputFilePath)));
            
            while (inputReader.ready()) {
                line = inputReader.readLine();
                outputWriter.println(line);
            }

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File was not found");
        } catch (IOException ioException) {
            System.out.println("File could not be read");
        } catch (Exception exception) {
            System.out.println("A problem has occured");
            exception.printStackTrace();
        } finally {
            // Attempt to close the input and output files.
            try {
                if (outputWriter != null && inputReader != null) {
                    outputWriter.close();
                    inputReader.close();
                }
            } catch (IOException ioException) {
                System.out.println("There was an error attempting to close "
                        + "the file.");
            }
        }
    }
}
