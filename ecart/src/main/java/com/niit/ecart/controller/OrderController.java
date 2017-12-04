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
}
