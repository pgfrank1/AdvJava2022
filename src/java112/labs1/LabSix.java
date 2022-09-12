package java112.labs1;

import java.io.*;

public class LabSix {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line"
                    + ", an input file name and an output file name");
        } else {
            LabSix output = new LabSix();
            output.run(args[0], args[1]);
        }
    }
    public void run(String inputFilePath, String outputFilePath) {
        BufferedReader inputReader = null;
        PrintWriter outputWriter = null;
        String line = null;
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
