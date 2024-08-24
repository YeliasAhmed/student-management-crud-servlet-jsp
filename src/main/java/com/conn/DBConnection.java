package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnections() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "12345678");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;

    }
}
