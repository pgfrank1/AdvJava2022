package java112.labs1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This application creates a list and output that list to a file with a
 * specified name.
 * 
 * @author pgfrank
 */

public class LabSeven {
    // Create an instance of the ArrayList class
    ArrayList<String> outputList;

    /**
     * The main method checks the args to make sure only one argument has been
     * entered.
     * @param args command line args
     */
    public static void main(String[] args) {
        /** Checks to see if the user has entered some arguments or too many.*/
        if (args.length != 1){
            System.out.println("Please enter one argument on the command line,"
                    + " an output file name");
        } else {
            /** Instantiate a LabSeven object to be able to call the run method,
             *  then send the user's arguments to the run method.
             */
            LabSeven output = new LabSeven();
            output.run(args[0]);
        }
    }

    /**
     * This method instantiates the ArrayList named outputList, writes the
     * numbers 1 thru 10 then sends the ArrayList to the writeListToOutputFile
     * method.
     * @param fileName user entered file name
     */
    public void run(String fileName) {
        outputList = new ArrayList<>();

        outputList.add("one");
        outputList.add("two");
        outputList.add("three");
        outputList.add("four");
        outputList.add("five");
        outputList.add("six");
        outputList.add("seven");
        outputList.add("eight");
        outputList.add("nine");
        outputList.add("ten");

        writeListToOutputFile(fileName);
    }

    /**
     * This method creates a PrintWriter object to be able to write the file
     * name with all 10 number strings to the file name/path specified.
     * @param fileName user entered file name
     */
    public void writeListToOutputFile(String fileName) {
        // Create an input and output reader and writer respectfully.
        PrintWriter outputWriter = null;

        try {
            outputWriter = new PrintWriter(new BufferedWriter(
                    new FileWriter(fileName)));
            
            for (String numbers : outputList) {
                outputWriter.println(numbers);
            }
        } catch (IOException ioException) {
            System.out.println("File could not be made");
        } catch (Exception exception) {
            System.out.println("A problem has occured");
            exception.printStackTrace();
        } finally {
            // Attempt to close the input and output files.
            if (outputWriter != null) {
                outputWriter.close();
            }
        }
    }
}
