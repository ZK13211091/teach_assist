<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.gao.ta.model.*" %>
<%@ page import="com.gao.ta.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	if(session.getAttribute("role")!=null){
		String role = (String)session.getAttribute("role");
		List<course>list = courseManager.showlist();
		%><strong>当前角色：<%=role%></br></strong>
		
		<%for(course c : list){%>
		<a href="coursedetail.jsp?coursename=<%=c.getcName()%>&courseid=<%=c.getCourseid()%>"><%= c.getcName() %></a>
		<%}
	}
	%>
</body>
</html>