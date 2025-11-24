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
                String sql = "CREATE TABLE IF NOT EXISTS courses (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT NOT NULL, " +
                        "code TEXT NOT NULL, " +
                        "credit REAL NOT NULL, " +
                        "teacher1 TEXT, " +
                        "teacher2 TEXT, " +
                        "grade TEXT" +
                        ");";

                Statement stmt = conn.createStatement();
                stmt.execute(sql);

            }

        } catch (SQLException e) {
        }
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
