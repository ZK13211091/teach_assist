package com.gao.ta.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gao.ta.model.student;
import com.gao.ta.util.db_connector;

public class studentManager {
	
	public static boolean studentLogin(student stu)throws SQLException {
		boolean result = false;
		Connection conn = db_connector.getConnection();
		
		String sql = "select * from student where sName='"+stu.getsName()+"' and sPwd='"+stu.getsPwd()+"'";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()){
			result = true;
		}
		
		db_connector.CloseConnection(conn);
		return result;
	}

}
