<%@ page import="java.io.PrintWriter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error - Kajadh</title>
    <link rel="stylesheet" href="/Kajadh/css/welcome.css?v=1.1"/>
    <link rel="icon" href="/Kajadh/images/kajadhlogo.webp"/>
    <style>
        main {
            padding: 40px;
            text-align: center;
            background-color: #fff3f3;
            border: 1px solid #ffc2c2;
            border-radius: 10px;
            margin: 40px auto;
            max-width: 800px;
        }
        h1 {
            color: #c62828;
            font-size: 2rem;
            margin-bottom: 20px;
        }
        p {
            font-size: 1rem;
            color: #333;
            margin-bottom: 10px;
        }
        pre {
            text-align: left;
            background-color: #f8f8f8;
            border: 1px solid #ccc;
            padding: 15px;
            overflow-x: auto;
            border-radius: 5px;
        }
    </style>
</head>
<body class="main-body">
    <div>
        <jsp:include page="../header.jsp"/>
    </div>

    <main>
        <%
            Exception e = (Exception) request.getAttribute("exception");
        	String message = (String) request.getAttribute("meassage");
        %>

        <h1>⚠️ Oops! Something went wrong.</h1>

        <% if (e != null) { %>
            <p><strong>Error Message:</strong> <%= e.getMessage() %></p>
            <p><strong>Exception Type:</strong> <%= e.getClass().getName() %></p>
            <pre><%= e.printStackTrace() %></pre>
        <% } else { %>
            <p>No detailed error information available.</p>
            <p><%=message%></p>
        <% } %>

        <p><a href="/Kajadh/index.jsp" style="color: #0077cc; text-decoration: underline;">Go back to Home</a></p>
    </main>

    <div>
        <jsp:include page="../footer.jsp"/>
    </div>
</body>
</html>
