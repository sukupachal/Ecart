package com.niit.ecart.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecart.dao.CategoryDao;
import com.niit.ecart.dao.ProductDao;
import com.niit.ecart.model.Category;
import com.niit.ecart.model.Product;

@Controller
public class ProductController {

@Autowired
ProductDao productDao;
@Autowired
CategoryDao  categoryDao;

@RequestMapping("/addProduct")
public ModelAndView add(HttpSession  session){
	
	
	 List<Category>  categoryList=categoryDao.list();
	 session.setAttribute("categoryList", categoryList);
	 ModelAndView mv=new ModelAndView("addProduct","command",new Product());
	 mv.addObject("categoryList", categoryList);
	 
	return mv;
}



@RequestMapping(value="/saveProduct",method = RequestMethod.POST)
public ModelAndView save(@ModelAttribute("product")Product product , HttpServletRequest request,@RequestParam("file")MultipartFile file){
	
	byte fileBytes[];
	FileOutputStream fos=null;
	
	String fileName ="";
	String productImage ="";
	ServletContext context =request.getServletContext();
	String realContextPath =context.getRealPath("/");
	String pn =product.getProductName();
	if(file!=null){
		fileName=realContextPath + "/resources/img/" + pn + ".jpg";
		productImage = "resources/img/" + pn + ".jpg";
		File  fileobj = new File(fileName);
		try{
			fos = new FileOutputStream(fileobj);
			fileBytes = file.getBytes();
			fos.write(fileBytes);
			}
		catch(Exception e){
			e.printStackTrace();
		}
				
		
	}
	
	product.setProductImage(productImage);
	
	productDao.addProduct(product);
	return new ModelAndView("redirect:/viewProducts");
}


@RequestMapping("/viewProducts")
public ModelAndView view(){
	List<Product>list=productDao.list();
	return new ModelAndView("viewProducts","list",list);
}

@RequestMapping(value="/deactiveProduct/{productId}",method=RequestMethod.GET)
public ModelAndView deactivateProduct(@PathVariable int productId,HttpSession httpSession){
	ModelAndView modelAndView=new ModelAndView("productView","command",new Product());
	Product product=productDao.listByProductId(productId);
	product.setProductStatus(false);
	if(productDao.updateProduct(product)){
		modelAndView.addObject("sucessMessage","product deactivated sucessfully");
	
	}else{
		modelAndView.addObject("essorMessage","Failed to deactivate product");
		
	}
	
	return modelAndView;
}


@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
public ModelAndView updateProduct(@ModelAttribute("Product") Product product,HttpServletRequest request,
		@RequestParam("productImageFile")MultipartFile productImageFile,HttpSession httpSession){
	System.out.println("at updateProduct"+product.getProductId());
		ModelAndView modelAndView=new ModelAndView("ProductView","command",new Product());
		
		int productId=((Product)httpSession.getAttribute("product")).getProductId();
		product.setProductId(productId);
		
		byte fileBytes[];
		FileOutputStream fos = null;
		String fileName = " ";
		String productImage = " ";
		ServletContext context = request.getServletContext();
		String realContextPath=context.getRealPath("/");
		String ProductName = product.getProductName();
		if (productImageFile !=null){
			fileName=realContextPath+"resources/images/productimages/"+ProductName+".jpg";
			System.out.println("==="+fileName+"===");
			File fileobj = new File(fileName);
			try{
				fos=new FileOutputStream(fileobj);
				fileBytes=productImageFile.getBytes();
				fos.write(fileBytes);
			}catch(Exception e){
				e.printStackTrace();
				
			}
			product.setProductImage(productImage);
			
			productDao.updateProduct(product);
			modelAndView.addObject("successMessage","product updated successfully");
		}else{
			modelAndView.addObject("errorMessage","failed to update product");
		}
		
		return modelAndView;
		}

}
