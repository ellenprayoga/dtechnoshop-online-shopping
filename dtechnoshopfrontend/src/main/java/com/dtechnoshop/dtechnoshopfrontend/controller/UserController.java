package com.dtechnoshop.dtechnoshopfrontend.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dtechnoshop.dtechnoshopbackend.dto.CartLineModel;
import com.dtechnoshop.dtechnoshopbackend.dto.CartModel;
import com.dtechnoshop.dtechnoshopbackend.dto.CategoryModel;
import com.dtechnoshop.dtechnoshopbackend.dto.ProductModel;
import com.dtechnoshop.dtechnoshopbackend.dto.UserLoginModel;
import com.dtechnoshop.dtechnoshopbackend.dto.UserModel;
import com.dtechnoshop.dtechnoshopbackend.service.CartLineService;
import com.dtechnoshop.dtechnoshopbackend.service.CartService;
import com.dtechnoshop.dtechnoshopbackend.service.CategoryService;
import com.dtechnoshop.dtechnoshopbackend.service.ProductService;
import com.dtechnoshop.dtechnoshopbackend.service.ProvinceCitySubdistrictService;
import com.dtechnoshop.dtechnoshopbackend.service.UserService;
import com.dtechnoshop.dtechnoshopfrontend.hashing.BCrypt;
import com.dtechnoshop.dtechnoshopfrontend.validator.LoginEmailValidator;
import com.dtechnoshop.dtechnoshopfrontend.validator.LoginPasswordValidator;
import com.dtechnoshop.dtechnoshopfrontend.validator.RegisterEmailValidator;
import com.dtechnoshop.dtechnoshopfrontend.validator.RegisterPasswordValidator;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartLineService cartLineService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProvinceCitySubdistrictService provinceCitySubdistrictService;
	
	
	// User register handler
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("mainPage");
		
		mv.addObject("title", "Daftar");
		mv.addObject("userClickRegister", true);
		
		// Create plain user model object
		mv.addObject("user", new UserModel());
		
		return mv;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerHandler(@ModelAttribute("user") @Validated UserModel userModel, BindingResult results, Model model) {
		// Validate email if it exist or not
		if (userService.getUserLogin(userModel.getEmail()) != null) {
			new RegisterEmailValidator().validate(userModel, results);
		}
		
		// Validate password and repeat password
		if (!userModel.getPassword().equals(userModel.getValidatePassword())) {
			new RegisterPasswordValidator().validate(userModel, results);
		}
		
		if (results.hasErrors()) {
			model.addAttribute("title", "Daftar");
			model.addAttribute("userClickRegister", true);
			return "mainPage";
		}
		
		// Set user address
		userModel.setAddress(userModel.getSpecificAddress() + " Kec. " + userModel.getSubdistrict() + " " + 
				userModel.getCity() + " " + userModel.getProvince() + " " + userModel.getPostalCode());
		
		// Hashing user password
		userModel.setPassword(BCrypt.hashpw(userModel.getPassword(), BCrypt.gensalt(12)));
		
		// Add user
		userService.addUser(userModel);
		
		// Create and add new cart for user
		CartModel cart = new CartModel();
		cart.setId(userModel.getId());
		cart.setUser(userModel);
		
		cartService.addCart(cart);
		
		model.addAttribute("title", "Sign Up Success");
		model.addAttribute("userClickRegisterSuccess", true);
		return "mainPage";
	}
	
	
	// Get category list
	@ModelAttribute("categoryList")
	public List<CategoryModel> getCategoryList() {
		return categoryService.getAllCategory();
	}
	
	
	// User login handler
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("mainPage");
		mv.addObject("title", "Masuk");
		mv.addObject("userClickLogin", true);
		
		// Add plain user login object
		mv.addObject("userLogin", new UserLoginModel());
		
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginHandler(@ModelAttribute ("userLogin") @Validated UserLoginModel userLogin, BindingResult results, 
			Model model, HttpServletRequest request, HttpServletResponse response) {
		
		UserModel userModel = userService.getUserLogin(userLogin.getEmail());
		
		// Check email and password for user model
		if (!userLogin.getEmail().isEmpty()) {
			if (userModel == null) {
				new LoginEmailValidator().validate(userLogin, results);
			}
			else {
				if (!userLogin.getPassword().isEmpty()) {
					if (!BCrypt.checkpw(userLogin.getPassword(), userModel.getPassword())) {
						new LoginPasswordValidator().validate(userLogin, results);
					}
				}
			}
		}
		
		if (results.hasErrors()) {
			model.addAttribute("title", "Masuk");
			model.addAttribute("userClickLogin", true);
			return "mainPage";
		}
		
		// Set attribute for user and cart
		request.getSession().setAttribute("userData", userModel);
		request.getSession().setAttribute("userCart", cartService.getCart(userModel));
		
		return "redirect:" + request.getSession().getAttribute("thisSession");
	}
	
	
	// Add product to user cart
	@RequestMapping(value = "/addToCart/{productId}", method = RequestMethod.GET)
	public String addProductToCart(@PathVariable("productId") int productId, HttpServletRequest request, HttpServletResponse response) {
		// Check whether user null
		checkUser(request);
		
		HttpSession session = request.getSession();
		CartModel cart = (CartModel) session.getAttribute("userCart");
		ProductModel product = productService.getSingleProduct(productId);
		
		// Create new cart line
		CartLineModel cartLine = new CartLineModel();
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		cartLine.setPrice(product.getMsrp());
		cartLine.setQuantity(1);
		cartLine.setTotal(product.getMsrp() * 1);
		cartLine.setOrderDate(new Date());
		cartLine.setStatus("");
		
		// Reset product quantity
		product.setQuantity(cartLine.getProduct().getQuantity() - 1);
		productService.updateProduct(product);
		
		cartLineService.addCartLine(cartLine);
		
		return "redirect:/userCartLines";
	}

	
	// Handle user cart lines
	@RequestMapping(value = "/userCartLines", method = RequestMethod.GET)
	public ModelAndView getUserCart(HttpServletRequest request, HttpServletResponse response) {
		// Check whether user null
		checkUser(request);
				
		CartModel cart = (CartModel) request.getSession().getAttribute("userCart");
		List<CartLineModel> userCartLines = cartLineService.getCartLine(cart.getId());
		int cartLinesNumber = 0;
		double cartGrandTotal = 0;
		
		// Count cartline and grand total
		for (CartLineModel cartLine : userCartLines) {
			cartLinesNumber += cartLine.getQuantity();
			cartGrandTotal += cartLine.getTotal();
		}
		
		// Update cartline
		cart.setCartLines(cartLinesNumber);
		cart.setGrandTotal(cartGrandTotal);
		cartService.update(cart);
		
		ModelAndView mv = new ModelAndView("mainPage");
		mv.addObject("userCartLines", userCartLines);
		mv.addObject("title", "Keranjang");
		mv.addObject("userClickUserCartLine", true);
		
		return mv;
	}
	
	
	// Update cart lines
	@RequestMapping(value = "/cartUpdate/{cartLineId}", method = RequestMethod.GET)
	public String updateCartLinesQuantity(@PathVariable("cartLineId") int cartLineId, @RequestParam int quantity,
			HttpServletRequest request, HttpServletResponse response) {
		
		// Check whether user null
		checkUser(request);
		
		CartLineModel cartLine = cartLineService.getSingleCartLine(cartLineId);
		
		// Check cartline quantity whether it's more or less than product quantity
		if (cartLine.getQuantity() < quantity) {
			ProductModel productModel = cartLine.getProduct();
			productModel.setQuantity(productModel.getQuantity() - (quantity - cartLine.getQuantity()));
			productService.updateProduct(productModel);
		}
		else if (cartLine.getQuantity() > quantity) {
			ProductModel productModel = cartLine.getProduct();
			productModel.setQuantity(productModel.getQuantity() + (cartLine.getQuantity() - quantity));
			productService.updateProduct(productModel);
		}
		
		// Update cart line quantity and total
		cartLine.setQuantity(quantity);
		cartLine.setTotal(cartLine.getPrice() * quantity);
		cartLineService.updateCartLine(cartLine);
		
		return "redirect:/userCartLines";
	}
	
	
	// Remove cart lines
	@RequestMapping(value = "/cartRemove/{cartLineId}", method = RequestMethod.GET)
	public String removeCartLine(@PathVariable("cartLineId") int cartLineId, HttpServletRequest request) {
		// Check whether user null
		checkUser(request);
				
		CartLineModel cartLine = cartLineService.getSingleCartLine(cartLineId);
		
		// Reset product quantity
		ProductModel product = cartLine.getProduct();
		product.setQuantity(product.getQuantity() + cartLine.getQuantity());
		productService.updateProduct(product);
		
		// Delete cart line
		cartLineService.deleteCartLine(cartLine);
		
		return "redirect:/userCartLines";
	}
	
	
	// Handle confirm cart lines
	@RequestMapping(value = "/confirmUserCartLines", method = RequestMethod.GET)
	public ModelAndView confirmUserCartLines(HttpServletRequest request, HttpServletResponse response) {
		// Check whether user null
		checkUser(request);
				
		CartModel cart = (CartModel) request.getSession().getAttribute("userCart");
		List<CartLineModel> userCartLines = cartLineService.getCartLine(cart.getId());
		
		ModelAndView mv = new ModelAndView("mainPage");
		mv.addObject("title", "Konfirmasi Keranjang Belanja");
		
		// Add cart line object
		mv.addObject("userCartLines", userCartLines);
		mv.addObject("userClickConfirmUserCartLines", true);
		
		return mv;
	}
	
	
	// Handle payments
	@RequestMapping(value = "/payments", method = RequestMethod.GET)
	public ModelAndView paymentsHandle(HttpServletRequest request, HttpServletResponse response) {
		// Check whether user null
		checkUser(request);
				
		ModelAndView mv = new ModelAndView("mainPage");
		mv.addObject("title", "Pembayaran");
		mv.addObject("userClickPayments", true);
		
		CartModel cart = (CartModel) request.getSession().getAttribute("userCart");
		List<CartLineModel> cartLine = cartLineService.getCartLine(cart.getId());
		
		// Add grand total object
		mv.addObject("totalPayments", cart.getGrandTotal());
		
		// Change cart line to order
		for (CartLineModel cartLineModel : cartLine) {
			cartLineModel.setStatus("ORDER");
			cartLineService.updateCartLine(cartLineModel);
		}
		
		// Change cart to default
		cart.setCartLines(0);
		cart.setGrandTotal(0);
		
		return mv;
	}
	
	
	// User logout handle
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutHandle(HttpServletRequest request, HttpServletResponse response) {
		// Remove userData and userCart attribute
		request.getSession().removeAttribute("userData");
		request.getSession().removeAttribute("userCart");
		
		return "redirect:/login";
	}
	
	
	// Check user login
	private void checkUser(HttpServletRequest request) {
		if (request.getSession().getAttribute("userData") == null) {
			throw new NullPointerException();
		}
	}
}
