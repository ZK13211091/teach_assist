<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
当前课程是：<%=request.getParameter("coursename") %>
<form>
<input type="button" value="资源" onclick="window.location.reload('resource.jsp?courseid=<%=request.getParameter("courseid") %>')">
<input type="button" value="作业" onclick="window.location.reload('homework.jsp')">
<input type="button" value="课程简介" >
<input type="button" value="聊天室" >
</form>
</body>
</html>