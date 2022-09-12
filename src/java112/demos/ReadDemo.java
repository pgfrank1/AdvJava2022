package java112.demos;

import java.io.*;

public class ReadDemo {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            // FileReader reader = new FileReader("input.txt");
            // BufferedReader bufferedReader = new BufferedReader(reader);
            reader = new BufferedReader(new FileReader("input.txt"));
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("File could not be read");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was a problem.");
            exception.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                reader.close();
                }
            } catch (Exception exception) {
                System.out.println("There was a problem closing the file");
                exception.printStackTrace();
            }
        }
    }

    
}
