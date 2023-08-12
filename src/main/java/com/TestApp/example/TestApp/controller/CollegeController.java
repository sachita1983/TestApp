package com.TestApp.example.TestApp.controller;

import com.TestApp.example.TestApp.model.College;
import com.TestApp.example.TestApp.model.Student;
import com.TestApp.example.TestApp.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CollegeController {

    @Autowired
    CollegeRepository collegeRepository;
    @GetMapping("/college")
    public ResponseEntity<List<College>> getAllCollege(){
        try {
            List<College> college = collegeRepository.findAll();
            return  new ResponseEntity<>(college, HttpStatus.OK);

        }
        catch (Exception e){
            return  new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/college")
    public ResponseEntity<College> createCollege(@RequestBody College college){

        try{
            College newCollege = collegeRepository.save(
                    new College(
                            college.getCollegeId(),
                            college.getCollegeName(),
                            college.getCollegeContactNo(),
                            college.getCollegeEmail(),
                            college.getCollegeAddress()
                    ));
            return  new ResponseEntity<>(newCollege,HttpStatus.CREATED);
        }
        catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
