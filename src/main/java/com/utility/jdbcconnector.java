package com.utility;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcconnector {
	public static String getparticulardata() throws SQLException {
		String url="jdbc:mysql://localhost:3306/employees";
		String username="root";
		String password="Gy168@02";
		String query="select * from employees";
		//connection establish
		Connection connection=DriverManager.getConnection(url, username, password);
		//create a statement
		Statement statement=connection.createStatement();
		//execute query
		ResultSet result=statement.executeQuery(query);
        result.next();
        String first_name=result.getString(3);
        System.out.println(first_name);
        return first_name;
	}
	
		
	
	public static void main(String[] args) throws SQLException {
		getparticulardata();
		
	}
	

}
