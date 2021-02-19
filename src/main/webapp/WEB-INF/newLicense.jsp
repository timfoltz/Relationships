<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New License</title>
</head>
<body>
<h1>New License</h1>
<form:form action="/licenses" method="post" modelAttribute="license">
    <p>
        <form:select path="person">
	        <c:forEach items="${person }" var="person">
					<form:option value="${person}">
						<c:out value="${person.firstName}"/> 
							<c:out value="${person.lastName }"/>-
							<c:out value="${person.id }"/>
					</form:option>
				</c:forEach>
        </form:select>
    </p>
    <p>
        <form:label path="state">State</form:label>
        <form:errors path="state"/>
        <form:input required="true" path="state"/>
    </p>
    <p>
        <form:label path="expirationDate">Expires</form:label>
        <form:errors path="expirationDate"/>
        <form:input type="date" required="true" path="expirationDate"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>