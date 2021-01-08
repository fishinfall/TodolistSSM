<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>
	Welcome! Please login:
	<!-- <form action="LoginServlet" method="post">  -->
		<form action="login.do" method="post">

		Username: <input type="text" name="username"/><br/>
		Password:  <input type="text" name="password"/><br/>
		<input type="submit" value="提交"/>
	</form>
	<c:out value='${loginresponse}'/>
	
	Or you can sign up as below:
	<!-- <form action="LoginServlet" method="post">  -->
		<form action="signup.do" method="post">

		Username: <input type="text" name="username"/><br/>
		Password:  <input type="text" name="password"/><br/>
		Repeat password： <input type="text" name="passwordrepeat"/><br/>
		<input type="submit" value="提交"/>
	</form>
	<c:out value='${signupmsg}'/>

</body>
</html>