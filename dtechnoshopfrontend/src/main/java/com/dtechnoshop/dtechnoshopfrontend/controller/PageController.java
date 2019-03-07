package com.dtechnoshop.dtechnoshopfrontend.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dtechnoshop.dtechnoshopbackend.dto.CartLineModel;
import com.dtechnoshop.dtechnoshopbackend.dto.CartModel;
import com.dtechnoshop.dtechnoshopbackend.dto.CategoryModel;
import com.dtechnoshop.dtechnoshopbackend.dto.ProductModel;
import com.dtechnoshop.dtechnoshopbackend.service.CartLineService;
import com.dtechnoshop.dtechnoshopbackend.service.CategoryService;
import com.dtechnoshop.dtechnoshopbackend.service.ProductService;

@Controller
public class PageController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartLineService cartLineService;

	
	// Home Page Request
	@RequestMapping(value = {"/", "/index", "/home"}, method = RequestMethod.GET)
	public ModelAndView index(HttpServletResponse response, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("mainPage");
		mv.addObject("title", "Home");
		
		// Add product objects
		mv.addObject("smartphoneProducts", productService.getAllProductByFixedNumber(1, 4));
		mv.addObject("tabletProducts", productService.getAllProductByFixedNumber(2, 4));
		mv.addObject("laptopProducts", productService.getAllProductByFixedNumber(3, 4));
		mv.addObject("pcProducts", productService.getAllProductByFixedNumber(4, 4));
		mv.addObject("headsetProducts", productService.getAllProductByFixedNumber(5, 4));
		mv.addObject("userClickHome", true);
		
		// Set user session page
		request.getSession().setAttribute("thisSession", "/index");
		
		return mv;
	}
	
	
	// About Page Request
	@RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	public ModelAndView aboutUs(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("mainPage");
		mv.addObject("title", "Tentang");
		mv.addObject("userClickAbout", true);
		
		// Set user session page
		request.getSession().setAttribute("thisSession", "/aboutUs");
		
		return mv;
	}
	
	
	// Contact Page Request
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("mainPage");
		mv.addObject("title", "Kontak");
		mv.addObject("userClickContact", true);
		
		// Set user session page
		request.getSession().setAttribute("thisSession", "/contact");
		
		return mv;
	}
	
	
	// Get products by category
	@RequestMapping(value = "/show/category/{id}/products", method = RequestMethod.GET)
	public ModelAndView getProductsByCategory(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("mainPage");
		List<ProductModel> productList = productService.getAllProductByCategory(id);
		
		mv.addObject("title", categoryService.getSingleCategory(id).getCategoryName());
		
		// Add all products by category
		mv.addObject("productList", productList);
		mv.addObject("userClickCategoryProducts", true);
		
		// Set user session page
		request.getSession().setAttribute("thisSession", "/show/category/" + id + "/products");
		
		return mv;
	}
	
	
	// Get single product
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ModelAndView getSingleProduct(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("mainPage");
		
		ProductModel productModel = productService.getSingleProduct(id);
		
		mv.addObject("title", productModel.getProductName());
		
		// Add single product object
		mv.addObject("product", productModel);
		
		// Add single product category object
		mv.addObject("productCategory", categoryService.getSingleCategory(productModel.getCategoryId()).getCategoryName());
		mv.addObject("userClickSingleProducts", true);
		
		// Set user session page
		request.getSession().setAttribute("thisSession", "/product/" + id);
		
		return mv;
	}
	
	
	// Search controller
	@RequestMapping(value = "/product/search", method = RequestMethod.GET)
	public ModelAndView searchProduct(@RequestParam("keyWords") String keyWords, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("mainPage");
		
		mv.addObject("title", keyWords);
		
		// Add searched products object
		mv.addObject("productList", productService.getSearchedProducts(keyWords));
		mv.addObject("userClickCategoryProducts", true);
		
		// Set user session page
		request.getSession().setAttribute("thisSession", "/product/search?keyWords=" + keyWords);
		
		return mv;	
	}	
	

	// Get category list
	@ModelAttribute("categoryList")
	public List<CategoryModel> getCategoryList() {
		return categoryService.getAllActiveCategory();
	}
}
