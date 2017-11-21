<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
   <%--  <jsp:include page="header.jsp"></jsp:include> --%>
   
  <%--  <c:if test="${successMessage != null}"> 
   
    
    <div class="alert alert-sucess alert-dismissable container">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    ${sucessMessage}
    </div>
    </c:if> --%>
    
   <%--  <c:if test="${errorMessage != null}"
    <div class="alert alert-danger alert-dismissable container">
    <a href="#" class="close" data-dismiss="alert" aria-lable="close">&times;</a>
    <strong>Upps!!!</strong> ${errorMessage}
    </div>
    </c:if> --%>
     <section id="form"><!-- form -->
     <div class="container"></div>
     <div class="container"></div>
     <div class="roe"></div>
     <div class="col-sm-11 col-sm-offset-1">
     <div class="login-form"><!--login form-->
     <h2>Please SignUp</h2>
     <form:form method="post" action="${pageContext.request.contextPath}/registerUser" >
     <form:input type="text" class="form-control" placeholder="username" path="name"/>
     <br>
     <br>
     <form:input type="text" class="form-control" placeholder="UserId" path="id"/>
     <br>
     <br>
     <form:input type="password" class="form-control" placeholder="Password" path="password"/>
     <br>
     <br>
     <form:input type="email" class="form-control" placeholder="EmailId" path="email"/>
     <br>
     <br>
     <button type="submit" class="btn btn-default">SignUp</button>
     </form:form>
     </div><!-- /login form -->
     </div>
     <div class="col-sm-1">
     
     </div>
     
     
     
     </section><!-- /form -->
     
     