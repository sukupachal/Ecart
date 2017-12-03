<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
    
     <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>

 <jsp:include page="header.jsp"></jsp:include> 
 <title>Bootstrap Case</title>   
   
      <c:if test="${successMessage != null}"> 
   
    
    <div class="alert alert-sucess alert-dismissable container">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    ${successMessage}
    </div>
    </c:if> 
    
    <c:if test="${errorMessage != null}">
    <div class="alert alert-danger alert-dismissable container">
    <a href="#" class="close" data-dismiss="alert" aria-lable="close">&times;</a>
    <strong>Opps!!!</strong> ${errorMessage}
    </div>
    </c:if>  
     <section id="form"><!-- form -->
     <div class="container"></div>
     <div class="container"></div>
     <div class="roe"></div>
     <div class="col-sm-11 col-sm-offset-1">
     <div class="login-form"><!--login form-->
     <h2>Please SignUp</h2>
     <form:form method="post" action="${pageContext.request.contextPath}/registerUser" >
     <li>UserName<form:input type="text" class="form-control" placeholder="username" path="name"/></li>
     <br>
     <br>
     <li>UserId<form:input type="text" class="form-control" placeholder="UserId" path="id"/></li>
     <br>
     <br>
     <li>Password<form:input type="password" class="form-control" placeholder="Password" path="password"/></li>
     <br>
     <br>
     <li>Email-Id<form:input type="email" class="form-control" placeholder="EmailId" path="email"/></li>
     <br>
     <br>
     <button type="submit" class="btn btn-default">SignUp</button>
     </form:form>
      
      <p>Already a User? <a href="${pageContext.request.contextPath}/loginPage">Login now</a>
     </div><!-- /login form -->
     </div>
     <div class="col-sm-1">
     
     </div>
     
     
     
     </section><!-- /form -->
     
     