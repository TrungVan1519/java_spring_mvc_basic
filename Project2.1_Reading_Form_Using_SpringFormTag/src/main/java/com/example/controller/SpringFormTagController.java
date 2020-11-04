package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Student;

@Controller
@RequestMapping("/spring-form-tag")
public class SpringFormTagController {

	private List<Student> students;
	
	@PostConstruct	
	private void setupData() {
		students = new ArrayList<Student>();
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
		//		setId() bang tay thu cong (<=> AUTO_INCREASEMENT trong DB)
		Student newStudent = new Student();
		newStudent.setId(students.size());
		model.addAttribute("newStudent", newStudent);
		
		return "spring-form-tag-view/adding-form-view";
	}
	
	@PostMapping("/adding-form")
	public String addStudent(Model model, 
			@ModelAttribute("newStudent") Student student) {
		
		students.add(student);
		return "redirect:/spring-form-tag/students";
	}

	// Retrieve
	@GetMapping("/students")
	public String getStudentList(Model model) {

		model.addAttribute("students", students);
		return "spring-form-tag-view/student-list-view";
	}
	
	@GetMapping("/students/{studentId}")
	public String getSingleStudent(Model model,
			@PathVariable int studentId) {
		
		model.addAttribute("selectedStudent", students.get(studentId));
		return "spring-form-tag-view/single-student-view";
	}
	
	// Update
	@GetMapping("/updating-form/{studentId}")
	public String showUpdatingForm(Model model,
			@PathVariable int studentId) {
		
		model.addAttribute("existingStudent", students.get(studentId));
		return "spring-form-tag-view/updating-form-view";
	}
	
	@PostMapping("/updating-student")
	public String updateStudent(Model model,
			@ModelAttribute("existingStudent") Student existingStudent) {
		
		// update student's info
		Student student = students.get(existingStudent.getId());
		student.setUsername(existingStudent.getUsername());
		student.setPassword(existingStudent.getPassword());
		student.setAbout(existingStudent.getAbout());
		student.setAcceptAgreement(existingStudent.isAcceptAgreement());
		student.setCountry(existingStudent.getCountry());
		student.setGender(existingStudent.getGender());
		student.setId(existingStudent.getId());
		student.setProgrammingLanguage(existingStudent.getProgrammingLanguage());
		
		return "redirect:/spring-form-tag/students";
	}
	
	// Delete
	@GetMapping("/deleting-student/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {
		
		students.remove(studentId);
		
		for(Student student: students) {

			student.setId(students.indexOf(student));
		}
		
		return "redirect:/spring-form-tag/students";
	}
}
