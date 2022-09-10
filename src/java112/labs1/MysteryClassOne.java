package java112.labs1;

public class MysteryClassOne {
    /** Runs the MysteryClassOne program. Output the result from mysteryMethodOne() */
    public static void main(String[] args) {
        /** Instantiate the mysteryMethodOne method */
        MysteryClassOne returnOne = new MysteryClassOne();
        /** Output the return value of mysteryMethodOne to the terminal */
        System.out.println(returnOne.mysteryMethodOne());
    }
    /** adding method to pass test */
    public int mysteryMethodOne() {
        return 1;
    }
}
