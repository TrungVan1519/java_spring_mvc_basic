package com.example.controller;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.utils.Constant;

@Controller
@RequestMapping("/single-file")
public class SingleFileController {

	@GetMapping("/uploading")
	public String uploadFile() {

		return "single-file-view/uploading-file-view";
	}

	@PostMapping("/uploading")
	public String showUploadedFile(Model model,
			@RequestParam(name = "chosenFile", required = true) MultipartFile file) {

		if (file != null) {
			// save file
			try {
				// write file by using java core - so basically :))
				String filePathName = Constant.PATH_SERVER_RESOURCE + file.getOriginalFilename();

				FileOutputStream outputStream = new FileOutputStream(new File(filePathName));
				outputStream.write(file.getBytes());
				outputStream.close();

			} catch (Exception e) {

				e.printStackTrace();
			}

			// pass value to View
			if (file.getOriginalFilename().contains(".png") 
					|| file.getOriginalFilename().contains(".jpg")
					|| file.getOriginalFilename().contains(".jpeg")) {

				model.addAttribute("uploadedImageName", file.getOriginalFilename());
			}
			
			System.out.println(">> Uploaded file successfully: " + file.getOriginalFilename());
		}

		return "single-file-view/show-uploaded-file-view";
	}
}
