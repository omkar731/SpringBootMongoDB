package com.omkar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.omkar.entity.Student;
import com.omkar.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	private final StudentService service;
	
	public StudentController(StudentService service) {
		this.service = service;
	}
	
	@PostMapping
	public Student create(@RequestBody Student student) {
		return service.save(student);
	}
	
	@GetMapping("/{id}")
	public Student getById(@PathVariable String id) {
		return service.getById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable String id) {
		service.deleteById(id);
	}
	@GetMapping("/course{course}")
	public List<Student> getByCourse(@PathVariable String course){
		return service.getByCourse(course);
	}
}
