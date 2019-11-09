package Avaj.AvajWriter;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * creating and writing to file
 */
public class Writer {
    private static File file = null;
    private static FileWriter fileWriter = null;
    private static BufferedWriter output = null;

    public Writer() {
        try {
            file = new File("Christina.txt");
            fileWriter = new FileWriter(file);
            output = new BufferedWriter(fileWriter);
        } catch (IOException e) {
        }
    }

    public void writer(String str) {
        try {
            output.write(str);
            output.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeFile() {
        try {
            if (output != null)
                output.close();
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }
}


