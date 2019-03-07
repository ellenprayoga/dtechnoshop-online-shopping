package com.dtechnoshop.dtechnoshopfrontend.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dtechnoshop.dtechnoshopbackend.dto.CartLineModel;
import com.dtechnoshop.dtechnoshopbackend.dto.CategoryModel;
import com.dtechnoshop.dtechnoshopbackend.dto.DistributionModel;
import com.dtechnoshop.dtechnoshopbackend.dto.ProductModel;
import com.dtechnoshop.dtechnoshopbackend.dto.UserLoginModel;
import com.dtechnoshop.dtechnoshopbackend.dto.UserModel;
import com.dtechnoshop.dtechnoshopbackend.service.CartLineService;
import com.dtechnoshop.dtechnoshopbackend.service.CartService;
import com.dtechnoshop.dtechnoshopbackend.service.CategoryService;
import com.dtechnoshop.dtechnoshopbackend.service.DistributionService;
import com.dtechnoshop.dtechnoshopbackend.service.ProductService;
import com.dtechnoshop.dtechnoshopbackend.service.UserService;
import com.dtechnoshop.dtechnoshopfrontend.hashing.BCrypt;
import com.dtechnoshop.dtechnoshopfrontend.util.FileUploadUtility;
import com.dtechnoshop.dtechnoshopfrontend.validator.LoginEmailValidator;
import com.dtechnoshop.dtechnoshopfrontend.validator.LoginPasswordValidator;

