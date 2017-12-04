<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:set var="context" value="${pageContext.request.contextPath}"></c:set>  
        <h1>Update Product</h1>  
       <form:form method="post" action="${context}/updateProducts"  enctype="multipart/form-data">    
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
          <td><input type="file" name="productImageFile"/></td>  
         </tr>
         
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
           

       <form:hidden path="productImage" /> 
       <form:hidden path="productId"/>
       </form:form>    
       