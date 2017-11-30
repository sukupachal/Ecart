package com.niit.ecart.controller;

import java.security.Principal;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecart.dao.CartDao;
import com.niit.ecart.dao.CartItemDao;
import com.niit.ecart.dao.OrderDetailsDao;
import com.niit.ecart.dao.ProductDao;
import com.niit.ecart.dao.UserDao;
import com.niit.ecart.model.Cart;
import com.niit.ecart.model.CartItem;
import com.niit.ecart.model.OrderDetails;
import com.niit.ecart.model.Product;
import com.niit.ecart.model.User;
@Controller
public class CartController {

	@Autowired
	ProductDao productDao;
	@Autowired
	UserDao userDao;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItemDao cartItemDao;
	@Autowired
	OrderDetailsDao orderDetailsDao;
	
	
	
	@RequestMapping("/cartView")
	public ModelAndView cartView(Principal principal, HttpSession httpSession){
	ModelAndView modelAndView=new ModelAndView("cartView","command",new OrderDetails());
	String userId=principal.getName();
	User user=userDao.getUsersById(userId);
	
	Cart cart=user.getCart();
	
	
	List<CartItem> cartItems=cartItemDao.getAllCartItem();
	System.out.println("cartItem is null"+(cartItems==null));
	httpSession.setAttribute("cartItems", cartItems);
	double total=0;
	
	if(cartItems!=null){
		
		for(CartItem cartItem:cartItems){
			total+=cartItem.getCartItemSubTotal();
		}
		cart.setCartTotal(total);
		
		System.out.println("****************cartid"+cart.getCartId());
		cartDao.updateCart(cart);
	}
	httpSession.setAttribute("cart", cart);
	return modelAndView;
	}
	
	@RequestMapping("/addToCart/{productId}")
	public ModelAndView addToCart(@PathVariable int productId, Principal principal, HttpSession httpSession){
		System.out.println("at addToCart");
		ModelAndView modelAndView=new ModelAndView("redirect:/cartView");
		Product
		product=productDao.listByProductId(productId);
		String userId=principal.getName();
		User user=userDao.getUsersById(userId);
		Cart cart=user.getCart();
		List<CartItem> cartItems=cartItemDao.getCartItemsByCart(cart);
		if(cartItems!=null){
			
			for(CartItem cartItem:cartItems){
				if (cartItem.getProduct().getProductId()==productId){
					int cartItemQuantity=cartItem.getCartItemQuantity()+1;
					double productprice=cartItem.getProduct().getProductPrice();
					double cartItemSubtotal=cartItem.getCartItemSubTotal()+productprice;
					cartItem.setCartItemQuantity(cartItemQuantity);
					cartItem.setCartItemSubTotal(cartItemSubtotal);
					cartItemDao.updateCartItem(cartItem);
					return modelAndView;
				}
			}
		}else{
			System.out.println("cartItem null ******************** at add product");
		}
		CartItem cartItem=new CartItem();
		cartItem.setProduct(product);
		cartItem.setCart(cart);
		cartItem.setCartItemQuantity(1);
		cartItem.setCartItemSubTotal(product.getProductPrice());
		cartItem.setCartItemsStatus("N");
		cartItemDao.insertCartItem(cartItem);
		
		return modelAndView;
		
	
	}
	
	@RequestMapping("/deleteCartItem/{cartItemId}")
	public ModelAndView deleteCartItem(@PathVariable int cartItemId,Principal principal, HttpSession httpSession){
		ModelAndView modelAndView=new ModelAndView("redirect:/cartView");
		CartItem cartItem=cartItemDao.getCartItemByCartItemId(cartItemId);
		Cart cart=cartItem.getCart();
		cart.setCartTotal(cart.getCartTotal()-cartItem.getCartItemSubTotal());
		
		System.out.println("carttotal from delete cart"+cart.getCartTotal());
		cartItemDao.deleteCartItem(cartItem);
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/order",method=RequestMethod.GET)
	public ModelAndView orderDetails(){
		return new
				ModelAndView("order","command",new OrderDetails());
	}
	
	
	
	@RequestMapping(value="/addToOrderDetails",method=RequestMethod.POST)
	public ModelAndView
	addToOrderDetails(@ModelAttribute("OrderDetails") OrderDetails orderDetails,Principal principal,HttpSession httpsession){
		String tot=(String)httpsession.getAttribute("grandTotal");
		int total=Integer.parseInt(tot);
		System.out.println("at addToOrderDetails");
		ModelAndView modelAndView=new ModelAndView("redirect:/order");
		User user=userDao.getUsersById(principal.getName());
		orderDetails.setUser(user);
		Date d=new Date(System.currentTimeMillis());
		Cart cart=user.getCart();
		orderDetails.setOrderDetailsTotal(total);
		orderDetails.setOrderDetails(d);
		orderDetailsDao.insertOrderDetails(orderDetails);
		List<CartItem> cartItems=cartItemDao.getAllCartItem();
		for(CartItem cartItem:cartItems){
			cartItem.setOrderDetails(orderDetails);
			cartItem.setCartItemsStatus("ORDERED");
			cartItemDao.updateCartItem(cartItem);
		}
		System.out.println("cartItems are updated");
		cart.setCartTotal(0);
		cartDao.updateCart(cart);
		orderDetailsDao.updateOrderDetails(orderDetails);
		
		
		return modelAndView;
		
	}
	
	
	
}


