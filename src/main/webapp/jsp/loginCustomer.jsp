<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Log In</title>
<link rel = "stylesheet" href="../css/welcome.css?v=1.0"/>
    <link  rel="icon" href="../images/kajadhlogo.webp"/>
</head>
<body class = "main-body">

	<div>
		<jsp:include page="header.jsp"/>
	</div>
	<main>
		<div>
			<h1> Customer Authentication </h1>
			<form action="login" method="post">
				<input placeholder = "E-mail" type="email" name="email" required /><br>
				<input placeholder = "Password" type="password" name="password" required/><br>
				<button type="submit">Submit</button>
			</form>
		</div>
	</main>
	<div>
		<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>