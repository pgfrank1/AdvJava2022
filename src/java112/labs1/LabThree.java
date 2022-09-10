package java112.labs1;

public class LabThree {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Please enter one argument on the command line");
        } else {
        LabThree output = new LabThree();
        output.run(args[0]);
        }
    }
    public void run(String input) {
        System.out.println("input: " + input);
    }
}
