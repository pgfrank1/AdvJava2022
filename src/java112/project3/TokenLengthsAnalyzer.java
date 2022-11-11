package java112.project3;

import java.util.*;
import java112.analyzer.*;
import java112.utilities.PropertiesLoader;

public class TokenLengthsAnalyzer implements PropertiesLoader, TokenAnalyzer{

    private Map<Integer, Integer> tokenLengths;
    private Properties properties;

    public TokenLengthsAnalyzer() {
        properties = new Properties(loadProperties("/project2.properties"));
    }

    public Map<Integer, Integer> getTokenLengths() {
        return tokenLengths;
    }

    @Override
    public void processToken(String token) {
        // TODO Auto-generated method stub
        int tokenLength = token.length();
        
    }

    @Override
    public void generateOutputFile(String inputFilePath) {
        // TODO Auto-generated method stub
        
    }
}
