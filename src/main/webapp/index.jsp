<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);	
		out.print("显示成功");
	%>
	<br/>
	<a href="test.action">test</a><br/>
	
	<form action="testForm.action" method="post">
  		<input type="text" name="username">
  		<input type="submit" value="submit">
 	</form><br/>
 	
 	<a href="register.jsp">注册</a><br/>
	
</body>
</html>