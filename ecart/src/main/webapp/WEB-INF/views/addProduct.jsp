<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:set var="context" value="${pageContext.request.contextPath}"></c:set> 

<!DOCTYPE html>
<html>

<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>


</head>
<div class="container">
 <div class="row">
 
        <h1><b>Add New Product</b></h1>  
       <form:form method="post" action="${context}/saveProduct"  enctype="multipart/form-data">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="productName"  /></td>  
         </tr>    
         <tr>    
          <td>Price :</td>    
          <td><form:input path="productPrice" /></td>  
         </tr> 
         <tr><td>
         <form:select class="form-control" path="productCategory.categoryId">
         <c:forEach items="${categoryList}" var="productCategory">
         <form:option value="${productCategory.categoryId}">
         ${productCategory.categoryName}
         </form:option>
         </c:forEach>
         </form:select> </td></tr>
         
         <tr>    
          <td><form:hidden path="productImage"/></td>     
         </tr> 
         <tr>    
          <td>Choose Image </td>   
          <td><input type="file" name="file"/></td>  
         </tr>
         
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
</div>
</div>
