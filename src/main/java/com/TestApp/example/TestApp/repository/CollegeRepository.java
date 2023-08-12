package com.TestApp.example.TestApp.repository;

import com.TestApp.example.TestApp.model.College;
import com.TestApp.example.TestApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College,Long> {

}
