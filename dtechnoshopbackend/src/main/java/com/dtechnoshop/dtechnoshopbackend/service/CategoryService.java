package com.dtechnoshop.dtechnoshopbackend.service;

import java.util.List;

import com.dtechnoshop.dtechnoshopbackend.dto.CategoryModel;

public interface CategoryService {
	// Add new category
	public boolean addCategory(CategoryModel categoryModel);
	
	// Update category
	public boolean updateCategory(CategoryModel categoryModel);
	
	// Delete category
	public boolean deleteCategory(CategoryModel categoryModel);
	
	// Get single category
	public CategoryModel getSingleCategory(int id);
	
	// Get all categories
	public List<CategoryModel> getAllCategory();
	
	// Get all active categories
	public List<CategoryModel> getAllActiveCategory();
}
