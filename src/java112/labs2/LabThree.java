package java112.labs2;

import java.util.*;
import java.io.*;

public class LabThree {

    public static void main(String[] args) {
        if (args.length == 1) {
            LabThree run = new LabThree();
            run.run(args[0]);
        } else {
            System.out.println("Please enter only 1 argument");
        }
    }

    public void loadProperties(String propertiesFilePath)  {
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

    public void run(String args) {
        loadProperties(args);
    }
}
