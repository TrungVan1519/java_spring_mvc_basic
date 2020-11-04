package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Student;

@Controller
@RequestMapping("/default-validation")
public class DefaultValidationController {

	private List<Student> students;
	
	@PostConstruct	
	private void setupData() {
		students = new ArrayList<Student>();
	}
	
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder) {
		
		// add and initBinder to convert trum input string
		// remove leading and trailing whitespace
		// resolve issue for our validation
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, editor);
	}
	
	// Create
	@GetMapping("/adding-form")
	public String showAddingForm(Model model) {
		
		// > Vi:
		//	+ Day chi la VD cho @ModelAttibute vs Spring Form Tags
		// 		nen o day su dung List<Student> de them thay vi su dung DB
		//	+ Prop Id cua Student khong duoc phep nhap du lieu tu Form,
		//		no phai tu dong co truoc
		// > Cung vi ly do tren ma Student khong co id truoc nen phai
		//		setId() bang tay thu cong <=> AUTO_INCREASWMENT
		Student student = new Student();
		student.setId(students.size());
		model.addAttribute("newStudent", student);
		
		return "addingFormView.definition";
	}
	
	@PostMapping("/adding-form")
	public String addStudent(Model model, 
			@Valid @ModelAttribute("newStudent") Student student,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			// print the error to override message error if needed
			System.out.println(">> bindingResult: " + bindingResult);
			return "addingFormView.definition";
		}
		
		students.add(student);
		return "redirect:/default-validation/students";
	}

	// Retrieve list
	@GetMapping("/students")
	public String getStudentList(Model model) {

		model.addAttribute("students", students);
		return "studentListView.definition";
	}
}
