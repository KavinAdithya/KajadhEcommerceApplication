<%@ page import="com.KajadhECommerce.Kajadh.path.PagePath" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kajadh - Update Password</title>

    <!-- Favicon -->
    <link rel="icon" href="/Kajadh/images/kajadhlogo.webp"/>

    <!-- Tailwind CSS -->
    <script src="https://cdn.tailwindcss.com"></script>

    <!-- Custom Styles -->
    <link rel="stylesheet" href="/Kajadh/css/welcome.css?v=1.0"/>
    <link rel="stylesheet" href="/Kajadh/css/signin.css?v=1.0"/>
    <link rel="stylesheet" href="/Kajadh/css/login.css?v=1.0"/>
</head>
<body class="bg-gray-100 text-gray-800 flex flex-col min-h-screen">

    <!-- Header -->
    <jsp:include page="header.jsp"/>

    <!-- Main Content -->
    <main class="flex flex-grow items-center justify-center">
        <div class="bg-white shadow-lg rounded-lg p-8 max-w-md w-full border border-gray-200">
            
            <!-- Title -->
            <h1 class="text-2xl font-bold text-center text-gray-900 mb-6">🔑 Update Your Password</h1>

            <!-- Update Password Form -->
            <form action="<%=PagePath.UPDATE_PASSWORD_SERVLET %>" method="post" class="space-y-4">
                
                <!-- Email Input -->
                <div>
                    <label for="email" class="block text-sm font-medium text-gray-700">Email</label>
                    <input type="email" id="email" name="email" required
                        class="w-full mt-1 p-3 border rounded-lg focus:ring-2 focus:ring-blue-400 focus:outline-none">
                </div>

                <!-- Password Input -->
                <div>
                    <label for="password" class="block text-sm font-medium text-gray-700">New Password</label>
                    <input type="password" id="password" name="password" required
                        class="w-full mt-1 p-3 border rounded-lg focus:ring-2 focus:ring-blue-400 focus:outline-none">
                </div>

                <!-- Secret Pin Input -->
                <div>
                    <label for="secretPin" class="block text-sm font-medium text-gray-700">Secret Pin</label>
                    <input type="number" id="secretPin" name="secretPin" required
                        class="w-full mt-1 p-3 border rounded-lg focus:ring-2 focus:ring-blue-400 focus:outline-none">
                </div>

                <!-- Submit Button -->
                <button type="submit"
                    class="w-full bg-blue-600 text-white py-3 rounded-lg font-semibold hover:bg-blue-700 transition">
                    Update Password
                </button>

            </form>
        </div>    
    </main>

</body>
</html>
