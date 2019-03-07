package com.dtechnoshop.dtechnoshopbackend.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtechnoshop.dtechnoshopbackend.dao.CategoryDAO;
import com.dtechnoshop.dtechnoshopbackend.dto.CategoryModel;
import com.dtechnoshop.dtechnoshopbackend.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	public boolean addCategory(CategoryModel categoryModel) {
		return categoryDAO.addCategory(categoryModel);
	}
	
	public boolean updateCategory(CategoryModel categoryModel) {
		return categoryDAO.updateCategory(categoryModel);
	}
	
	public boolean deleteCategory(CategoryModel categoryModel) {
		return categoryDAO.deleteCategory(categoryModel);
	}
	
	public CategoryModel getSingleCategory(int id) {
		return categoryDAO.getSingleCategory(id);
	}
	
	public List<CategoryModel> getAllCategory() {
		return categoryDAO.getAllCategory();
	}
	
	public List<CategoryModel> getAllActiveCategory() {
		return categoryDAO.getAllActiveCategory();
	}
}
