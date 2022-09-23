package java112.labs1;

import java.io.*;
import java.util.*;

/**
 * This program uses the SortedSet class to create a file that has no repeats.
 * 
 * @author pgfrank
 */
public class LabEight {
    // Initialize the SortedSet instance variable
    SortedSet<String> sortedNumbers;

    /**
     * The main method checks to make sure there is only one argument in the
     * terminal. If there is only one argument, create and instatiate a LabEight
     * variable and call the run method.
     * @param args user entered file name
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line,"
                    + " an output file name");
        } else {
            LabEight outputSet = new LabEight();
            outputSet.run(args[0]);
        }
    }

    /**
     * This method takes the user's entered file name and instantiates the 
     * instance variable. It then adds 10 words to the TreeSet and then calls
     * the writeSetToOutputFile method.
     * 
     * @param fileName user entered file name
     */
    public void run(String fileName) {
        sortedNumbers = new TreeSet<>();
        
        sortedNumbers.add("one");
        sortedNumbers.add("one");
        sortedNumbers.add("five");
        sortedNumbers.add("two");
        sortedNumbers.add("four");
        sortedNumbers.add("two");
        sortedNumbers.add("three");
        sortedNumbers.add("three");
        sortedNumbers.add("four");
        sortedNumbers.add("three");

        writeSetToOutputFile(fileName);
    }

    /**
     * This method creates a PrintWriter object to output the TreeSet variable
     * to an external file.
     * 
     * @param fileName user entered file name
     */
    public void writeSetToOutputFile(String fileName) {
        PrintWriter outputWriter = null;

        try {
            outputWriter = new PrintWriter(new BufferedWriter(
                    new FileWriter(fileName)));
            for (String number : sortedNumbers) {
                outputWriter.println(number);
            }
        } catch(IOException ioException) {
            System.out.println("File could not be made");
        } catch (Exception exception) {
            System.out.println("A problem has occured");
            exception.printStackTrace();
        } finally {
            if(outputWriter != null) {
                outputWriter.close();
            }
        }
    }
}
