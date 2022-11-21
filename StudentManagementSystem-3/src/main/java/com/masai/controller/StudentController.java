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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Address;
import com.masai.service.AddressService;
import com.masai.service.StudentService;

@RestController
@RequestMapping("/api/employees/{empId}/address")

public class StudentController {

	
	@Autowired
	private AddressService aService;
	
	@Autowired
	private StudentService sService;
	
	
	@PostMapping("/")
	ResponseEntity<String> createAddressByStudentIdHandeller(@Valid @RequestBody Address add ,
			@PathVariable("stdId") Integer Id){
		            
		String message =  aService.createAddressById(add, Id);     
		            
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/")
	ResponseEntity<List<Address>> getAllAddressByStudentIddHandeller(@PathVariable("stdId") Integer Id){
		          
		List<Address> stds =  aService.getAllAddressByStudentId(Id);    
		            
		return new ResponseEntity<List<Address>>(stds, HttpStatus.ACCEPTED);
	}
	
	
	
	
	@GetMapping("/{Id}")
	ResponseEntity<Address> getAddresstByIdHndeller(@PathVariable("stdId") Integer Id, @PathVariable("Id") Integer  addId){
		
		Address stds =   aService.getAddressByAddressId(Id, addId);
		            
		return new ResponseEntity<Address>(stds, HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/{Id}")
	ResponseEntity<String> deleteAddressById(@PathVariable("stdId") Integer Id, @PathVariable("Id") Integer addId){
		            String mess =  aService.deleteAddressById(Id, addId);    
		            return new ResponseEntity<String>(mess, HttpStatus.ACCEPTED);
	}
	
}
