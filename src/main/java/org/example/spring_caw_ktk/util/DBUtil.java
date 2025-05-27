package org.example.spring_caw_ktk.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/spring_univ_project_db";
            String user = "KTKCAW";
            String password = "1234";

            Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC 드라이버 로드
            return DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
