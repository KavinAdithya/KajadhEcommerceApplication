<%@ page import="com.KajadhECommerce.Kajadh.Entities.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Place Order | Kajadh</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100">
    <%
        Product item = (Product) request.getAttribute("product");
    %>

    <!-- Container -->
    <div class="max-w-3xl mx-auto mt-10 bg-white p-8 shadow-md rounded-lg">
        <h1 class="text-2xl font-bold text-gray-800 mb-6">Place Your Order</h1>

        <!-- Product Details -->
        <div class="flex items-start space-x-6 mb-6">
            <img src="<%= item.getImageAdd() %>" alt="Product Image" class="w-32 h-32 object-cover rounded-lg shadow-sm">
            <div>
                <h2 class="text-lg font-semibold text-gray-700"><%= item.getName() %></h2>
				<div class="text-xs text-gray-600">
                     <c:forEach var="spec" items="${item.specification}">
                         <p><span class="font-medium">${spec.key}:</span> ${spec.value}</p>
                     </c:forEach>
                </div>
                <p class="mt-2 text-blue-600 font-bold text-lg">₹ <%= item.getPrice() %></p>
            </div>
        </div>
        
        <form method="post" action="${pageContext.request.contextPath}/placeorder">
            <input type="hidden" name="productId" value="<%= item.getId() %>">

            <div class="mb-4">
                <label class="block text-sm font-medium text-gray-700 mb-1">Quantity</label>
                <input type="number" name="quantity" value="1" min="1"
                       class="w-24 px-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
            </div>

            <div class="mb-4">
                <label class="block text-sm font-medium text-gray-700 mb-1">Shipping Address</label>
                <textarea name="address" rows="3" required
                          class="w-full px-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"></textarea>
            </div>

            <button type="submit"
                    class="w-full bg-blue-500 hover:bg-blue-600 text-white font-semibold py-2 px-4 rounded-lg transition">
                Confirm Order
            </button>
        </form>
    </div>
</body>
</html>
