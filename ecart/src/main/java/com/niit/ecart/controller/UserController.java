package com.niit.ecart.controller;

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
import com.niit.ecart.dao.UserDao;
import com.niit.ecart.dao.UsersDao;
import com.niit.ecart.model.Cart;
import com.niit.ecart.model.User;
import com.niit.ecart.model.Users;

@Controller  
public class UserController {
	  @Autowired 
	  UserDao userDao;
	  @Autowired
	  CartDao cartDao;
	  /*@RequestMapping("/index")  
	    public ModelAndView index(){  
	        return new ModelAndView("index");  
	    }*/ 
	  
	/*@RequestMapping("/usersform")  
    public ModelAndView showform(){  
        return new ModelAndView("usersform","command",new Users());  
    } 
	
	 It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("user") User user){  
    	userDao.addUsers(user);
        return new ModelAndView("redirect:/viewusers");//will redirect to viewusers request mapping  
    }  
    
     It provides list of users in model object   
    @RequestMapping("/viewusers")  
    public ModelAndView viewusers(){  
        List<Users> list=usersDao.getAllUsers();
        return new ModelAndView("viewusers","list",list);  
    }  
    
     It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.  
    @RequestMapping(value="/editusers/{id}")  
    public ModelAndView edit(@PathVariable int id){  
        Users users=usersDao.getUsersById(id);  
        return new ModelAndView("userseditform","command",users);  
    }  
    
    
     It updates model object.   
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("users") Users users){  
    	usersDao.updateUsers(users);
        return new ModelAndView("redirect:/viewusers");  
    }  
    
     It deletes record for the given id in URL and redirects to /viewusers   
    @RequestMapping(value="/deleteusers/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){ 
    	System.out.println("delete is called");
       usersDao.deleteUsers(id);
        return new ModelAndView("redirect:/viewusers");  
    }*/
    
    
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView userRegistrationView(){
    	return new
    			ModelAndView("userRegistrationView", "command",new User());
    }
    
    
    /* user Registration*/
    
    @RequestMapping(value="/registerUser",method=RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("User")User user,HttpSession httpSession){
    	ModelAndView modelAndView=new ModelAndView("userRegistrationView","command",new User());
    	if(userDao.getUsersById(user.getId())!=null){
    		System.out.println("at same user Id");
    		modelAndView.addObject("errorMessage","Please try with diffrent user Id.");
    		return modelAndView;
    	}else{
    		user.setEnabled(true);
    		user.setRole("ROLE_USER");
    		Cart cart=new Cart();
    		
    		if(cartDao.insertCart(cart)){
    			user.setCart(cart);
    			if(userDao.addUsers(user)){
    				modelAndView.addObject("successMessage","You have been registered sucessfully.");
    				return modelAndView;
    			}else{
    				
    				modelAndView.addObject("errorMessage","User has not been inserted!");
    				return modelAndView;
    			}
    			}else{
    				modelAndView.addObject("errorMessage","Cart has not been inserted!");
    				return modelAndView;
    			}
    			
    			}
    			
    			
    		}
    		
    	
    }
    
