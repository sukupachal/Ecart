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
	CategoryDao categoryDao;

	@RequestMapping("/addProduct")
	public ModelAndView add(HttpSession session) {

		List<Category> categoryList = categoryDao.list();
		session.setAttribute("categoryList", categoryList);
		ModelAndView mv = new ModelAndView("addProduct", "command", new Product());
		mv.addObject("categoryList", categoryList);

		return mv;
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("product") Product product, HttpServletRequest request,
			@RequestParam("file") MultipartFile file , HttpSession session) {

		byte fileBytes[];
		FileOutputStream fos = null;

		String fileName = "";
		String productImage = "";
		ServletContext context = request.getServletContext();
		String realContextPath = context.getRealPath("/");
		String pn = product.getProductName();
		if (file != null) {
			fileName = realContextPath + "/resources/img/" + pn + ".jpg";
			productImage = "resources/img/" + pn + ".jpg";
			File fileobj = new File(fileName);
			try {
				fos = new FileOutputStream(fileobj);
				fileBytes = file.getBytes();
				fos.write(fileBytes);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		product.setProductImage(productImage);
		product.setProductStatus(true);	
		ModelAndView mv=	new ModelAndView("redirect:/viewProducts");
		if(productDao.addProduct(product))
		{
			
			session.setAttribute("sucessMessage", "Product added successfully");
			return mv;
		}
		else
		{
			session.setAttribute("sucessMessage", "Product could not be added!!!!");
			return mv;
		}
		 
	}

	@RequestMapping("/viewProducts")
	public ModelAndView view(HttpSession session ) {
		
		List<Product> list = productDao.list();
		session.setAttribute("list", list);
		return new ModelAndView("viewProducts", "list", list);
	}

	@RequestMapping(value = "/discontinueProduct/{productId}", method = RequestMethod.GET)
	public ModelAndView deactivateProduct(@PathVariable int productId, HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView("redirect:/viewProducts", "command", new Product());
		Product product = productDao.listByProductId(productId);
		product.setProductStatus(false);
		if (productDao.updateProduct(product)) {
			httpSession.setAttribute("sucessMessage", "product deactivated sucessfully");

		} else {
			httpSession.setAttribute("sucessMessage", "Product Could not be Deactivated!!!!");

		}

		return modelAndView;
	}

	@RequestMapping(value = "/updateProduct/{productId}", method = RequestMethod.GET)
	public ModelAndView updateProduct(@PathVariable int productId, HttpSession session) {
		
		List<Category> categoryList = categoryDao.list();
		session.setAttribute("categoryList", categoryList);
		Product p=productDao.listByProductId(productId);
		ModelAndView mv = new ModelAndView("updateProducts", "command", p);
		mv.addObject("categoryList", categoryList);

		return mv;
	}

	
	
	@RequestMapping(value = "/updateProducts", method = RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute("Product") Product product, HttpServletRequest request,
			@RequestParam("productImageFile") MultipartFile productImageFile, HttpSession httpSession) {
		System.out.println("at updateProduct" + product.getProductId());
		ModelAndView modelAndView = new ModelAndView("redirect:/viewProducts");

		/*int productId = ((Product) httpSession.getAttribute("product")).getProductId();
		product.setProductId(productId);*/

		byte fileBytes[];
		FileOutputStream fos = null;
		String fileName = " ";
		String productImage ="";
		ServletContext context = request.getServletContext();
		String realContextPath = context.getRealPath("/");
		String ProductName = product.getProductName();
		fileName = realContextPath + "resources/img/" + ProductName + ".jpg";
		productImage="resources/img/" + ProductName + ".jpg";
		if (productImageFile != null && productImageFile.getSize()>0) {
			
			
			System.out.println("kkkkkkkkkkkkkk"+productImageFile.getSize());
			
			System.out.println("===" + fileName + "===");
			File fileobj = new File(fileName);
			try {
				fos = new FileOutputStream(fileobj);
				fileBytes = productImageFile.getBytes();
				fos.write(fileBytes);
			} catch (Exception e) {
				e.printStackTrace();

			}
			product.setProductImage("");
			product.setProductImage(productImage);
			product.setProductStatus(true);	
			productDao.updateProduct(product);
			httpSession.setAttribute("sucessMessage", "product updateded sucessfully");
		} /*else {
			modelAndView.addObject("errorMessage", "failed to update product");*/
		/*}*/
		else
		{
			httpSession.setAttribute("sucessMessage", "product updateded sucessfully");
			System.out.println("MMMM "+product.getProductPrice());
			product.setProductImage("");
			product.setProductImage(productImage);
			product.setProductStatus(true);
			productDao.updateProduct(product);
		}
		return modelAndView;
	}

	@RequestMapping("/showProductsByCategory/{categoryId}")
	public ModelAndView showProductsByCategory(@PathVariable int categoryId) {
		System.out.println("cat id " + categoryId);
		ModelAndView mv = new ModelAndView("products");
		mv.addObject("productList", productDao.listByCategoryId(categoryId));
		return mv;
	}

	@RequestMapping("/showProduct/{productId}")
	public ModelAndView showProduct(@PathVariable int productId) {

		ModelAndView mv = new ModelAndView("product");
		mv.addObject("product", productDao.listByProductId(productId));
		return mv;
	}

}
