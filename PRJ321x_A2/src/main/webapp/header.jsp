<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/home.css">
<meta charset="UTF-8">
<title>MOBILE</title>
</head>
<body>
 <div class="header">
      <h1>My Website</h1>
      <img alt="logo" src="image/hinhnenlogo.png">
    </div>

    <div class="topnav">
      <a href="#">Home</a>
      <a href="#">Products</a>
      <a href="#">About us</a>
      <a href="${pageContext.request.contextPath}/login?action=login" style="float: right">Login</a>
    </div>
</body>
</html>