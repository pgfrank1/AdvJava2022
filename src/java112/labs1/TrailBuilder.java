package java112.labs1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Trail builder reads in a CSV file containing trail data, parses each line into a trail, adds each trail to
 * a list, and returns the list.
 *
 * CSV file format must be named "trails.txt" and placed at the project root. The file must have the
 * following format:
 * <ol>
 *     <li>One trail per line</li>
 *     <li>Line format must be: trail name, trailhead city, trailhead state, trail length</li>
 *     <li>Example: Seeley Pass,Hayward,WI,8</li>
 * </ol>
 * //TODO: 3. What effect do the html tags above have on the generated javadoc?
 *
 * @author pawaite
 * @version 1.0
 * @since 1.0
 * //TODO: 4. What are @version and @since used for?
 */
public class TrailBuilder {
    /**
     * Name of the file containing the CSV trail data.
     */
    public static final String TRAIL_FILE = "trails.txt";

    /**
     * List of all trails read in from the file.
     */
    private ArrayList<Trail> trailList;

    /**
     * Gets the list of trails. This main processing method drives the workflow to create the list of trails
     * and ultimately returns that list.
     *
     * @return the trail list
     * @see Trail
     */
    public ArrayList<Trail> getTrailList() {
        createTrailList();
        readCSV();
        return trailList;
    }

    /** Create an empty list to hold the trails */
    private void createTrailList() {
        trailList = new ArrayList<>();
    }

    /**
     * Read the trail data CSV file and call a helper method to split out comma-delimited values.
     * //TODO 5. When should @throws be used?
     */
    private void readCSV() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(TRAIL_FILE))) {
            while (reader.ready()) {
                String lineOfTrailInfo = reader.readLine();
                String[] trailInfo = parseLineOfTrailInfo(lineOfTrailInfo);
                Trail trail = createTrail(trailInfo);
                addTrailToList(trail);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file, " + TRAIL_FILE + ", was not found. Please verify the file exists.");
            fileNotFoundException.printStackTrace();
        } catch (IOException IOException) {
            System.out.println("There was a problem reading the file: " + TRAIL_FILE );
            IOException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was a problem..."  );
            exception.printStackTrace();
        }
    }

    /**
     * Splits the CSV line of trail data into an array. If the line is
     * "Seeley Pass,Hayward,WI,8", the resulting array will be:
     * [0] = Seeley Pass
     * [1] = Hayward
     * [2] = WI
     * [3] = 8
     *
     * @param line single line containing comma-separated-values of trail data
     * @return trail data
     */
    private String[] parseLineOfTrailInfo(String line) {
        return line.split(",");
    }

    /**
     * Creates a Trail from an array that has four positions representing 0 - name, 1 - city, 2 - state, and
     * 3 - length.
     *
     * @param trailInfo trail data must be in the order: 0 - name, 1 - city, 2 - state, and 3 - length
     * @return trail
     * @see Trail
     */
    private Trail createTrail(String[] trailInfo) {
        String trailName =  trailInfo[0];
        String city =  trailInfo[1];
        String state =  trailInfo[2];
        int length =  Integer.parseInt(trailInfo[3]);

        Trail trail = new Trail(trailName, city, state, length);

        return trail;
    }

    /**
     * Add the trail to the list of trails.
     * @param newTrail list of trail information
     */
    private void addTrailToList(Trail newTrail) {
        trailList.add(newTrail);
    }

}
