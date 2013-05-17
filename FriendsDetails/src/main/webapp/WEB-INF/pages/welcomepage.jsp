<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>
<title>Gnanendra reddy_r00105486, cit</title>
</head>
<body bgcolor="silver">
	<a href="j_spring_security_logout">Logout: <security:authentication
			property="principal.username" />
	</a>
	<marquee class="html-marquee" direction="left" behavior="scroll"
		scrollamount="12">
		<h2>Gnanendra Friends List.</h2>
	</marquee>

	<a href="registuser.jsp"> Register New Friend</a>
	<br>
	<a href="getuserdetails.jsp">Get Registered friends Details</a>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<a href="getall">Get All User Details</a>
</body>
</html>