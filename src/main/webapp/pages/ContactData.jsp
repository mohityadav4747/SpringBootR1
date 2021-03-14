<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url('https://www.itprotoday.com/sites/itprotoday.com/files/styles/article_featured_retina/public/955974214.jpg?itok=6U-m-vxK');">
<h1 style="color:orange">WELCOME TO CONTACT DETAILS PAGE</h1>
+<a href="reg" style="color:blue">ADD NEW CONTACT</a>
<table border="1">
		<thead style="color:lightgreen">
			<tr>
				<td>Contact ID</td>
				<td>Contact Name</td>
				<td>Contact Email</td>
				<td>Contact Number</td>
				<td>Created Date</td>
				<td>Updated Date</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="c">
				<tr>
					<td>${c.contactId}</td>
					<td>${c.contactName}</td>
					<td>${c.contactEmail}</td>
					<td>${c.contactNumber}</td>
					<td>${c.createdDate}</td>
					<td>${c.updatedDate}</td>
					
					<td><a href="edit?contactId=${c.contactId }" style="color: blue">Edit</a>
				        <a href="delete?contactId=${c.contactId }" style="color: red">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	${msg }
</body>
</html>