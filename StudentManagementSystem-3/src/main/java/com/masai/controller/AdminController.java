package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Student;
import com.masai.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class AdminController {

	
	@Autowired
	private StudentService sService;
	
	
	
	@PostMapping("/")
	 ResponseEntity<Student> createStudentHandeller(@Valid @RequestBody Student std){
	        Student  stds =  sService.saveStudents(std);       
	         return new ResponseEntity<>(stds,HttpStatus.CREATED);         
	 }
	
	
	
	
	@GetMapping("/")
	 ResponseEntity<List<Student>> getAllStudentHandeller(){
        List<Student> stds = sService.getAllStudent();      
        
        return new ResponseEntity<List<Student>>(stds,HttpStatus.ACCEPTED);         
    }
	
	
	
	
	@PutMapping("/{Id}")
	 ResponseEntity<Student> updateStudentByIdHandeller(@RequestBody Student std ,@PathVariable Integer Id){
       
		Student stds =  sService.updateStudentById(std, Id);
        
        return new ResponseEntity<Student>(stds,HttpStatus.ACCEPTED);         
    }
	
	

	 @DeleteMapping("/{Id}")
	 ResponseEntity<String> deleteStudentByIdHandeller(@PathVariable Integer Id){
		 
		 
        String message =  sService.deleteStudentById(Id);
        
        return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);         
    }
	 
	 
	 @GetMapping("/{name}")
	 ResponseEntity<List<Student>> getStudentsByNameHandeller(@PathVariable String name){
        List<Student> stds = sService.findStudentsByName(name);      
        
        return new ResponseEntity<List<Student>>(stds,HttpStatus.ACCEPTED);         
    }
	 
	 
}
