package com.example.Student_Management_System.repository;

import com.example.Student_Management_System.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByNameContainingIgnoreCase(String name);
}
