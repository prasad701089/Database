package com.my_sql_project1.my_sql_project;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySqlProjectApplication {

	public static void main(String[] args) throws SQLException{
		//insertion();
	//	read();
	delete();

	}
		private static void delete() throws SQLException
		{
			Connection con=DatabaseConnection.con();
			String query="DELETE FROM EMPLOYEE WHERE ID=2";
			Statement st=con.createStatement();
			int count=st.executeUpdate(query);
			if(count>0)
			{
				System.out.println("data removed successfully");
			}
			else{
				System.out.println("data removed unsuccessful");
			}
		}
		private static void read() throws SQLException{
			Connection con = DatabaseConnection.con();
			Statement st=con.createStatement();
			String sql="SELECT * FROM EMPLOYEE";
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
				System.out.println("Employee Id:"+rs.getInt(1));
				System.out.println("Employee First Name:"+rs.getString(2));
				System.out.println("employee Last Name:"+rs.getString(3));
				System.out.println("employee Email id:"+rs.getString(4));
				System.out.println("employee Phone no:"+rs.getString(5));
				System.out.println("employee Address:"+rs.getString(6));
				System.out.println("-------------------------------------------------------");
			}

		}
		private static void insertion()
		{
		
		try{
		//Connection con=DatabaseConnection.con();
		
		Connection con = DatabaseConnection.con();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Id:");
		int id=sc.nextInt();
		System.out.println("Enter your First Name:");
		String FName=sc.next();
		System.out.println("Enter your Last Name:");
		String LName=sc.next();
		System.out.println("Enter your Email:");
		String Email=sc.next();
		System.out.println("Enter your Phone no:");
		String Phoen_no=sc.next();
		System.out.println("Enter your Address:");
		String Address=sc.next();
		String query="INSERT INTO EMPLOYEE VALUES("+id+",'"+FName+"','"+LName+"','"+Email+"','"+Phoen_no+"','"+Address+"')";
		System.out.println("connect");
		Statement st=con.createStatement();
		int count=st.executeUpdate(query);
		if(count>0)
		{
			System.out.println("data inserted succesfully");
		}
		else{
			System.out.println("data inserted failed");
		}
		st.close();
		
		}
		catch(Exception e){
			System.out.println("connection failed");
			e.printStackTrace();
		}
		}
		
	}


