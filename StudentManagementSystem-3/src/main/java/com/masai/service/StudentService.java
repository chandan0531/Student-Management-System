package com.masai.service;

import java.util.List;

import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Student;

public interface StudentService {

	
	
	public Student saveStudents(Student std)throws StudentException;
	
	public List<Student> getAllStudent()throws StudentException;
	
	public Student updateStudentById(Student std ,Integer Id) throws StudentException;
	
    public String deleteStudentById(Integer Id) throws StudentException;
    
    public Student registerStudentInCourse(String cname, Student student)throws CourseException;
   
    
    public List<Student> findStudentsByName(String name)throws StudentException;
}
