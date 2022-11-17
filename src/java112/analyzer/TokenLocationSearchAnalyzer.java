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
            List<Integer> currentTokenPlacements;
            currentTokenPlacements = foundLocations.get(token);
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
                //fileOutput.println(entry.getValue());
                for (String list : entryList) {
                    //fileOutput.println(list);
                    if (entryList[entryList.length - 1].equals(list)) {
                        fileOutput.println(test + list + "\n");
                        break;
                    }
                    if ((test.length() + list.length()) >= 80) {
                        fileOutput.println(test.trim());
                        test = list + ", ";
                        continue;
                    } else {
                        test += list + ", ";
                    }
                }


                //fileOutput.println(entry.getKey() + " =\n" + entryList + "\n");

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
     * Gets search tokens.
     */
    public void getSearchTokens() {
        try (
                InputStream inputStream = this.getClass().getResourceAsStream(
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
            //System.out.println(searchTokens);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
