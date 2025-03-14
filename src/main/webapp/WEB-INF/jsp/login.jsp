<%@ page import="com.KajadhECommerce.Kajadh.path.PagePath" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Log In</title>
	<link rel="icon" href="${pageContext.request.contextPath}/images/kajadhlogo.webp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/welcome.css?v=1.0"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css?v=1.0"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/signin.css?v=1.0"/>
	
    <style type="text/css">
    
    </style>
</head>
<body class = "main-body">

	<div>
		<jsp:include page="header.jsp"/>
	</div>
	<main class = "main-class">
		<%
			String type = request.getParameter("type");
		
			type = Character
					.toUpperCase(type.charAt(0)) + 
					 type.substring(1)
					.toLowerCase();
			
			PagePath path = PagePath.LOGIN_PAGE_ADMIN_REDIRECT;
			
			if (type.equalsIgnoreCase("customer"))
				path = PagePath.LOGIN_PAGE_CUSTOMER_REDIRECT;
			
		%>
		<div class = "login-box">
			
			<form class = "form-login" action=<%=path%> method="post">
				<h1 class = "login-heading"><%=type%> Authentication </h1>
				<input class = "email" placeholder = "E-mail" type="email" name="email" required /><br>
				<input class = "password" placeholder = "Password" type="password" name="password" required/><br>
				
			<% if (type.equals("Customer"))  { %>
			<button class = "submit" type="submit" style="margin-bottom:0px;">Submit</button><br>
				<a href=<%=PagePath.UPDATE_PASSWORD_SERVLET%> class = "forgot-password"> forgot password </a>
			<% } else { %>
				<button class = "submit" type="submit">Submit</button>
			<% } %>
			</form>
		</div>
	</main>
	<div>
		<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>