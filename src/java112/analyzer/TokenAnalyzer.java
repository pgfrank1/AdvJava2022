package java112.analyzer;

public interface TokenAnalyzer {
    void processToken(String token);
    void generateOutputFile(String inputFilePath, String outputFilePath);
}
