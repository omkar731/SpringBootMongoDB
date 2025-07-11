package com.omkar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.omkar.entity.Student;
import com.omkar.repo.StudentRepository;

@Service
public class StudentService {

	private final StudentRepository repo;

	public StudentService(StudentRepository repo) {
		this.repo = repo;
	}

	public List<Student> getAll() {
		return repo.findAll();
	}

	public Student getById(String id) {
		return repo.findById(id).orElse(null); // Or throw custom exception
	}

	public void deleteById(String id) {
		repo.deleteById(id);
	}

	public Student save(Student student) {
		return repo.save(student);
	}

	public List<Student> getByCourse(String course) {
		return repo.findByCourse(course);
	}
}
