package java112.analyzer;

import java.util.*;

public class DistinctTokensAnalyzer implements TokenAnalyzer {
    private Set<String> distinctTokens;

    public DistinctTokensAnalyzer() {
        distinctTokens = new TreeSet<>();

    }

    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }


    public void processToken(String token) {
        System.out.println(token);
    }
    
    public void generateOutputFile(String inputFilePath, String outputFilePath) {
        
    }
}
