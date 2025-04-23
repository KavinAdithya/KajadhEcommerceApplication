<%@ page isELIgnored="false" %>
<%@ page import="java.util.List, 
					com.KajadhECommerce.Kajadh.path.PagePath,
					com.KajadhECommerce.Kajadh.Entities.Product, 
					com.KajadhECommerce.Kajadh.SpringContext.Contex,
					com.KajadhECommerce.Kajadh.business.productModule.ProductOperation" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Kajadh | Online Store</title>
	
	<script src="https://cdn.tailwindcss.com"></script>


	<link rel="icon" href="${pageContext.request.contextPath}/images/newlogo.webp">

</head>

<body class="bg-gray-100 text-gray-900">

    <div class="mb-12">
    	<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	</div>

    <div class="container mx-auto px-4">
        <h1 class="text-3xl font-bold text-center text-gray-800 mb-8">Featured Products</h1>
        
        <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
            
            <c:forEach var="item" items="${products}">
                <div class="bg-white shadow-md rounded-lg overflow-hidden transform transition-all duration-300 hover:shadow-xl">
                    
                    <!-- Product Image -->
                    <div class="relative">
                        <img class="w-full h-60 object-cover" src="${item.imageAdd}" alt="Product Image">
                        <span class="absolute top-2 left-2 bg-red-500 text-white text-xs px-2 py-1 rounded-full">New</span>
                    </div>

           
                    <div class="p-4">
                        <h2 class="text-lg font-semibold text-gray-800">${item.brandName}</h2>
                        <p class="text-gray-600 text-sm">Model: ${item.name}</p>
                        <p class="text-gray-600 text-sm">Quantity: ${item.quantity}</p>
                        <p class="text-red-500 font-bold text-lg">₹${item.price}</p>
                    </div>
                    
  
                    <div class="px-4 py-2 border-t">
                        <h3 class="text-sm font-semibold text-gray-700 mb-1">Specifications:</h3>
                        <div class="text-xs text-gray-600">
                            <c:forEach var="spec" items="${item.specification}">
                                <p><span class="font-medium">${spec.key}:</span> ${spec.value}</p>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="p-4 flex justify-between space-x-4">
                    
    <button class="w-1/2 bg-blue-500 text-white py-2 rounded-lg hover:bg-blue-600 transition text-sm">
        Add to Cart
    </button>

    <form method="post" action="<%= PagePath.BUY_NOW_REDIRECT %>" class="w-1/2">
        <input type="hidden" name="productId" value="${item.id}" />
        <button type="submit"
                class="w-full bg-red-500 text-white py-2 rounded-lg hover:bg-red-600 transition text-sm">
            Buy Now
        </button>
    </form>
</div>

                </div>
            </c:forEach>

        </div>
    </div>


    <div class="mt-12">
        <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
    </div>

</body>
</html>
