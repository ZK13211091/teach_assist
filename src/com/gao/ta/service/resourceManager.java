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

	public static List<resource> showlist(int courseid) throws SQLException{
		Connection conn = db_connector.getConnection();
		
		String sql = "select * from rc where courseid = " + courseid;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		List<resource> list = new ArrayList<resource>();
		while(rs.next()){
			String sql1 = "select * from resource where resourceid = " + rs.getInt("resourceid");
			ResultSet rs1= st.executeQuery(sql1);
			resource r = new resource();
			r.setrName(rs1.getString("rName"));
			r.setResourceid(rs1.getInt("resourceid"));
			r.setrAddress("rAddress");
			list.add(r);
		}
		
		db_connector.CloseConnection(conn);
		return list;
	}
}
