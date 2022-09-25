package java112.analyzer;

public class FileAnalysis {
    static final int COMMAND_ARGS = 1;   
    

    public void analyze(String[] arguments) {
        if (arguments.length != COMMAND_ARGS) {
            System.out.println("You have not entered the correct amount of"
                    + " arguments. Please only enter 1 argument.");
        } else {

        }
    }
}