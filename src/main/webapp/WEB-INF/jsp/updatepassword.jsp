<%@ page import="com.KajadhECommerce.Kajadh.path.PagePath" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kajadh - Update Password</title>

    <link rel="icon" href="/Kajadh/images/newlogo.webp"/>


    <script src="https://cdn.tailwindcss.com"></script>

 	<style>
    	body {
        	margin: 0;
        	padding: 0;
        	min-height: 100vh;
        	display: flex;
        	flex-direction: column;
    	}
    	main {
        	flex: 1; 
    	}
	</style>
 	
</head>
<body class="bg-gray-100 text-gray-900" >

    <div class="mb-12">
    	<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	</div>

    <main class="flex flex-col items-center justify-center w-full px-4">
        <div class="bg-white shadow-lg rounded-2xl p-8 max-w-md w-full border border-gray-200">

            
            <h1 class="text-3xl font-bold text-center text-gray-900 mb-6">🔑 Update Password</h1>

            <form action="<%=PagePath.UPDATE_PASSWORD_SERVLET %>" method="post" class="space-y-6">
                
                <div class="flex flex-col">
                    <label for="email" class="text-sm font-medium text-gray-700 mb-1">Email</label>
                    <input type="email" id="email" name="email" required
                        class="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none transition">
                </div>

                <div class="flex flex-col">
                    <label for="password" class="text-sm font-medium text-gray-700 mb-1">New Password</label>
                    <input type="password" id="password" name="password" required
                        class="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none transition">
                </div>

                <div class="flex flex-col">
                    <label for="secretPin" class="text-sm font-medium text-gray-700 mb-1">Secret Pin</label>
                    <input type="number" id="secretPin" name="secretPin" required
                        class="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none transition">
                </div>

                <button type="submit"
                    class="w-full bg-gradient-to-r from-blue-500 to-blue-700 text-white py-3 rounded-lg font-semibold hover:opacity-90 transition duration-300 shadow-md">
                    Update Password
                </button>

            </form>
        </div>    
    </main>
    
    <div class="mt-12">
        <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
    </div>

</body>
</html>
