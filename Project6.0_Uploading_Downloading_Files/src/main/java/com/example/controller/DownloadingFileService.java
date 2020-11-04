package com.example.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.utils.Constant;

@Controller
@RequestMapping("/downloading-file")
public class DownloadingFileService {

	@GetMapping("/{fileName:.+}")
	public void downloadFile(
			@PathVariable String fileName,
			HttpServletResponse response) {
		
		try {
			// path toi file can tai tren server
			File file = new File(Constant.PATH_SERVER_RESOURCE + fileName);
			
			if(!file.exists()) {
				String errorMessage = "Sorry. The file you are looking for does not exist";
	            System.out.println(errorMessage);
	            
	            OutputStream outputStream = response.getOutputStream();
	            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
	            outputStream.close();
	            return;
			}
			
			// Thiết lập thông tin trả về
			String mimeType= URLConnection.guessContentTypeFromName(file.getName());
	        if(mimeType == null){
	            System.out.println("mimetype is not detectable, will take default");
	            mimeType = "application/octet-stream";
	        }
	        System.out.println("mimetype : " + mimeType);
	         
			response.setContentType(mimeType);
			/* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
//			response.setHeader("Content-Disposition", "inline; filename=" + file.getName());
			
			/* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
	        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
			response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
			response.setContentLength((int) file.length());
			
			// Ghi file va download file ve
			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
			FileCopyUtils.copy(inputStream, response.getOutputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
