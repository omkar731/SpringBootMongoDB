package com.omkar.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.omkar.entity.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
	List<Student>findByCourse(String course);
	
}