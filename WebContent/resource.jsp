<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF8"%>
    <%@ page import="com.gao.ta.model.*" %>
<%@ page import="com.gao.ta.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 如果当前角色是xuesheng，那么只能看见课程的资源 如果当前角色是教师 ，那么可以还有一个上传和删除资源的选项 
     文件上传调用upload那个servlet就可以了 配置在web.xml里-->
    <% 
	if(session.getAttribute("role")!=null){
		String role = (String)session.getAttribute("role");
		List<resource>list = resourceManager.showlist(1);
	for(resource c : list){%>
	<tr>
		<td>
		<a href=<%=c.getrAddress() %> download=<%=c.getrName() %>>Name:<%=c.getrName() %> </a>
		</td></br>
	</tr>

   	<% }
	}%>
</body>
</html>