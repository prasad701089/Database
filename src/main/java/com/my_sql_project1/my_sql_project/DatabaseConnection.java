package com.my_sql_project1.my_sql_project;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
     private final static String URL="jdbc:mysql://localhost:3306/my_second_db";
	 private final static String USER="root";
	 private final static String PASSWORD="admin";
        public static Connection con(){
            Connection connection=null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
	        	System.out.println("driver loaded successfully");
	        	connection=DriverManager.getConnection(URL,USER,PASSWORD);
                } 
            catch (Exception e) 
                {
               
                }
            return connection;
        }
}
