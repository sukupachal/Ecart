<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
    <jsp:include page="header.jsp"></jsp:include>
    
    <c:if test="${cartItems.isEmpty()}">
    <div class="container">
    <div class="alert alert-success alert-dismissable">
    <a href="#" class="close" data-dimiss="alert" aria-label="close">&times;</a>
    <strong>No items present .</strong>
    </div>
    </div>
    
    </c:if>
    
    
    <div class="table-responsive cart_info">
    <table class="table table-condensed">
    <thead>
    <tr class="cart_menu">
    <td class="image">Item</td>
    <td class="description"></td>
    <td class="price">Price</td>
    <td class="quantity">Quantity</td>
    <td class="total">Total</td>
    <td></td>
    </tr>
    </thead>
    <tbody>
    
    <c:forEach items="${cartItems}"var="cartItem">
    <tr>
    <td class="cart_product">
    <a href="">
    <img src="${cartItem.product.productImage}" height="110" width="110"
    alt="${cartItem.product.productImage}"></a>
    </td>
    <td class="cart_description">
    <h4><a href="">${cartItem.product.productName}</a></h4>
    <p>${cartItem.product.productId}</p>
    </td>
    <td class="cart_price">
    <p>&#X20B9; ${cartItem.product.productPrice}</p>
    </td>
    <td class="cart_price">
    <p>${cartItem.cartItemQuantity}</p></td>
    <td class="cartTotal">
    <p class="cart_total_price">&#X20B9; ${cartItem.cartItemSubTotal}</p>
    </td>
    <td class="cart_delete">
    <a class="cart_quantity_delete" href="${context}/deleteCartItem/${cartItem.cartItemId}">
    <i class="fa fa-times"></i></a>
    </td>
    </tr>
    </c:forEach>
    
    </tbody>
    
    </table>
    
    </div>
    
    
    
