package com.TestApp.example.TestApp.repository;

import com.TestApp.example.TestApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findStudentByAddress(String address);

}
