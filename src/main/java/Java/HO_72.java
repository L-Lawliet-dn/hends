import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

public class Activity13 {
    public static void main(String[] args) {
        try {
            // Create a new text file and write text into it
            File textFile = new File("sample.txt");
            FileUtils.writeStringToFile(
                    textFile,
                    "Hello! This is text written into the file.",
                    StandardCharsets.UTF_8
            );

            // Get the file using FileUtils.getFile()
            File file = FileUtils.getFile("sample.txt");

            // Read the file using readFileToString()
            String content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            System.out.println("Original file content:");
            System.out.println(content);

            // Create a new directory
            File newDirectory = new File("NewDirectory");
            FileUtils.forceMkdir(newDirectory);

            // Copy text file to the new directory
            FileUtils.copyFileToDirectory(file, newDirectory);

            // Get the copied file from the new directory
            File copiedFile = FileUtils.getFile("NewDirectory", "sample.txt");

            // Read the copied file
            String copiedContent = FileUtils.readFileToString(
                    copiedFile,
                    StandardCharsets.UTF_8
            );

            System.out.println("\nCopied file content:");
            System.out.println(copiedContent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}