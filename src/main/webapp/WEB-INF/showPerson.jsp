<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${person.firstName} ${person.lastName}</title>
</head>
<body>
	<h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
<p>License Number <c:out value="${person.license.number}"/></p>
<p>State <c:out value="${person.license.state}"/></p>
<p>Expires <c:out value="${person.license.expirationDate}"/></p>
<p></p>
<br>
<br>
<br>

<a href="/">Go Back</a>

</body>
</html>