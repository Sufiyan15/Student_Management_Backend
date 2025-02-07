package com.example.Student_Management_System.service;

import com.example.Student_Management_System.repository.StudentRepository;
import com.example.Student_Management_System.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> optionalStudent = repository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            student.setStudentClass(updatedStudent.getStudentClass());
            student.setPhoneNumber(updatedStudent.getPhoneNumber());
            return repository.save(student);
        } else {
            throw new RuntimeException("Student not found");
        }
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    public List<Student> searchStudentsByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}
