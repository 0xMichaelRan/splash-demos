<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My first JSP</title>
</head>
<body>
	<form action="PassFormInput">
		<p>Your Input</p> 
		<textarea name="userinput" rows="8" cols="35" style="overflow:auto; border:3px outset #000000;"></textarea>
		<p>Your Name</p>
		<input type="text" name="username" size="35px" placeholder="Optional">
		<br />
		<input type="submit" value="submit">
	</form>
</body>
</html>
