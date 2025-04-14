<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page isELIgnored = "false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String name = (String)request.getAttribute("name");
%>

<h1>My name is
${name}
 </h1>
<h1>Hello This is help page</h1>

</body>
</html>