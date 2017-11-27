<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>product</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>

<body>
   <div class="container">
   
   
<%@ include file="header.jsp" %>

<hr>
              ${product.productName}  <br>  ${product.productPrice} <br> ${product.productCategory.categoryName} <br> 

<img src="${pageContext.request.contextPath}/${product.productImage}" height="100" width="100">


   <br><br>
     <a href="${pageContext.request.contextPath}/addToCart/${product.productId}" class="btn btn-info btn-lg">
     <span class="glyphicon glyphicon-shopping-cart"></span>addToCart</a>
     
     </div>
     
</body>
</html>