package Hotel.Management.System;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class Connecting {

    final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String DB_URL = "jdbc:mysql://localhost:3306/hotelMS";
    final static String USER = "root";
    final static String PASS = "123456";
    Connection connection;
    Statement statement;
    public Connecting(){
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
