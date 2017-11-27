<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
    
    <jsp:include page="header.jsp"></jsp:include>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
<title>Insert title here</title>

<section id="do_action">
 <div class="container">
 
 <div class="row">
 <div class="col-sm-12">
 <div class="total_area">
 <ul>
 
 <li>Total<span>&#x20B9; ${cart.cartTotal}</span></li>
 <form:form action="addToOrderDetails" method="post">
 <li><form:textarea rows="5" placeholder="Address" path="orderDetailsAddress" class="form-control"/></li>
 <li><form:input path="orderDetailsPin" class="form-control" placeholder="PIN Code"/></li>
 <form:hidden path="orderDetailsTotal"/>
 <li><input class="btn btn-default update" type="submit" value="Check Out"></li>
 </form:form>
 
 
 </ul>
 </div>
 </div>
 
 
 </div>
 </div>
</section>
</html>