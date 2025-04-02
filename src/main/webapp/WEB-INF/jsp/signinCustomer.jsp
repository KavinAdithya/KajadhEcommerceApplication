<%@ page import="com.KajadhECommerce.Kajadh.path.PagePath" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Sign In - Kajadh</title>

    <link rel="icon" href="../images/newlogo.webp"/>

    <!-- Tailwind CSS -->
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
    	main {
    		margin-top:100px;
    		margin-bottom:100px;
    	}
    </style>
</head>
<body class="bg-gray-100 flex flex-col min-h-screen">

    <!-- Header -->
    <jsp:include page="header.jsp"/>

    <!-- Main Content -->
    <main class="flex-grow flex items-center justify-center px-4">
        <div class="bg-white shadow-lg rounded-2xl p-8 max-w-md w-full border border-gray-200">
            
            <h1 class="text-3xl font-bold text-center text-gray-900 mb-6">🛍 Customer Sign In</h1>

            <form method="post" action="<%= PagePath.SIGNIN_PAGE_CUSTOMER_REDIRECT %>" class="space-y-4">
                
                <div class="flex flex-col">
                    <label for="name" class="text-sm font-medium text-gray-700 mb-1">Name</label>
                    <input type="text" id="name" name="name" required
                        class="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none transition">
                </div>

                <div class="flex flex-col">
                    <label for="email" class="text-sm font-medium text-gray-700 mb-1">Email</label>
                    <input type="email" id="email" name="email" required
                        class="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none transition">
                </div>

                <div class="flex flex-col">
                    <label for="password" class="text-sm font-medium text-gray-700 mb-1">Password</label>
                    <input type="password" id="password" name="password" required
                        class="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none transition">
                </div>

                <div class="flex flex-col">
                    <label for="secretPin" class="text-sm font-medium text-gray-700 mb-1">Secret Pin</label>
                    <input type="text" id="secretPin" name="secretPin" required
                        class="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none transition">
                </div>

                <div class="flex flex-col">
                    <label for="address" class="text-sm font-medium text-gray-700 mb-1">Address</label>
                    <textarea id="address" name="address" rows="2" placeholder="Enter Your Address" required
                        class="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none transition"></textarea>
                </div>

                <div class="flex flex-col">
                    <label for="datetime" class="text-sm font-medium text-gray-700 mb-1">Date of Birth</label>
                    <input type="date" id="datetime" name="datetime" required
                        class="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none transition">
                </div>

                <button type="submit"
                    class="w-full bg-gradient-to-r from-blue-500 to-blue-700 text-white py-3 rounded-lg font-semibold hover:opacity-90 transition duration-300 shadow-md">
                    Sign In
                </button>

            </form>
        </div>
    </main>

    <!-- Footer -->
    <jsp:include page="footer.jsp"/>

</body>
</html>
