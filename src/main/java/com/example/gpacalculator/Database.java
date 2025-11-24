package com.example.gpacalculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Database {

    private static final String DB_URL = "jdbc:sqlite:gpacalculator.db";

    public static void initialize() {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {

            if (conn != null) {


                System.out.println("Database initialized successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