@Controller
@RequestMapping(value = "/dataManagement")
public class DataManagementController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartLineService cartLineService;
	
	@Autowired
	private DistributionService distributionService;

	
	// Handle admin login
	@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	public ModelAndView adminLogin() {
		ModelAndView mv = new ModelAndView("managementLogin");
		
		// Add plain user login object
		mv.addObject("userAdmin", new UserLoginModel());
		return mv;
	}
	
	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	public String handleAdminLogin(@ModelAttribute("userAdmin") @Validated UserLoginModel userLogin, BindingResult results,
			HttpServletRequest request, HttpServletResponse response) {
		
		UserModel user = userService.getUserLogin(userLogin.getEmail());
		
		// Validate whether user exists or not and validate user password
		if (!userLogin.getEmail().isEmpty()) {
			if (user == null || !user.getRole().equals("ADMIN")) {
				new LoginEmailValidator().validate(userLogin, results);
			}
			else {
				if (!userLogin.getPassword().isEmpty()) {
					if (!BCrypt.checkpw(userLogin.getPassword(), user.getPassword())) {
						new LoginPasswordValidator().validate(userLogin, results);
					}
				}
			}
		}
		
		if (results.hasErrors()) {
			return "managementLogin";
		}
		
		// Set user attribute
		request.getSession().setAttribute("userModel", user);
		
		return "redirect:/dataManagement/home";
	}
	
	
	// Handle user admin logout
	@RequestMapping(value = "/adminLogout", method = RequestMethod.GET)
	public String logoutHandle(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("userModel");
		
		return "redirect:/dataManagement/adminLogin";
	}
	
	
	// Handle management home
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homeHandle(HttpServletRequest request) {
		// Check admin account
		checkAdmin(request);
		
		ModelAndView mv = new ModelAndView("managementMainPage");
		mv.addObject("title", "Home");
		mv.addObject("userClickManagementHome", true);
		return mv;
	}
	
	
	// Handle management product
	@RequestMapping(value = "/manageProduct", method = RequestMethod.GET)
	public ModelAndView manageProduct(HttpServletRequest request) {
		// Check admin account
		checkAdmin(request);
		
		ModelAndView mv = new ModelAndView("managementMainPage");
		
		mv.addObject("title", "Produk");
		mv.addObject("userClickManagementProduct", true);
		mv.addObject("product", new ProductModel());
		
		// Add all products object
		mv.addObject("allProducts", productService.getAllProducts());
		
		return mv;
	}
	
	
	// Add new product
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") ProductModel product, HttpServletRequest request) {
		productService.addProduct(product);
		
		// Check admin account
		checkAdmin(request);
				
		// Uploading file
		if (!product.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, product.getFile(), product.getProductCode());
		}
		
		return "redirect:/dataManagement/manageProduct";
	}
	
	
	// Handle management category product
	@RequestMapping(value = "/manageCategoryProduct", method = RequestMethod.GET)
	public ModelAndView manageCategoryProduct(HttpServletRequest request) {
		// Check admin account
		checkAdmin(request);
				
		ModelAndView mv = new ModelAndView("managementMainPage");
			
		mv.addObject("title", "Kategori Produk");
		mv.addObject("userClickManagementCategoryProduct", true);
		
		// Add all categories object
		mv.addObject("allCategories", categoryService.getAllCategory());
			
		return mv;
	}
	
	
	// Handle management user
	@RequestMapping(value = "/manageUser", method = RequestMethod.GET)
	public ModelAndView manageUser(HttpServletRequest request) {
		// Check admin account
		checkAdmin(request);
				
		ModelAndView mv = new ModelAndView("managementMainPage");
				
		mv.addObject("title", "User");
		mv.addObject("userClickManagementUser", true);
		
		// Add all users object
		mv.addObject("allUsers", userService.getAllUser());
				
		return mv;
	}
	
	
	// Get searched user
	@RequestMapping(value = "/searchUser", method = RequestMethod.GET)
	public ModelAndView searchUser(@RequestParam("userId") int userId, HttpServletRequest request) {
		// Check admin account
		checkAdmin(request);		
				
		ModelAndView mv = new ModelAndView("managementMainPage");
		
		mv.addObject("title", "User");
		mv.addObject("userClickManagementUser", true);
		
		// Add all users object
		mv.addObject("allUsers", userService.getSearchedUser(userId));
				
		return mv;
	}
	
	
	// Handle management cart lines for specific product
	@RequestMapping(value = "/manageCartLines/{status}", method = RequestMethod.GET)
	public ModelAndView manageCartLines(@PathVariable("status") String status, HttpServletRequest request) {
		// Check admin account
		checkAdmin(request);
				
		ModelAndView mv = new ModelAndView("managementMainPage");
						
		mv.addObject("title", "Detil Pesanan");
		mv.addObject("userClickManagementCartLines", true);
			
		// Add all cart lines object
		mv.addObject("allCartLines", cartLineService.getSpecificCartLine(status));
		
		// Add cart line status
		mv.addObject("cartLineStatus", status);
						
		return mv;
	}
	
	
	// Update cart line
	@RequestMapping(value = "/updateCartLine", method = RequestMethod.POST)
	public String updateCartLine(@RequestParam("status") String status, @RequestParam("cartLineId") int cartLineId, HttpServletRequest request) {
		// Check admin account
		checkAdmin(request);
				
		CartLineModel cartLine = cartLineService.getSingleCartLine(cartLineId);
		
		// Cart line status before changing
		String beforeStatus = cartLine.getStatus();
		
		cartLine.setStatus(status);
		
		cartLineService.updateCartLine(cartLine);
		
		return "redirect:/dataManagement/manageCartLines/" + beforeStatus;
	}
	
	
	// Search cart line
	@RequestMapping(value = "/searchCartLine", method = RequestMethod.GET)
	public ModelAndView searchCartLine(@RequestParam("key") int key, HttpServletRequest request) {
		// Check admin account
		checkAdmin(request);
				
		ModelAndView mv = new ModelAndView("managementMainPage");
		
		mv.addObject("title", "Detil Pesanan");
		mv.addObject("userClickManagementCartLines", true);
		
		// Add all cart lines object
		mv.addObject("allCartLines", cartLineService.getSearchedCartLine(key));
					
		return mv;
	}
	
	
	// Get searched product
	@RequestMapping(value = "/searchProduct", method = RequestMethod.GET)
	public ModelAndView getSearchedProduct(@RequestParam("key") String key, HttpServletRequest request) {
		// Check admin account
		checkAdmin(request);
				
		ModelAndView mv = new ModelAndView("managementMainPage");
		mv.addObject("title", "Produk");
		mv.addObject("allProducts", productService.getDataManagementSearchedProduct(key));
		mv.addObject("product", new ProductModel());
		mv.addObject("userClickManagementProduct", true);
		
		return mv;
	
	}
	
	
	// Update product
	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public String updateProduct(@RequestParam("productName") String productName, @RequestParam("unitPrice") float unitPrice, 
			@RequestParam("msrp") float msrp, @RequestParam("description") String description, @RequestParam("productId") int productId, 
			@RequestParam("categoryId") int categoryId, HttpServletRequest request) {
		
		// Check admin account
		checkAdmin(request);
		
		ProductModel product = productService.getSingleProduct(productId);
		product.setProductName(productName);
		product.setUnitPrice(unitPrice);
		product.setMsrp(msrp);
		product.setDescription(description);
		product.setCategoryId(categoryId);
		
		productService.updateProduct(product);
		
		return "redirect:/dataManagement/manageProduct";
	}
	
	
	// Inactive product
	@RequestMapping(value = "/inactiveProduct", method = RequestMethod.POST)
	public String inactiveProduct(@RequestParam("productId") int productId, HttpServletRequest request) {
		// Check admin account
		checkAdmin(request);
				
		ProductModel product = productService.getSingleProduct(productId);
		
		if (product.isActive() == true) {
			product.setActive(false);
		}
		else {
			product.setActive(true);
		}
		
		productService.updateProduct(product);
		
		return "redirect:/dataManagement/manageProduct";
	}
	
	
	// Inactive category product
	@RequestMapping(value = "/inactiveCategory", method = RequestMethod.POST)
	public String inactiveCategory(@RequestParam("categoryId") int categoryId, HttpServletRequest request) {
		// Check admin account
		checkAdmin(request);
				
		CategoryModel category = categoryService.getSingleCategory(categoryId);
		List<ProductModel> productList = productService.getAllProductByCategory(categoryId);
		
		if (category.isActive() == true) {
			category.setActive(false);
			categoryService.updateCategory(category);
			
			for (ProductModel product : productList) {
				product.setActive(false);
				productService.updateProduct(product);
			}
		}
		else {
			category.setActive(true);
			categoryService.updateCategory(category);
		}
		
		return "redirect:/dataManagement/manageCategoryProduct";
	}
	
	
	// Add category product
	@RequestMapping(value = "/addCategoryProduct", method = RequestMethod.POST)
	public String addCategoryProduct(@RequestParam("categoryName") String categoryName, HttpServletRequest request) {
		// Check admin account
		checkAdmin(request);
				
		CategoryModel category = new CategoryModel();
		category.setCategoryName(categoryName);
		category.setActive(true);
		
		categoryService.addCategory(category);
		
		return "redirect:/dataManagement/manageCategoryProduct";
	}
	
	
	// Handle management distributions
	@RequestMapping(value = "/manageDistribution", method = RequestMethod.GET)
	public ModelAndView manageDistribution(HttpServletRequest request) {
		// Check admin account
		checkAdmin(request);
				
		ModelAndView mv = new ModelAndView("managementMainPage");
		mv.addObject("title", "Distribusi");
		mv.addObject("allDistributions", distributionService.getAllDistribution());
		mv.addObject("userClickDistribution", true);
		
		return mv;
	}
	
	
	// Adding new distribution
	@RequestMapping(value = "/addDistribution", method = RequestMethod.POST)
	public String addDistribution(@RequestParam("productId") int productId, @RequestParam("quantity") int quantity, HttpServletRequest request) {
		// Check admin account
		checkAdmin(request);
				
		ProductModel product = productService.getSingleProduct(productId);
		DistributionModel distribution = new DistributionModel();
		
		distribution.setProduct(product);
		distribution.setPrice(product.getUnitPrice());
		distribution.setQuantity(quantity);
		distribution.setTotal(product.getUnitPrice() * quantity);
		distribution.setOrderDate(new Date());
		
		distributionService.addDistribution(distribution);
		
		product.setQuantity(product.getQuantity() + quantity);
		productService.updateProduct(product);
		
		return "redirect:/dataManagement/manageDistribution";
	}
	
	
	// Check admin login
	private void checkAdmin(HttpServletRequest request) {
		if (request.getSession().getAttribute("userModel") == null) {
			throw new NullPointerException();
		}
	}
}
