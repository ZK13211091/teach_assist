package com.gao.ta.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gao.ta.model.*;
import com.gao.ta.util.*;

public class resourceManager {

	public static List<resource> showlist(String Courseid) throws SQLException{
		Connection conn = db_connector.getConnection();
		
		int courseid = Integer.parseInt(Courseid);
		String sql = "select * from rc where courseid = '" + courseid+"'";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		List<resource> list = new ArrayList<resource>();
		while(rs.next()){
			String sql1 = "select * from resource where resourceid = '" + rs.getInt("resourceid") + "'" ;
			Statement st1 = conn.createStatement();
			ResultSet rs1= st1.executeQuery(sql1);
			if(!rs1.next())break;
			resource r = new resource();
			r.setrName(rs1.getString("rName"));
			r.setResourceid(rs1.getInt("resourceid"));
			r.setrAddress(rs1.getString("rAddress"));
			list.add(r);		
		}
		
		db_connector.CloseConnection(conn);
		return list;
	}
}
