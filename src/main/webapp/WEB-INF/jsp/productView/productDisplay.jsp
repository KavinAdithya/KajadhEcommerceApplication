<%@ page isELIgnored="false" %>
<%@ page import= "java.util.List, 
					com.KajadhECommerce.Kajadh.Entities.Product, 
					com.KajadhECommerce.Kajadh.SpringContext.Contex,
					com.KajadhECommerce.Kajadh.business.productModule.ProductOperation" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Kajadh</title>
	<link rel="icon" href="${pageContext.request.contextPath}/images/kajadhlogo.webp">
   	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/welcome.css"/>
</head>
<body class = "main-body">
    <div class = "outer">
    		<jsp:include page = "/WEB-INF/jsp/header.jsp"/>
		
        <div class = "middle-content">

        </div>
        
        	<%
        		List<Product> products = (List<Product>)request.getAttribute("products");
        	%>
        	
        	<%= products.get(0) %>
        	
        	<c:forEach var="item" items="${products}">
        		<p>${item}</p>
        	</c:forEach>
        	
        	<c:forEach var="i" begin="1" end="5">
        		<p> Item : <c:out value="${i}"/></p>        		
        	</c:forEach>
        	
        
        <div>
            <jsp:include page = "/WEB-INF/jsp/footer.jsp"/>
        </div>
    </div>
</body>
</html>