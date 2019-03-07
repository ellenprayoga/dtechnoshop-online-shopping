package com.dtechnoshop.dtechnoshopbackend.testcase;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dtechnoshop.dtechnoshopbackend.dto.DistributionModel;
import com.dtechnoshop.dtechnoshopbackend.dto.ProductModel;
import com.dtechnoshop.dtechnoshopbackend.service.DistributionService;
import com.dtechnoshop.dtechnoshopbackend.service.ProductService;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private static DistributionService distributionService;
	private static ProductService productService;
	private DistributionModel distributionModel;
	private ProductModel productModel;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.dtechnoshop.dtechnoshopbackend");
		context.refresh();
		distributionService = context.getBean(DistributionService.class);
		productService = context.getBean(ProductService.class);
	}

	@Test
	public void testAddCategory() {		
		productModel = productService.getSingleProduct(4);
		
		distributionModel = new DistributionModel();
		distributionModel.setProduct(productModel);
		distributionModel.setPrice(productModel.getUnitPrice());
		distributionModel.setQuantity(10);
		distributionModel.setTotal(productModel.getUnitPrice() * 10);
		distributionModel.setOrderDate(new Date());
		
		distributionService.addDistribution(distributionModel);
		
		assertEquals("Succesfully added a category inside the table !", 10, productService.getProductQuantity(4));
	}
}
