
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee-site</title>
</head>
<body>
	<form action="addEmployee" method="get">
		<input type="text" name="empName" placeholder="Enter Employee name">
		<input type="number" name="empAge" min="18" max="60"
			placeholder="Enter Age"> <input type="text" name="empDept"
			placeholder="Enter Department"> <input type="submit"
			value="Add employee">
	</form>

	<table border="solid black 1px">
		<thead>
			<tr>
				<th>Id</th>
				<th>Employee name</th>
				<th>Age</th>
				<th>Dept</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="idTemp" value="${0}"/>
			<c:forEach var="empModel" items="${empModel}">
				<tr>
					<td><c:set var="idTemp" value="${idTemp + 1}"/><c:out value="${idTemp}" /></td>
					<td>${empModel.empName}</td>
					<td>${empModel.age}</td>
					<td>${empModel.dept}</td>
					<td><a href="deleteEmployee?empId=${empModel.empid}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>