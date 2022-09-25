package java112.analyzer;

/**
 * 
 * @author pgfrank
 * @version 1.0
 */
public class Driver {
    public static void main(String[] args) {
        FileAnalysis runLauncher = new FileAnalysis();
        runLauncher.analyze(args);
    }
}
