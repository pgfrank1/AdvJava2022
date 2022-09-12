package java112.labs1;

import java.io.*;

/**
 * This program takes in to arguments, creates a file with a user entered name
 * for the first argument and places text within the file with the second
 * argument
 * 
 * @author pgfrank
 */
public class LabFive {
    /**
     * The main method checks to see if there has been 2 arguments entered. If
     * there is, call the run method to create the file and message within.
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line,"
                    + " a file name and a message");
        } else {
            LabFive output = new LabFive();
            output.run(args[0], args[1]);
        }
    }
    /**
     * This method takes in 2 parameters, attempts to create the file and place
     * the message within. It then closes the printWriter.
     * @param fileName
     * @param userMessage
     */
    public void run (String fileName, String userMessage) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter
            (fileName)));

            printWriter.println(userMessage);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
}
