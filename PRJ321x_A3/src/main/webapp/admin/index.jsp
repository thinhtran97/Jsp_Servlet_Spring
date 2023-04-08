<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../css/bootstrapCss.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/home.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid ">
		<div class="row flex-nowrap">
			<jsp:include page="../admin/header.jsp"></jsp:include>
			<div class="col-lg-10 col-md-9 col-sm-9 px-0 min-vh-100"
				style="background-color: #222F3C;">
				<jsp:include page="../admin/navLink.jsp"></jsp:include>
				<div>
				<jsp:include page="../admin/poster.jsp"></jsp:include>
				</div>
				<jsp:include page="../admin/staffList.jsp"></jsp:include>
			</div>
		</div>
	</div>
</body>
</html>