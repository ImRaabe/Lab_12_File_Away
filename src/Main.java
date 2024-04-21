import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Path;
import javax.swing.JFileChooser;

public class Main {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        int value = chooser.showOpenDialog(null);

        if (value == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            String fileName = selectedFile.getName();
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try {
                Scanner inFile = new Scanner(selectedFile);
                while (inFile.hasNextLine()) {
                    String line = inFile.nextLine();
                    lineCount++;
                    charCount += line.length();
                    String[] words = line.split("\\s+");
                    wordCount += words.length;
                }
                inFile.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println("Summary Report:");
            System.out.println("File Name: " + fileName);
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + charCount);
        } else {
            System.out.println("No file selected.");
        }
    }
}
