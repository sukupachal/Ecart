<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <c:set var="context" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
           <!-- each <li> </li> is one menu option -->
        <li class="active"><a href="#">Home</a></li>
        <!-- <li class="dropdown"> is used to create a menu option which will have sub menu -->
        <li class="dropdown">
        
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Products <span class="caret"></span></a>
         <!-- <ul class="dropdown-menu">  is used to create the sub menu items -->
          <ul class="dropdown-menu">
          
          <!-- display category names as menu option  -->
           <c:forEach items="${categoryList}" var="category">
            <li><a href="${pageContext.request.contextPath}/showProductsByCategory/${category.categoryId}">${category.categoryName}</a></li>
             </c:forEach>
          </ul>
        </li>
        <li><a href="#">Page 2</a></li>
       <security:authorize access="hasRole('ROLE_ADMIN')"><li><a href="#">Page 3</a></li></security:authorize>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        
        
        <c:if test="${pageContext.request.userPrincipal.name==null}"><li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li></c:if>
         <c:if test="${pageContext.request.userPrincipal.name!=null}"><li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li></c:if>
          <c:if test="${pageContext.request.userPrincipal.name==null}"><li><a href="${pageContext.request.contextPath}/register"><span class="glyphicon glyphicon-register"></span> Sign UP</a></li></c:if>
        
      </ul>
      
      <ul class="nav navbar-nav">
<c:if test="${pageContext.request.userPrincipal.name!=null}">
<li><a href="">Hello${user.userName}</li>
</c:if>
<security:authorize access="hasRole('ROLE_ADMIN')">
<li><a href="${context}/adminProductCategoryView">Admin Control</a></li>
</security:authorize>
<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
<li><a href="checkout.html">Checkout</a></li>
</security:authorize>
<li><a href="${context}/cartView">Cart</a></li>
<security:authorize access="isAnonymous()">
<li><a href="${context}/userRegistrationView">SignUp</a></li>
<li><a href="${context}/loginPage">Login</a></li>
</security:authorize>
<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
<li><a href="${context}/logout">Logout</a></li>
</security:authorize>
</ul>
      
      
    </div>
  </div>
</nav>
