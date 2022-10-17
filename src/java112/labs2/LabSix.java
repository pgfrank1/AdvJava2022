package java112.labs2;

import java.util.*;
import java112.utilities.PropertiesLoader;
import java.io.*;

/**
 * This class opens a properties file and reads off the properties within.
 * 
 * @author pgfrank
 * @version 1.0
 * @since 1.0
 */
public class LabSix implements PropertiesLoader{

    /**
     * The main method checks to make sure the user has entered only 1 argument
     * and sends that argument to the run method.
     * 
     * @param args user entered properties file path
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            /**
             * Instantiate and initialize a LabSix object
             */
            LabSix run = new LabSix();
            run.run(args[0]);
        } else {
            System.out.println("Please enter only 1 argument");
        }
    }

    /**
     * Simply calls upon the loadProperties method and sends the user entered
     * properties file path.
     * 
     * @param args user entered property file
     */
    public void run(String args) {
        System.out.println(loadProperties(args));
    }
}
