package com.gao.ta.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gao.ta.model.course;
import com.gao.ta.util.db_connector;

public class courseManager {
	
	public static List<course> showlist()throws SQLException{
		Connection conn = db_connector.getConnection();
		
		String sql = "select * from course";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		List<course> list = new ArrayList<course>();
		while(rs.next()){
			course c = new course();
			c.setcName(rs.getString("cName"));
			c.setCourseid(rs.getInt("courseid"));
			list.add(c);
		}
		
		db_connector.CloseConnection(conn);
		return list;
	}
}
