package com.dov.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBMain {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cesi", "root",
                    "root");

            // Create statement
            Statement statement = connection.createStatement();

            // Execute query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM region");

            // Process results
            while (resultSet.next()) {
                String code = resultSet.getString("reg_code");
                String name = resultSet.getString("reg_nom");
                System.out.println("Code: " + code + ", Name: " + name);
            }

            // // Create preparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement("insert into  region values (111, test)");

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
