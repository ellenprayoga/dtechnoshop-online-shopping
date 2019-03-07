package com.dtechnoshop.dtechnoshopbackend.service;

import java.util.List;

import com.dtechnoshop.dtechnoshopbackend.dto.ProductModel;

public interface ProductService {
	// Add new product
	public boolean addProduct(ProductModel productModel);

	// Update product
	public boolean updateProduct(ProductModel productModel);

	// Delete poroduct
	public boolean deleteProduct(ProductModel productModel);

	// Get single product
	public ProductModel getSingleProduct(int productId);

	// Get all products
	public List<ProductModel> getAllProducts();

	// Get all active products
	public List<ProductModel> getAllActiveProducts();

	// Get all product by category
	public List<ProductModel> getAllProductByCategory(int categoryId);
	
	// Get all products with fixed number
	public List<ProductModel> getAllProductByFixedNumber(int id, int number);
	
	// Get searched products
	public List<ProductModel> getSearchedProducts(String keyWords);
	
	// Get product quantity
	public int getProductQuantity(int productId);
	
	// Get data managemnet searched product
	public List<ProductModel> getDataManagementSearchedProduct(String key);
}