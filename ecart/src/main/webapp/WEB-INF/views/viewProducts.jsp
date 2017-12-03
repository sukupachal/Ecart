<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Product List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Price</th></tr>  
   <c:forEach var="product" items="${list}">   
   <tr> 
   <td>${product.productId}</td>   
   <td>${product.productName}</td>  
   <td>${product.productPrice}</td>  
   <td>${product.productImage}</td>  
  
  <td><img src="${pageContext.request.contextPath}/${product.productImage}" height="50" width="50"></td>
   <td><a href="${pageContext.request.contextPath}/discontinueProduct/${product.productId}">Discontinue</a></td>
  <td><a href="${pageContext.request.contextPath}/updateProduct/${product.productId}">Edit</a></td>
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
    <tr><th><a class="btn btn-default check_out" href="${pageContext.request.contextPath}/addProduct">Add Product</a></th></tr>