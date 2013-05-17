<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gnanendra reddy_r00105486, cit</title>
</head>
<body bgcolor="silver">
	<a href="j_spring_security_logout">Logout: <security:authentication
			property="principal.username" />
	</a>
	<br>
	<br>
	<a href="home">Home</a>
	<br> User Details
	<table border="1" cellpadding="2" cellspacing="2">
		<tr>
			<th><c:out value="NAME" /></th>
			<th><c:out value="NUMBER" /></th>
			<th><c:out value="EMAIL" /></th>
		</tr>
		<tr>
			<td><c:out value="${userDetails.name}" /></td>
			<td><c:out value="${userDetails.number}" /></td>
			<td><c:out value="${userDetails.email}" /></td>

		</tr>
	</table>
</body>
</html>