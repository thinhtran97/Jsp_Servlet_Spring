<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/home.css">
<meta charset="UTF-8">
<title>ADMIN</title>
</head>
<body>
 <%@ page import="controller.*" %>
    <%@ page import="model.*" %>
    <% String admin = (String)session.getAttribute("sessuser"); %>
<div class="header">
      <h1>LOGIN SUCCESS </h1>
      <p>USER: <%= admin %></p>
    </div>

    <div class="topnav">
      <a href="#">Home</a>
      <a href="#">Products</a>
      <a href="#">About us</a>
      <a href="${pageContext.request.contextPath}/logout?action=logout" style="float: right">Logout</a>
    </div>
    
   
    
</html>