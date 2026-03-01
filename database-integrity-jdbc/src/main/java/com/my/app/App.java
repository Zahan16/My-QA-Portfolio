package com.my.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main(String[] args) {
        String url = "jdbc:sqlite:test.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println();
                // Connect to the database
                System.out.println("Connection to the database is successful");
                System.out.println();

                // Set up test data
                Statement setupStmt = conn.createStatement();
                setupStmt.execute("CREATE TABLE IF NOT EXISTS clients (id INTEGER PRIMARY KEY, name TEXT, email TEXT)");
                setupStmt.execute("INSERT INTO clients (name, email) VALUES ('John Doe', NULL)");

                // Run the data integrity check
                String query = "SELECT COUNT(*) AS null_email_count FROM clients WHERE email IS NULL";
                ResultSet rs = setupStmt.executeQuery(query);

                if (rs.next()) {
                    int badDataCount = rs.getInt("null_email_count");
                    
                    // Output the test result
                    if (badDataCount > 0) {
                        System.out.println("Test failed: Found " + badDataCount + " records with no email address.");
                    } else {
                        System.out.println("Test passed: No data integrity issues found.");
                    }
                    System.out.println();
                }
            }        
        } catch (SQLException e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
    }
}
