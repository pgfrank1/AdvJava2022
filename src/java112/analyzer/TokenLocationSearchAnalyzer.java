package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * The type Token location search analyzer.
 */
public class TokenLocationSearchAnalyzer implements TokenAnalyzer {
    private Map<String, List<Integer>> foundLocations;
    private Properties properties;
    private int currentTokenLocation;

    /**
     * Instantiates the foundLocations TreeMap and currentTokenLocation.
     */
    public TokenLocationSearchAnalyzer() {
        foundLocations = new TreeMap<String, List<Integer>>();
        currentTokenLocation = 0;
    }

    /**
     * Instantiates the properties instance variable and calls the function
     * getSearchTokens()
     *
     * @param properties the properties
     */
    public TokenLocationSearchAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        getSearchTokens();
       // inputStream = this.getClass().getResourceAsStream(properties.getProperty("classpath.search.tokens"));
       // InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
       // BufferedReader searchTokensReader = new BufferedReader(inputStreamReader);

    }


    @Override
    public void processToken(String token) {
        //List<Integer> emptyList = new ArrayList<>();
        currentTokenLocation++;
        //System.out.println(searchToken + token);
        if (foundLocations.containsKey(token)) {
            List<Integer> currentTokenPlacements = foundLocations.get(token);
            currentTokenPlacements.add(currentTokenLocation);
            foundLocations.replace(token, currentTokenPlacements);
        }
    }

    @Override
    public void generateOutputFile(String inputFilePath) {
        /**
         * Attempt to create a file at the specified output path
         */
        try(PrintWriter fileOutput = new PrintWriter(new BufferedWriter(
                new FileWriter(properties.getProperty("output.directory")
                        + properties.getProperty("output.file.token.search.locations"))))) {
            for (Map.Entry<String, List<Integer>> entry : foundLocations.entrySet()) {
                String[] entryList = entry.getValue().toString().split(", ");
                String test = "";
                fileOutput.println(entry.getKey() + " =");
                if (entryList.length == 0) {
                    fileOutput.println("[]\n\n");
                    continue;
                }
                formatOutputLines(entryList, fileOutput, test);
            }
        } catch (IOException ioException) {
            System.out.println("There was an error outputting the file.");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was an error...");
            exception.printStackTrace();
        }

    }

    /**
     * Gets found locations.
     *
     * @return the found locations
     */
    public Map<String, List<Integer>> getFoundLocations() {
        return foundLocations;
    }

    /**
     * This method looks through each given word and occurance list, then
     * outputs the formatted text to the specified output file path
     *
     * @param entryList each occurance of the current word
     * @param fileOutput a PrintWriter object to output information to a text file
     * @param test holds each occurance of a word until a maximum of 80 characters
     */
    public void formatOutputLines(String[] entryList, PrintWriter fileOutput, String test) {
        for (String list : entryList) {
            if (entryList[entryList.length - 1].equals(list)) {
                if (test.length() + list.length() > 80) {
                    fileOutput.println(test + "\n" + list + "\n");
                } else {
                    fileOutput.println(test + list + "\n");
                }
                break;
            }
            if ((test.length() + list.length()) >= 80) {
                fileOutput.println(test.trim());
                test = list + ", ";
                continue;
            }
            test += list + ", ";
        }
    }

    /**
     * Gets search tokens.
     */
    public void getSearchTokens() {
        try (InputStream inputStream = this.getClass().getResourceAsStream(
                     properties.getProperty("classpath.search.tokens"));
             InputStreamReader inputStreamReader = new InputStreamReader(
                     inputStream);
             BufferedReader searchTokensReader = new BufferedReader(
                     inputStreamReader)) {
             while (searchTokensReader.ready()){
                 String searchToken = searchTokensReader.readLine();
                 if (searchToken.length() == 0) {
                    continue;
                 }
                 foundLocations.putIfAbsent(searchToken, new ArrayList<>());
            }
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
