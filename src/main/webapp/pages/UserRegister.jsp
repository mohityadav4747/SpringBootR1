<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>www.user.register.in</title>
</head>
<body style="background-image: url('https://elementpack.pro/wp-content/uploads/2019/11/user-register.jpg');" >
<center >
<fieldset style="width:100px;height:370px" >
<h2 style="color:orange">WELCOME TO USER REGISTER PAGE!!!</h2>
<form action="insert" method="post">
<pre>
FirstName:<input type="text" name="firstName"/>
LastName:<input type="text" name="lastName"/>
Email:<input type="text" name="email"/>
Phone No.<input type="text" name="phone"/>
DOB:<input type="date" name="dob"/>
Gender:
<input type="radio" name="gender"/>Male
<input type="radio" name="gender"/>Female
Country:<select name="country">
<option>-Select-</option>
<option>USA</option>
<option>SINGAPORE</option>
<option>MALAYSIA</option>
<option>WASHINGTON</option>
<option>DUBAI</option>
</select>
State:<select name="state">
<option>-select-</option>
<option>California</option>
<option>Mandai</option>
<option>Kangar</option>
<option>KJ</option>
<option>FG</option>
<option>JA</option>
</select>

City:<select name="city">
<option>-select-</option>
<option>capda</option>
<option>Manak</option>
<option>Kanra</option>
<option>KJ</option>
<option>FG</option>
<option>JA</option>
</select>
</pre>
<input type="submit" name="REGISTER"/>

</form>

${msg }

</fieldset>
</center>
</body>
</html>