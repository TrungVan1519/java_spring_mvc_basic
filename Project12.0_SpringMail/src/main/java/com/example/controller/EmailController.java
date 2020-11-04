package com.example.controller;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.utils.Constant;

@Controller
@ResponseBody
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private JavaMailSender emailSender;

	@GetMapping("/simple-email")
    public String sendSimpleEmail() {
 
        // Create a Simple MailMessage.
        SimpleMailMessage emailMessage = new SimpleMailMessage();
        emailMessage.setTo(Constant.RECEIVER_EMAIL);
        emailMessage.setSubject("Test simple email");
        emailMessage.setText("Hello, I'm testing simple email");
 
        // Send Message!
        emailSender.send(emailMessage);
 
        return "Email Sent!";
    }
	
    @RequestMapping("/attachment-email")
    public String sendAttachmentEmail() throws MessagingException {
 
        MimeMessage emailMessage = emailSender.createMimeMessage();
 
        boolean multipart = true;
 
        MimeMessageHelper helper = new MimeMessageHelper(emailMessage, multipart, "utf-8");
        helper.setTo(Constant.RECEIVER_EMAIL);
        helper.setSubject("Test email with attachments");
        helper.setText("Hello, Im testing email with attachments!");
         
        // Attachment 
        FileSystemResource attatchmentFile = 
        		new FileSystemResource(new File("C:/Users\\Admin/Desktop/angel.jpg"));
        helper.addAttachment("Image file", attatchmentFile);

        // Send Message!
        emailSender.send(emailMessage);
 
        return "Email Sent!";
    }
	
    @RequestMapping("/html-email")
    public String sendHtmlEmail() throws MessagingException {
 
        MimeMessage message = emailSender.createMimeMessage();
 
        boolean multipart = true;
         
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        helper.setTo(Constant.RECEIVER_EMAIL);
        helper.setSubject("Test send HTML email");
        String htmlMessage = "<h3>Im testing send a HTML email</h3>"
                +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>";
        message.setContent(htmlMessage, "text/html");
         
        // Send Message!
        emailSender.send(message);
 
        return "Email Sent!";
    }
}
