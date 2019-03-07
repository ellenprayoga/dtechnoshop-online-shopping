package com.dtechnoshop.dtechnoshopfrontend.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	private static final String ABS_PATH = "C:\\Users\\user\\eclipse-workspace\\dtechnoshopfrontend\\src\\main\\webapp\\assets\\images\\";
	private static String real_path = "";
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		real_path = request.getSession().getServletContext().getRealPath("/assets/images/");
		
		// Make sure all directories exist
		if (!new File(ABS_PATH).exists()) {
			// Create the directories
			new File(ABS_PATH).mkdirs();
		}
		
		if (!new File(real_path).exists()) {
			// Create the directories
			new File(real_path).mkdirs();
		}
		
		try {
			// Server upload
			file.transferTo(new File(real_path + code + ".jpg"));
			
			// Project directory upload
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
}
