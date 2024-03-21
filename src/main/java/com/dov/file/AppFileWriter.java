package com.dov.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AppFileWriter {
    public static void main(String[] args) {
        BufferedWriter writer = null;
        try {
            // Provide the path to your file
            String filePath = "app-file";

            // Open the file for writing (append mode)
            writer = new BufferedWriter(new FileWriter(filePath, true));

            // Write data to the file
            String data = "osto gari";
            writer.write(data);

            // Write a new line
            writer.newLine();

            // Flush the buffer to ensure all data is written to the file
            writer.flush(); // Optional but good practice
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    // Close the file
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}