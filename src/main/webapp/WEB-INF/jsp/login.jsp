<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<form:form modelAttribute="usuario" method="POST">
		<form:input id="user" type="text" path="user" placeholder="user"/>
		<form:input id="password" type="password" path="password" placeholder="password"/>
		<input id="submit" type="submit" value="Sign in"/>
	</form:form>
	${error}

</body>
</html>