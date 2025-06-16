package com.furit.shop.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtils {

	@Value("${file.upload.path}")
	private String fileUploadPath;
	
	public String saveFile(MultipartFile file, String subDirectory) {
		if(file==null || file.getSize()==0) {
			return null;
		}
		String fileName = file.getOriginalFilename();
		int idx = fileName.lastIndexOf(".");
		String extName = fileName.substring(idx);
		fileName = subDirectory + "/" + UUID.randomUUID().toString() + extName;
		File directory = new File(fileUploadPath + subDirectory);
		if(!directory.exists()) {
			directory.mkdir();
		}
		File targetFile = new File(fileUploadPath + fileName);
		try {
			file.transferTo(targetFile);
			return fileName;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}