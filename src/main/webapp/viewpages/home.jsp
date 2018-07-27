<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addStudent">
enter id : <input type="text" name="id"><br>
Enter Name : <input type="text" name="name"><br>
Enter rollno : <input type="text" name="roolno"><br>
<input type="submit" value="Add">
</form>
<form action="getStudent">
enter id : <input type="text" name="id"><br>
<input type="submit" value="get">
</form>
<form action="deleteStudent">
enter id : <input type="text" name="id"><br>
<input type="submit" value="delete">
</form>
</body>
</html>