package java112.labs2;

import java.util.*;
import java.io.*;

/**
 * This program shows how Hash and Tree maps are different and how they can 
 * work together.
 * 
 * @author pgfrank
 * @version 1.0
 * @since 1.0
 * 
 */
public class LabTwoFour {
    
    private Map<String,Integer> newHashMap;
    private Map<String,Integer> newTreeMap;
    /**
     * The main method creates an instance of itself and calls upon the run
     * method
     * 
     * @param args user entered arguments
     */
    public static void main(String[] args) {
        LabTwoFour run = new LabTwoFour();
        run.run();
    }

    /**
     * This method instantiates the Tree and Hash map and assigns values to them
     * The two maps then output their contents to show their differences.
     *
     */
    public void run() {
        // Instantiates the hash map
        this.newHashMap = new HashMap<String,Integer>();
        
        // Add values to the hash map
        this.newHashMap.put("One", 1);
        this.newHashMap.put("Four", 4);
        this.newHashMap.put("Two", 2);
        this.newHashMap.put("Three", 3);

        // Instantiate the tree map using the has map key value pair
        this.newTreeMap = new TreeMap<String,Integer>(newHashMap);
        
        // Outputs the contents of each hash map and if there is a key named
        // "Three"
        System.out.println("Hash Map:");
        for (Map.Entry<String, Integer> entry : this.newHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + "  Value: "
                    + entry.getValue());
        }

        if (this.newHashMap.containsKey("Three")) {
            System.out.println("\nHash Map contains Three");
        } else {
            System.out.println("\nThe Map did not contain Three");
        }

        System.out.println("\nTree Map:");
        for (Map.Entry<String, Integer> entry : this.newTreeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + "  Value: "
                    + entry.getValue());
        }
    }
}
