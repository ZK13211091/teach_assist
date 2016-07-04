package com.gao.ta.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_connector {
	
	private static String url = "jdbc:mysql://localhost:3306/scrum";
	private static String user = "root";
	private static String pwd = "";
	
	private db_connector(){
		
	}
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()throws SQLException{
			return DriverManager.getConnection(url, user, pwd);
	}
	
	public static void CloseConnection(Connection conn)throws SQLException{
		try{
			if(conn != null){
				conn.close();
			}
		}catch (SQLException e){
			
		}
	}
}
