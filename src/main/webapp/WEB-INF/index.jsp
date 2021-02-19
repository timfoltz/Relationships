<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All People</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Number</th>
				<th>State</th>
				<th>Expiration Date</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${people }" var="person">
				<tr>
					<td><c:out value="${person.id }"/></td>
					<td><a href="/persons/${person.id}"><c:out value="${person.firstName }"/><c:out value="${person.lastName }"/></a></td>
					<td><c:out value="${person.license.number }"/></td>
					<td><c:out value="${person.license.state }"/></td>
					<td><c:out value="${person.license.expirationDate }"/></td>
					
				</tr>
			</c:forEach>
		</tbody>	
	</table>
	<a href="/persons/new">Create Person</a>
	<a href="/licenses/new">Create License</a>

</body>
</html>