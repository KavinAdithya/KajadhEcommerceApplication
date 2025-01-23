<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign in Admin</title>
    <link rel="stylesheet" href = "../css/signin.css?v=1.0"/>
    <link rel = "stylesheet" href="../css/welcome.css?v=1.0"/>
    <link  rel="icon" href="../images/kajadhlogo.webp"/>
</head>
<body style="background-color: rgb(135, 230, 235); margin :0px;" >
    <div>
        <div>
			<jsp:include page="header.jsp"/>
		</div>
        <div class = "signin-form">
            <form action="/Kajadh/SignIn/Admin" method="post">
                <h1 class="customer" style="margin-left: 160px;">
                    Admin 
                </h1>
                <input type = "text" name="name" placeholder="Name" required/>
                <input type = "email" name="email" placeholder="E-mail" required/>
                <input type = "password" name="password" placeholder="Password" required/>  
                <button class = "submit" type = "submit">Submit</button>
            </form>
        </div>
        <div>
			<jsp:include page="footer.jsp"/>
		</div>
    </div>
</body>
</html>