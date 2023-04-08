<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file = "css/bootstrapCss.jsp" %>
<title>PAGINATION</title>
</head>
<body>
 <div class="container-fluid">
	<div class="card-deck">
	<c:forEach begin="0" end="2" items = "${listP}" var = "o">
		<div class="card col-lg-3 col-md-3 col-sm-3 mb-md-0 mx-3 my-3">
		<a href="${pageContext.request.contextPath}/InformationProductController?id=${o.id}"><img src="${o.src}" class="card-img-top my-3" alt="..."></a>
	    <div class="card-body">
	      <h5 class="card-title">${o.type}</h5>
	      <p class="card-text" ><a class="text-dark" href="${pageContext.request.contextPath}/InformationProductController?id=${o.id}">${o.name}</a></p>
	      <p class="card-text text-danger font-weight-bold">$${o.price}</p>
	    </div>
	    
	  </div>
	 
	</c:forEach>
	</div>

	<!--  <div class="card-deck"> 
	<c:forEach begin="3" end="5" items = "${listP}" var = "o">
		<div class="card col-lg-3 col-md-3 col-sm-3 mb-md-0 mx-3 my-3">
	    <a href="${pageContext.request.contextPath}/InformationProductController?id=${o.id}"><img src="${o.src}" class="card-img-top my-3" alt="..."></a>
	    <div class="card-body">
	      <h5 class="card-title">${o.type}</h5>
	      <p class="card-text"><a class="text-dark" href="${pageContext.request.contextPath}/InformationProductController?id=${o.id}">${o.name}</a></p>
	      <p class="card-text text-danger font-weight-bold">$${o.price}</p>
	    </div>
	  </div> 
	</c:forEach>
	</div>-->


	<nav aria-label="Page navigation example ">
	  <ul class="pagination mt-3">
	  <c:if test="${indexPage > 1}">
	    <li class="page-item ">
	      <a class="page-link rounded-circle" href="${pageContext.request.contextPath}/PagingController?index=${indexPage - 1}" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	        <span class="sr-only">Previous</span>
	      </a>
	    </li>
	  </c:if>
	  <c:forEach begin="1" end="${endP}" var="i">
	  	<li class="page-item ${indexPage == i? 'active':'' }"><a class="page-link rounded-circle" href="${pageContext.request.contextPath}/PagingController?index=${i}" tabindex="-1">${i}</a></li>
	  </c:forEach>
	  <c:if test="${indexPage < endP}"> 
	     <li class="page-item ">
	      <a class="page-link rounded-circle" href="${pageContext.request.contextPath}/PagingController?index=${indexPage + 1}" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	        <span class="sr-only">Next</span>
	      </a>
	    </li>
	  </c:if> 
	  </ul>
	</nav>
</div>




</body>
</html>