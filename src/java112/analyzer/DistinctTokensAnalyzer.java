package java112.analyzer;

import java.util.*;

public class DistinctTokensAnalyzer implements TokenAnalyzer {
    private Set<String> distinctTokens;
    int testingCounter;

    public DistinctTokensAnalyzer() {
        distinctTokens = new TreeSet<>();
        testingCounter = 0;
    }

    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }


    public void processToken(String token) {
        if (token.length() > 0) {
            String[] tokenLines = token.split("\\W");
            for (String splitTokens : tokenLines) {
                if (splitTokens.length() > 0) {
                    splitTokens.split("\\W");
                    System.out.println(splitTokens);
                    if (!distinctTokens.contains(splitTokens)) {
                        testingCounter++;
                        distinctTokens.add(splitTokens);
                        System.out.println(testingCounter);
                        //System.out.println(distinctTokens + "\nTESTING");
                    }
                }
                /*if (!distinctTokens.contains(splitTokens)) {
                    distinctTokens.add(splitTokens);
                    System.out.println(distinctTokens + "\nTESTING");
                }
                splitTokens.split("\\W");
                if (splitTokens.length() != 0) {
                    distinctTokens.add(splitTokens);
                    System.out.println(distinctTokens);
                }*/
            }
        }
    }
    
    public void generateOutputFile(String inputFilePath, String outputFilePath) {
        
    }
}
