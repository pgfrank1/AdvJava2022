package java112.labs2;

import java.util.*;
import java.io.*;

/**
 * This class opens a properties file and reads off the properties within.
 * 
 * @author pgfrank
 * @version 1.0
 * @since 1.0
 */
public class LabThree {

    /**
     * The main method checks to make sure the user has entered only 1 argument
     * and sends that argument to the run method.
     * 
     * @param args user entered properties file path
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            /**
             * Instantiate and initialize a LabThree object
             */
            LabThree run = new LabThree();
            run.run(args[0]);
        } else {
            System.out.println("Please enter only 1 argument");
        }
    }

    /**
     * This method recieves the user entered properties file path and outputs
     * the two key value pairs I have made within the properties file.
     * 
     * @param propertiesFilePath
     */
    public void loadProperties(String propertiesFilePath)  {
        /**
         * Instantiate and initialize the Properties class
         */
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
            System.out.println(properties.getProperty("author"));
            System.out.println(properties.getProperty("email.address"));
        } catch(IOException ioe) {
            System.out.println("Can't load the properties file");
            ioe.printStackTrace();
        } catch(Exception e) {
            System.out.println("Problem: " + e);
            e.printStackTrace();
        }
    }


    /**
     * Simply calls upon the loadProperties method and sends the user entered
     * properties file path.
     * 
     * @param args
     */
    public void run(String args) {
        loadProperties(args);
    }
}
