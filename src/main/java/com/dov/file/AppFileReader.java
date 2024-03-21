package com.dov.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AppFileReader {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            // Provide the path to your file
            String filePath = "app-file";

            // Open the file
            reader = new BufferedReader(new FileReader(filePath));

            // Read each line from the file
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    // Close the file
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
