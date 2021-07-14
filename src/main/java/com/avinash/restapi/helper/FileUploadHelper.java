package com.avinash.restapi.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	// public final String UPLOAD_DIR =
	// "E:\\F\\avinash-tech\\springboot\\spring-boot-rest-api\\src\\main\\resources\\static\\images";
	public final String UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();
	boolean file = false;

	public FileUploadHelper() throws IOException {
		super();
	}

	public boolean uploadFile(MultipartFile mulfile) {

		try {

			/**
			 * //Old method InputStream is= mulfile.getInputStream(); byte data[] = new
			 * byte[is.available()]; is.read(data);
			 * 
			 * //write FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator
			 * +mulfile.getOriginalFilename()); fos.write(data); fos.flush(); fos.close();
			 */

			// second method
			Files.copy(mulfile.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + mulfile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);

			file = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
