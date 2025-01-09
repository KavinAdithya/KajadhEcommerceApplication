<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Log In</title>
	<link rel = "stylesheet" href="../css/welcome.css?v=1.0"/>
    <link rel="icon" href="../images/kajadhlogo.webp"/>
    <link rel = "stylesheet" href = "../css/signin.css"/>
    <link rel = "stylesheet" href = "../css/login.css"/>
</head>
<body class = "main-body">

	<div>
		<jsp:include page="header.jsp"/>
	</div>
	<main class = "main-class">
		<%
			String type = request.getParameter("type");
		%>
		<div class = "login-box">
			
			<form class = "form-login" action="../Login/<%= type %>" method="post">
				<h1 class = "login-heading"><%= type %> Authentication </h1>
				<input class = "email" placeholder = "E-mail" type="email" name="email" required /><br>
				<input class = "password" placeholder = "Password" type="password" name="password" required/><br>
				<button class = "submit" type="submit">Submit</button>
			</form>
		</div>
	</main>
	<div>
		<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>