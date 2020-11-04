package com.example.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.utils.Constant;

@Controller
@RequestMapping("/multiple-files")
public class MultipleFilesController {
	
	private List<String> imageNames;
	
	@PostConstruct
	private void setupData() {
		imageNames = new ArrayList<String>();
	}

	@GetMapping("/uploading")
	public String uploadFile(HttpServletRequest request) {
		
		return "multiple-files-view/uploading-file-view";
	}

	@PostMapping("/uploading")
	public String showUploadedFile(Model model,
			@RequestParam(name = "multipleChosenFile", required = true) List<MultipartFile> files) {

		if(files != null && files.size() > 0) {
			for (MultipartFile file : files) {

				// save file
				try {
					// write file by using java core - so basically :))
					String filePathName = Constant.PATH_SERVER_RESOURCE	+ file.getOriginalFilename();
					
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

					imageNames.add(file.getOriginalFilename());
				}
			}
			
			if(imageNames != null && imageNames.size() > 0) {

				model.addAttribute("imageNames", imageNames);
			}
		}

		return "multiple-files-view/show-uploaded-file-view";
	}
}
