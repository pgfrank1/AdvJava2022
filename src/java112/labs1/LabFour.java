/** This program simply attempts to open a file a user specifies and output each line of the file.
 * 
 * @author pgfrank
 */

package java112.labs1;

// Import the needed classes
import java.io.*;

/** This class contains the main method to be able to run our file reader program */
public class LabFour {
    public static void main(String[] args) {
        /** Checks to see if the user has entered some arguments or too many.*/
        if (args.length != 1){
            System.out.println("Please enter one argument on the command line");
        } else {
            /** Instantiate a LabFour object to be able to call the run method,
             *  then send the user's arguments to the run method.
             */
            LabFour output = new LabFour();
            output.run(args[0]);
        }
    }
    /**
     * This method recieves the user's input and attempts to open the file.
     * @param input
     */
    public void run (String input) {
        /** Makes sure that the "finally" exception can get the reader variable. */
        BufferedReader reader = null;
        /** Attempt to open the file specified by the user */
        try {
            reader = new BufferedReader(new FileReader(input));

            // While the reader sees something that can be read, output those lines to the terminal.
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        /** Catch all of the possible erros that may occur and tell the user 
         * detailed information on why there was an issue.
         */
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File was not found. Please try retyping the file");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("File could not be read");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was a problem.");
            exception.printStackTrace();
        } finally {
            /**Close the file after everything has been read */
            try {
                if (reader != null) {
                reader.close();
                }
            } catch (Exception exception) {
                System.out.println("There was a problem closing the file");
                exception.printStackTrace();
            }
        }
    }
}
