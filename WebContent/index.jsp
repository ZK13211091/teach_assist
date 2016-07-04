<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login.jsp" >
用户名：<input  name="name"></br>
密码：<input type="text" name="pwd"></br>
角色：<select name="role">
		<option value="student" >学生</option>
		<option value="teacher">教师</option>
    </select>
    </br>
    
    <input type="submit" value="登陆">
    <input type="reset" value="取消">

</form>
</body>
</html>