<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
 <!DOCTYPE html>
<html>
<head>
  <title>Admin Product List</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>

<body>
<%@ include file="header.jsp" %>



 <div class="container">
 <div class="row">
<div class="col-md-6" style="border:0px solid gray">
 
<h3> ${sucessMessage}</h3>  
  
<h1><b>Product List</b></h1>  
<table align="center"  width="70%"  class="table table-hover table-condensed table-bordered table-responsive">  
<tr><th>Id</th><th>Name</th><th>Price</th><th><th><th><th></th></tr>  
   <c:forEach var="product" items="${list}">   
   <tr> 
   <td>${product.productId}</td>   
   <td>${product.productName}</td>  
   <td>${product.productPrice}</td>  
   <td>${product.productImage}</td>  
  
  <td><img src="${pageContext.request.contextPath}/${product.productImage}" height="50" width="50"></td>
   <td><a href="${pageContext.request.contextPath}/discontinueProduct/${product.productId}"><button type="button" class="btn btn-danger">Discontinue</button></a></td>
  <td><a href="${pageContext.request.contextPath}/updateProduct/${product.productId}"><button type="button" class="btn btn-success">Edit</button></a></td>
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
    <tr><th><a class="btn btn-primary btn-block" href="${pageContext.request.contextPath}/addProduct">Add Product</a></th></tr>
    
    
    </div>
    </div>
    </div>
    </body>
    </html>
    
    
    