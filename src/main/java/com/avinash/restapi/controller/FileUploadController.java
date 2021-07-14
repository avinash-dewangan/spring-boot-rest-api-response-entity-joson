package com.avinash.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.avinash.restapi.helper.FileUploadHelper;

@RestController
public class FileUploadController {

	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());

		try {

			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
			}
			if (!file.getContentType().equals("image/png")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only png allowed");
			}

			boolean f = fileUploadHelper.uploadFile(file);
			if (f) {
				// return ResponseEntity.ok("File uploaded successfully");
				// localhost:8080/images/filename
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/")
						.path(file.getOriginalFilename()).toUriString());
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		/**
		 * file upload TODO Where to upload the file on server: UPLOAD_DIR:
		 * E:\F\avinash-tech\springboot\spring-boot-rest-api\src\main\resources\static\images
		 */

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong please try agin");

	}
}
