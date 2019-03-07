package com.dtechnoshop.dtechnoshopbackend.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtechnoshop.dtechnoshopbackend.dao.ProductDAO;
import com.dtechnoshop.dtechnoshopbackend.dto.ProductModel;
import com.dtechnoshop.dtechnoshopbackend.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	// Get productDAO bean
	@Autowired
	private ProductDAO productDAO;

	// Add new product
	public boolean addProduct(ProductModel productModel) {
		return productDAO.addProduct(productModel);
	}

	// Update product
	public boolean updateProduct(ProductModel productModel) {
		return productDAO.updateProduct(productModel);
	}

	// Delete product
	public boolean deleteProduct(ProductModel productModel) {
		return productDAO.deleteProduct(productModel);
	}

	// Get single product
	public ProductModel getSingleProduct(int productId) {
		return productDAO.getSingleProduct(productId);
	}

	// Get all products
	public List<ProductModel> getAllProducts() {
		return productDAO.getAllProducts();
	}

	// Get all active products
	public List<ProductModel> getAllActiveProducts() {
		return productDAO.getAllActiveProducts();
	}

	// Get all product by category
	public List<ProductModel> getAllProductByCategory(int categoryId) {
		return productDAO.getAllProductByCategory(categoryId);
	}

	// Get all products with fixed number
	public List<ProductModel> getAllProductByFixedNumber(int id, int number) {
		return productDAO.getAllProductByFixedNumber(id, number);
	}

	// Get searched products
	public List<ProductModel> getSearchedProducts(String keyWords) {
		return productDAO.getSearchedProducts(keyWords);
	}
	
	// Get product quantity
	public int getProductQuantity(int productId) {
		return productDAO.getProductQuantity(productId);
	}
	
	// Get data managment searched product
	public List<ProductModel> getDataManagementSearchedProduct(String key) {
		return productDAO.getDataManagemnetSearchedProduct(key);
	}
}
