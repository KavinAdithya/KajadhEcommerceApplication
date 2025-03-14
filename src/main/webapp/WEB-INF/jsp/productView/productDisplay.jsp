<%@ page import= "java.util.List, 
					com.KajadhECommerce.Kajadh.Entities.Product, 
					com.KajadhECommerce.Kajadh.SpringContext.Contex,
					com.KajadhECommerce.Kajadh.business.productModule.ProductOperation" %>
					
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        		List<Product> products = Contex.getContext()
        										.getBean(ProductOperation.class)
        										.getProducts();
        	%>
        	
        	<%= products.get(0) %>
        
        <div>
            <jsp:include page = "/WEB-INF/jsp/footer.jsp"/>
        </div>
    </div>
</body>
</html>