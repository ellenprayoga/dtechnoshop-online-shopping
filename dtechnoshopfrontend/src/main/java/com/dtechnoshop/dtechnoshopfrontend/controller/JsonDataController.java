package com.dtechnoshop.dtechnoshopfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dtechnoshop.dtechnoshopbackend.dto.CartLineModel;
import com.dtechnoshop.dtechnoshopbackend.dto.ProductModel;
import com.dtechnoshop.dtechnoshopbackend.service.CartLineService;
import com.dtechnoshop.dtechnoshopbackend.service.ProductService;
import com.dtechnoshop.dtechnoshopbackend.service.ProvinceCitySubdistrictService;

@Controller
@RequestMapping(value = "/json/data")
public class JsonDataController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartLineService cartLineService;

	@Autowired
	private ProvinceCitySubdistrictService provinceCitySubdistrictService;

	
	// Get fixed number products
	@RequestMapping("/product/{id}/fixedNumberProducts")
	@ResponseBody
	public List<ProductModel> getFixedProducts(@PathVariable("id") int id) {
		return productService.getAllProductByFixedNumber(id, 4);
	}
	
	
	// Get product quantity
	@RequestMapping("/product/quantity/{cartLineId}")
	@ResponseBody
	public int getProudctQuantity(@PathVariable("cartLineId") int cartLineId) {
		CartLineModel cartLine = cartLineService.getSingleCartLine(cartLineId);
		return productService.getProductQuantity(cartLine.getProduct().getId());
	}
	
	
	// Get all provinces
	@RequestMapping(value = "/province")
	@ResponseBody
	public List<String> getAllProvince() {
		return provinceCitySubdistrictService.getAllProvince();
	}

	
	// Get all cities
	@RequestMapping(value = "/city/{province}")
	@ResponseBody
	public List<String> getAllCity(@PathVariable("province") String province) {
		return provinceCitySubdistrictService.getAllCity(province);
	}

	
	// Get all subdistricts
	@RequestMapping(value = "/subdistrict/{city}")
	@ResponseBody
	public List<String> getAllSubdistrict(@PathVariable("city") String city) {
		return provinceCitySubdistrictService.getAllSubdistrict(city);
	}

	
	// Get searched products
	@RequestMapping(value = "/dataManagement/searchedProducts/{key}")
	@ResponseBody
	public List<ProductModel> getSearchedProduct(@PathVariable("key") String key) {
		return productService.getSearchedProducts(key);
	}
	
	
	// Get data to update product
	@RequestMapping(value = "/dataManagement/productData/{productId}")
	@ResponseBody
	public ProductModel getDataToUpdateProduct(@PathVariable("productId") int productId) {
		return productService.getSingleProduct(productId);
	}
}
