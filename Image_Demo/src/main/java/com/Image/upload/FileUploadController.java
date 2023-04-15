package com.Image.upload;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
	@PostMapping("/uploadFile")
	public ResponseEntity<FileUploadResponse> uploadFile(@RequestParam("file") MultipartFile multipartFile)
	{
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		long size = multipartFile.getSize();
		
		FileUploadResponse response = new FileUploadResponse();
		
		response.setFileName(fileName);
		response.setSize(size);
		String fileCode = null;
		response.setDownloadUri("/downloadFile/" + fileCode);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

}
