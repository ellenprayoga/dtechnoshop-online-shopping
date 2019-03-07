package com.dtechnoshop.dtechnoshopbackend.dao;

import java.util.List;

import com.dtechnoshop.dtechnoshopbackend.dto.CategoryModel;

public interface CategoryDAO {
	// Add new category
	public boolean addCategory(CategoryModel categoryModel);
	
	// Update category
	public boolean updateCategory(CategoryModel categoryModel);
	
	// Delete category
	public boolean deleteCategory(CategoryModel categoryModel);
	
	// Get single category
	public CategoryModel getSingleCategory(int id);
	
	// Get all category
	public List<CategoryModel> getAllCategory();
	
	// Get all active category
	public List<CategoryModel> getAllActiveCategory();
}
