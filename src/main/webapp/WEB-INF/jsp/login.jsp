<%@ page import="com.KajadhECommerce.Kajadh.path.PagePath" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%= (request.getParameter("type") != null) ? request.getParameter("type").substring(0, 1).toUpperCase() + request.getParameter("type").substring(1).toLowerCase() : "User" %> Login</title>

    <link rel="icon" href="${pageContext.request.contextPath}/images/newlogo.webp"/>
 
    <!-- Tailwind CSS -->
    <script src="https://cdn.tailwindcss.com"></script>

    <style>
        body {
            background-color: #f3f4f6;
        }
    </style>
</head>
<body class="flex flex-col min-h-screen">

    <!-- Header -->
    <jsp:include page="header.jsp"/>

    <main class="flex-grow flex items-center justify-center px-4">
        <%
            String type = request.getParameter("type");
            if (type == null || type.isEmpty()) {
                type = "User";
            } else {
                type = Character.toUpperCase(type.charAt(0)) + type.substring(1).toLowerCase();
            }

            PagePath path = PagePath.LOGIN_PAGE_ADMIN_REDIRECT;
            if ("Customer".equalsIgnoreCase(type)) {
                path = PagePath.LOGIN_PAGE_CUSTOMER_REDIRECT;
            }
        %>

        <div class="bg-white shadow-lg rounded-xl p-8 max-w-md w-full border border-gray-200">
            <h1 class="text-2xl font-bold text-center text-gray-900 mb-6">🔐 <%= type %> Authentication</h1>

            <form action="<%= path %>" method="post" class="space-y-4">
                
                <div class="flex flex-col">
                    <label for="email" class="text-sm font-medium text-gray-700 mb-1">E-mail</label>
                    <input type="email" id="email" name="email" required
                        class="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none transition">
                </div>

                <div class="flex flex-col">
                    <label for="password" class="text-sm font-medium text-gray-700 mb-1">Password</label>
                    <input type="password" id="password" name="password" required
                        class="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none transition">
                </div>

                <button type="submit"
                    class="w-full bg-gradient-to-r from-blue-500 to-blue-700 text-white py-3 rounded-lg font-semibold hover:opacity-90 transition duration-300 shadow-md">
                    Sign In
                </button>

                <% if ("Customer".equals(type)) { %>
                    <div class="text-center mt-2">
                        <a href="<%= PagePath.UPDATE_PASSWORD_SERVLET %>" class="text-sm text-blue-600 hover:underline">
                            Forgot Password?
                        </a>
                    </div>
                <% } %>
            </form>
        </div>
    </main>

    <!-- Footer -->
    <jsp:include page="footer.jsp"/>

</body>
</html>
