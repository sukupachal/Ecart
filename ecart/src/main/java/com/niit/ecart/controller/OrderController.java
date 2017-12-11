package com.niit.ecart.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecart.dao.UserDao;


@Controller
public class OrderController {

	@Autowired
	UserDao userDao;
	@RequestMapping("/payment") 
	public ModelAndView payment(Principal principal, HttpSession httpSession){
		
		ModelAndView mv=new ModelAndView("payment");
	
				return mv;
	
}
	@RequestMapping("/checkout")
	public ModelAndView gotocheckout(Principal principal, HttpSession httpSession) {
		ModelAndView mv=new ModelAndView("checkout");
		return mv;
	}
	
	
	@RequestMapping("/ack")
	public ModelAndView ack(Principal principal, HttpSession httpSession) {
		ModelAndView mv=new ModelAndView("ack");
		return mv;
	}
	
	@RequestMapping("/cashpay")
	public ModelAndView cashOnDelivary(Principal principal, HttpSession httpSession) {
		ModelAndView mv=new ModelAndView("cashpay");
		return mv;
	}
	
	@RequestMapping("/orderDetails")
	public ModelAndView orderDetails(Principal principal, HttpSession httpSession) {
		ModelAndView mv=new ModelAndView("orderDetails");
		return mv;
	}
}
