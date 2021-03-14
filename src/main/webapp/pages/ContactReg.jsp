<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body style="background-image: url('https://cdn.wedevs.com/uploads/2018/12/User-Registration-WordPress-blog-feature-image.png')">
<fieldset style="width:100px;height:300px"><legend></legend>
<h3 style="color: cyan">WELCOME TO CONTACT REGISTER PAGE</h3>
<form action="save" method="POST">
<pre style="color: white">
ContactName:<input type="text" name="contactName"/>
ContactEmail:<input type="text" name="contactEmail"/>
ContactNumber:<input type="text" name="contactNumber"/>
<input type="submit" value="SAVE CONTACT" style="color: blue">
</pre>
</form>
<p style="color: green">${msg }</p>
<p style="color: red">${errmsg }</p>
<a href="view" style="color: blue">VIEW ALL CONTACT</a>
</fieldset>
</body>
</html>