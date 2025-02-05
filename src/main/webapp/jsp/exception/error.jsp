<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error page</title>
<link rel = "stylesheet" href="/Kajadh/css/welcome.css?v=1.0"/>
<link rel="icon" href="/Kajadh/images/kajadhlogo.webp"/>
</head>
<body class = "main-body">
	<div>
		<jsp:include page="../header.jsp"/>
	</div>
	<main>
		<div>
			<%
				Exception e = (Exception)request.getAttribute("exception");
			%>
			<h1>Oops! Something went wrong.</h1>
			<p>
				<strong>Error Details: </strong>
			</p>
			<p> Message: <%= e.getMessage() %></p>
			<p> Exception Type: <%= e.getClass().getName() %>
			<pre><% e.printStackTrace(new PrintWriter(out)); %></pre>
		</div>
	</main>
	<div>
		<jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>