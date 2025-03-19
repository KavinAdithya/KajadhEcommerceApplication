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
   	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/productDisplay.css"/>
</head>
<body class = "main-body">
    <div class = "outer">
    		<jsp:include page = "/WEB-INF/jsp/header.jsp"/>
	</div>
      <div class="products">        
        	
        	<c:forEach var="item" items="${products}">
        		<div class="product-outer">
        	
        			<div class="product-data">
        				<p>
        					Brand Name : ${item.brandName}
        				</p>
        				<p> Model Name : ${item.name} </p>
        				<p> Quantity : ${item.quantity} </p>
        				<p> Price : ${item.price} </p>
      
        				
        			</div>
        			<div class="product-spec">
        				<c:forEach var = "spec" items="${item.specification}">
        					<li> ${spec.key} : ${spec.value} </li>
        				</c:forEach>
        			</div>
        		</div>
        	</c:forEach>
 			
 			
        	</div>
        
        <div>
            <jsp:include page = "/WEB-INF/jsp/footer.jsp"/>
        </div>
</body>
</html>