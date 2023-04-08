<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Welcome login page</h1>
<div style="color:red"> ${error} </div>

<form action="login.html" method="post">
<table>
<tr>
<td><input type="text" name ="username" value="${param.username}"/></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password" value="${param.password}"/></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" name="submit">
<input type="reset" name="reset">
</td>
</tr>
</table>
</form>


</body>
</html>