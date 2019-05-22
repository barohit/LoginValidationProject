<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.rrb.utils.*" %>
<%@page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="default.css"> 
<title>Response Page</title>
</head>
<body>

	
	<%
	// response and request are implicit objects in JSP, so the file knows 
	//what you are talking about what you refer to them. gotcha. 
	
	String username = request.getParameter("usr"); 
	String password = request.getParameter("pass"); 
	SQLMethods sqlm = new SQLMethods();
	HashMap<String, String> userbase = sqlm.selectFromUsers();
	 
	
	
	
	if (userbase.containsKey(username)) {
		if (userbase.get(username).equals(password)) {
			out.println("Congratulations, you have logged in!");
		} else {
			out.println("Sorry, this password is incorrect"); 
		}
	} else {
		out.println("Sorry, this user does not exist"); 
	} 
	

	%>
	
	
	
	

</body>
</html>