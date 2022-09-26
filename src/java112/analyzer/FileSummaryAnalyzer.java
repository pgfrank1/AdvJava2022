package java112.analyzer;

public class FileSummaryAnalyzer implements TokenAnalyzer{
    private int totalTokensCount;

    public FileSummaryAnalyzer() {

    }

    public int getTotalTokensCount() {
        return totalTokensCount;
    }


    public void processToken(String token) {
        token.split("\\W");
        if (token.length() != 0) {
            token.split("\\W");
            System.out.println(token);
        }
    }
    
    public void generateOutputFile(String inputFilePath, String outputFilePath) {
        
    }
}
