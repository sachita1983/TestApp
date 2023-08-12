package com.TestApp.example.TestApp.controller;


import com.TestApp.example.TestApp.model.Student;
import com.TestApp.example.TestApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    @GetMapping("/students")
    public  ResponseEntity<List<Student>> getAllStudents(){
       try {
           List<Student> students = studentRepository.findAll();
           return  new ResponseEntity<>(students,HttpStatus.OK);

       }
       catch (Exception e){
           return  new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        try{
            Student newStudent = studentRepository.save(
                    new Student(
                            student.getStudent_id(),
                            student.getStudent_name()
                            ,student.getContact_no()
                            , student.getEmail()
                            , student.getAddress()
                             ));
            return  new ResponseEntity<>(newStudent,HttpStatus.CREATED);
        }
        catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("student/{id}")
    public  ResponseEntity<Student> updateStudents(@PathVariable("id") Long id,@RequestBody Student student){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()){
            Student student1 = studentOptional.get();
            student1.setStudent_name(student.getStudent_name());
            student1.setEmail(student.getEmail());
            student1.setAddress(student.getAddress());
            student1.setContact_no(student.getContact_no());
            return  new ResponseEntity<>(studentRepository.save(student1),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("student/{id}")
    public  ResponseEntity<Student> getStudentByID(@PathVariable("id") Long id){
        Optional<Student> student =studentRepository.findById(id);
        if (student.isPresent()){
            return  new ResponseEntity<>(student.get(),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        try{
            studentRepository.deleteById(id);
            return   ResponseEntity.ok("Successfully Deleted");
        }
        catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("studentAddress")
    public  ResponseEntity<List<Student>> getStudentFromAddress(@RequestParam("address") String address){
        List<Student> students =studentRepository.findStudentByAddress(address);
         if (students.isEmpty()){
             return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         return  ResponseEntity.ok(students);
    }
}
