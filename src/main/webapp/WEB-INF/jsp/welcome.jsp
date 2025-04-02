<%@ page import="com.KajadhECommerce.Kajadh.path.PagePath" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kajadh - Your One-Stop Shopping Destination</title>

    <link rel="icon" href="${pageContext.request.contextPath}/images/newlogo.webp">

    <script src="https://cdn.tailwindcss.com"></script>
    

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/welcome.css"/>
</head>
<body class="bg-gray-100 text-gray-800">

    <jsp:include page="header.jsp"/>

    <div class="max-w-6xl mx-auto px-6 py-12 text-center">
        <h1 class="text-3xl font-bold text-gray-900">
            Welcome to <span class="text-blue-600">Kajadh</span> – Your One-Stop Shopping Destination!
        </h1>
        <p class="text-lg text-gray-600 mt-4">
            Thank you for choosing Kajadh. We’re excited to offer you an incredible shopping experience with a wide range of products at your fingertips.
        </p>
        
        <div class="mt-8 grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-2 gap-6 text-left">
            <div class="p-6 bg-white shadow-lg rounded-lg border border-gray-200">
                <h2 class="text-xl font-semibold text-gray-800">🛍️ Browse Wide Selection</h2>
                <p class="text-gray-600 mt-2">Explore our extensive collection of products across multiple categories.</p>
            </div>
            <div class="p-6 bg-white shadow-lg rounded-lg border border-gray-200">
                <h2 class="text-xl font-semibold text-gray-800">🔒 Safe & Secure Shopping</h2>
                <p class="text-gray-600 mt-2">Shop with confidence using our secure payment gateways.</p>
            </div>
            <div class="p-6 bg-white shadow-lg rounded-lg border border-gray-200">
                <h2 class="text-xl font-semibold text-gray-800">📦 Track Your Orders</h2>
                <p class="text-gray-600 mt-2">Stay updated with real-time order tracking and delivery status.</p>
            </div>
            <div class="p-6 bg-white shadow-lg rounded-lg border border-gray-200">
                <h2 class="text-xl font-semibold text-gray-800">🔄 Easy Returns & Support</h2>
                <p class="text-gray-600 mt-2">Hassle-free returns and 24/7 customer support to assist you.</p>
            </div>
        </div>

        <div class="mt-10">
            <h2 class="text-2xl font-bold text-gray-800">Ready to start shopping?</h2>
            <p class="text-gray-600">Discover your favorite products now!</p>
            <a href="${pageContext.request.contextPath}/products" class="mt-4 inline-block bg-blue-600 text-white px-6 py-3 rounded-lg shadow-lg hover:bg-blue-700 transition">
                Start Shopping
            </a>
        </div>

        <div class="mt-10 grid grid-cols-1 md:grid-cols-2 gap-6">

            <div class="bg-white shadow-lg p-6 rounded-lg border border-gray-200 text-center">
                <h3 class="text-xl font-semibold text-gray-800">👨‍💼 Admin Access</h3>
                <div class="mt-4 space-x-4">
                    <a href="<%= PagePath.SIGNIN_PAGE_ADMIN_REDIRECT %>" class="text-blue-600 font-medium hover:underline">New $</a>
                    <a href="<%= PagePath.LOGIN_PAGE_ADMIN_REDIRECT %>" class="text-red-600 font-medium hover:underline">Already Existing</a>
                </div>
            </div>

            <div class="bg-white shadow-lg p-6 rounded-lg border border-gray-200 text-center">
                <h3 class="text-xl font-semibold text-gray-800">🛒 Customer Access</h3>
                <div class="mt-4 space-x-4">
                    <a href="<%= PagePath.SIGNIN_PAGE_CUSTOMER_REDIRECT %>" class="text-blue-600 font-medium hover:underline">New $</a>
                    <a href="<%= PagePath.LOGIN_PAGE_CUSTOMER_REDIRECT %>" class="text-red-600 font-medium hover:underline">Already Existing</a>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"/>

</body>
</html>
