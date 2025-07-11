package com.omkar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.omkar.entity.Student;
import com.omkar.service.StudentService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // Create student
    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.save(student);
    }

    // Get all students
    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    // Get student by ID
    @GetMapping("/{id}")
    public Student getById(@PathVariable String id) {
        return service.getById(id);
    }

    // ✅ Update student by ID
    @PutMapping("/{id}")
    public Student update(@PathVariable String id, @RequestBody Student student) {
        Student existing = service.getById(id);
        if (existing == null) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        existing.setName(student.getName());
        existing.setAge(student.getAge());
        existing.setCourse(student.getCourse());
        existing.setEmail(student.getEmail());   // ✅ Email update
        existing.setPhone(student.getPhone());   // ✅ Phone update
        return service.save(existing);
    }

    // Delete student by ID
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        service.deleteById(id);
    }

    // Get students by course
    @GetMapping("/course/{course}")
    public List<Student> getByCourse(@PathVariable String course) {
        return service.getByCourse(course);
    }
}
