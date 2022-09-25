package java112.analyzer;

import java.util.*;

public class DistinctTokensAnalyzer implements TokenAnalyzer {
    private Set<String> distinctTokens;

    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }

    public DistinctTokensAnalyzer() {
        distinctTokens = new TreeSet<>();

    }

    public void processToken(String token) {

    }
    
    public void generateOutputFile(String inputFilePath, String outputFilePath) {
        
    }
}
