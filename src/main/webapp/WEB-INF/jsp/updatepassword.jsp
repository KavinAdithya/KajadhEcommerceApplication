<%@ page import="com.KajadhECommerce.Kajadh.path.PagePath" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kajadh-Update</title>
	<link rel = "stylesheet" href="/Kajadh/css/welcome.css?v=1.0"/>
    <link rel="icon" href="/Kajadh/images/kajadhlogo.webp"/>
    <link rel = "stylesheet" href = "/Kajadh/css/signin.css?v=1.0"/>
    <link rel = "stylesheet" href = "/Kajadh/css/login.css?v=1.0"/>
    
</head>
<body class = "main-body">
	<div>
		<jsp:include page="header.jsp"/>
	</div>
	
	<main  class = "main-class">
		
		<div class = "login-box">
		<form class = "form-login" action=<%=PagePath.UPDATE_PASSWORD_SERVLET %> method="post">
				<h1 class = "login-heading" style="margin-left:20px;"> Customer Password Update</h1>
				<input class = "email" placeholder = "E-mail" type="email" name="email" required /><br>
				<input class = "password" placeholder = "Password" type="password" name="password" required/><br>
				<input class = "secretPin" placeholder = "Secret Pin" type="number" name="secretPin" required/>
				<button class = "submit" type="submit">Submit</button>
			</form>
		</div>	
	
	</main>
	
</body>
</html>