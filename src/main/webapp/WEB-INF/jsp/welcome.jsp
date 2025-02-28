<%@ page import="com.KajadhECommerce.Kajadh.path.PagePath" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kajadh Application</title>
	<link rel="icon" href="${pageContext.request.contextPath}/images/kajadhlogo.webp">
   	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/welcome.css"/>
</head>
<body class = "main-body">
    <div class = "outer">
    		<jsp:include page = "header.jsp"/>
		
        <div class = "middle-content">
            <div>
                <h1 class="feature-header">
                    <span style="margin-left: 10px;"></span> Welcome to Kajadh -- Your One-Stop Shopping Destination!
                </h1>
                <h3 class="gratitude-level">
                    <span style="margin-left: 10px;"></span>Thank you for choosing Kajadh.<br> 
                    <span style="margin-left: 10px;"></span>We're excited to offer you an incredible
                     shopping experience with a wide range of products at your fingertips.
                </h3>
                <h2 class = "feature-title">
                    What You Can Do with Kajadh:
                </h2>
                <dl class = "feature-list">
                    <dt>
                        Browse Wide Selection:
                    </dt>
                    <dd>
                        Explore our extensive collection of products 
                        across multiple categories.
                    </dd>
                    <dt>
                        Safe & Secure Shopping:
                    </dt>
                    <dd>
                        Shop with confidence with our
                         secure payment gateways.
                    </dd>
                    <dt>
                        Track Your Orders:
                    </dt>
                    <dd>
                        Stay updated with real-time order tracking
                         and delivery status.
                    </dd>
                    <dt>
                        Easy Returns & Support:
                    </dt>
                    <dd>
                        Hassle-free returns and 24/7 
                        customer support to assist you with any queries.
                    </dd>
                </dl>
                <h2 class = "start">
                    Ready to start shopping? Discover your favorite products now!
                </h2>
                </div>
        </div>
        <div class = "redirect">
            <div class = "admin" style="margin-left: 50px;"> 
                <p>
                    Admin !
                </p>
                <a href=<%= PagePath.SIGNIN_PAGE_ADMIN_REDIRECT %>>
                    New $
                </a>
                <span style="margin-left: 10px;"></span>
                <a href=<%= PagePath.LOGIN_PAGE_ADMIN_REDIRECT%>>
                    Already Existing !
                </a>
            </div>
            <div></div>
            <div class = "customer">
                <p>
                    Customer !
                </p>
                <a href=<%= PagePath.SIGNIN_PAGE_CUSTOMER_REDIRECT %>>
                    New $
                </a>
                <span style="margin-left: 10px;"></span>
                <a href=<%= PagePath.LOGIN_PAGE_CUSTOMER_REDIRECT %>>
                    Already Existing !
                </a>
            </div>
        </div>
        <div>
            <jsp:include page = "footer.jsp"/>
        </div>
    </div>
</body>
</html>