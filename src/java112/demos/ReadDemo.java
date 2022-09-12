package java112.demos;

import java.io.*;

public class ReadDemo {
    public static void main(String[] args) {
        try {
        FileReader reader = new FileReader("input.txt");
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found");
            fileNotFoundException.printStackTrace();
        }
    }

    
}
