<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.gao.ta.model.*" %>
<%@ page import="com.gao.ta.service.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String role = request.getParameter("role");
	boolean flag = false;
	
	String name = request.getParameter("name");
	String pwd = request.getParameter("pwd");
	
	if(role.equals("student")){
		student stu = new student();
		
		
		stu.setsName(name);
		stu.setsPwd(pwd);
		
		//System.out.println(stu.getsName()+":"+stu.getsPwd());
		
		if(studentManager.studentLogin(stu)){
			flag = true;
		}
		
	}
	else{
		teacher tea = new teacher();
		
		tea.settName(name);
		tea.settPwd(pwd);
		
		if(teacherManager.teacherLogin(tea)){
			flag = true;
		}
		
	}
	
	if(flag){
		session.setAttribute("role", role);
		response.sendRedirect("courselist.jsp");
	}
	else{%>
		<script type="text/javascript">
		alert(<%="登陆失败！"%>);
		</script>
	<%}
%>

</body>
</html>