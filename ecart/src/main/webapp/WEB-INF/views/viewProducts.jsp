<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Address</th></tr>  
   <c:forEach var="user" items="${list}">   
   <tr> 
   <td>${product.productId}</td>   
   <td>${product.productName}</td>  
   <td>${product.productPrice}</td>  
   <td>${product.productImage}</td>  
  
  <td><img src="${pageContext.request.contextPath}/${product.productImage}" height="50" width="50"></td>
   <td><a href="editproducts/${product.productId}">Edit</a></td>  
   <td><a href="deleteproducts/${product.productId}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="productsform">Add New Product</a>  