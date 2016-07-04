package com.gao.ta.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gao.ta.model.teacher;
import com.gao.ta.util.db_connector;

public class teacherManager {

	public static boolean teacherLogin(teacher tea)throws SQLException{
		boolean result = false;
		Connection conn = db_connector.getConnection();
		
		String sql = "select * from teacher where tName='"+tea.gettName()+"' and tPwd='"+tea.gettPwd()+"'";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()){
			result = true;
		}
		
		db_connector.CloseConnection(conn);
		return result;
	}
}
