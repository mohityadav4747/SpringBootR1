<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(event)){
	$("#contactEmail").blur(function(){
		var emailId=$("#contactEmail").val();
		$.ajax({
			type:"Get",url:"validateEmail?email="+emailId,success:fuction(data){
				if(data=="Duplicate"){
              $("#dupEmailMsg").innerHtml="duplicateEmalil";
              $("#contactEmail").focus();
					}}})
		})
}
</script>
</head>
<body style="background-image: url('https://sm.mashable.com/mashable_in/seo/1/13445/13445_5s8f.jpg')">
<center>
<fieldset style="width: 60px;height: 160px;color:violet">
	<table>
		<form:form action="save" method="POST" modelAttribute="Contact">
			<tr>
				<td>SNO:</td>
				<td><form:input type="text" path="contactId" /></td>
			</tr>
			<tr>
				<td>NAME:</td>
				<td><form:input type="text" path="contactName" /></td>
			</tr>
			<tr>
				<td>EMAIL:</td>
				<td><form:input type="text" path="contactEmail" /></td>
			</tr>
			<tr>
				<td>PHON:</td>
				<td><form:input type="text" path="contactNumber" /></td>
			</tr>
			<td colspan="2"><input type="submit" value="Update"><br>
			</td>
		</form:form>
		<a href="view"style="color: cyan">View All Contact</a>
		<br>

	</table>
</fieldset></center>
</body>
</html>