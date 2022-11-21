package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Address;
import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.repositry.AddressDao;
import com.masai.repositry.CourseDao;
import com.masai.repositry.StudentDao;

@Service
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	private StudentDao sDao;
	
	@Autowired
	private AddressDao aDao;
	
	@Autowired
	private CourseDao cDao;

	@Override
	public Student saveStudents(Student std) throws StudentException {
		
		
		 Optional<Student> opt  = sDao.findById(std.getStudentId());
		  if(opt.isPresent())
		  {
			  throw new StudentException("Employee already present");
		  }
		  else
		  {
//			  eDao.save(emp);
			  System.out.println(std + "hello");
			  System.out.println(std.getAdds() + "hello");
			  
			  List<Address> adds= std.getAdds();//[]
			  System.out.println(adds + "hello"); //[]
			  for(Address add: adds)
			  {
				  
				  add.setStuds(std);
//				  aDao.save(add);
				  
			  }
			  std.setAdds(adds);

			  List<Course> cous = std.getCourses();
			  
			  for(Course course : cous)
			  {
//				  course.getStudents().add(std);
//				  cDao.save(course);
				  
				  List<Student> students = course.getStudents();
				  students.add(std);
				  course.setStudents(students);
			  }
			  std.setCourses(cous);
			
			  return sDao.save(std);
			  
		  }
	}		  

	@Override
	public List<Student> getAllStudent() throws StudentException {
		
		List<Student> students = sDao.findAll();
		
		if(students.size() > 0)
		{
			return students;
		}
		else
		{
			throw new StudentException("Employee Not present");
		}

	}


	@Override
	public Student updateStudentById(Student std, Integer Id) throws StudentException {
		
		 Optional<Student> opt  = sDao.findById(Id);
		
		 if(opt.isPresent())
		 {
			 sDao.save(std);
			 return std;
		 }
		
		 else
		 {
			 throw new StudentException("Student Not present with: " + Id);  
		 }
	}

	@Override
	public String deleteStudentById(Integer Id) throws StudentException {
		
		
		Optional<Student> opt  = sDao.findById(Id);
		
		if(opt.isPresent())
		{
			Student std = opt.get();
			sDao.delete(std);
			return "Student details have been deleted with :  + Id";
		}
		else
		{
			throw new StudentException("Student Not present with: " + Id);  
		}
	}

	@Override
	public Student registerStudentInCourse(String cname, Student student)throws CourseException {
		
		Course course= cDao.findByCourseName(cname);
		
		if(course != null) {
			
			course.getStudents().add(student);
			student.getCourses().add(course);
			
			return sDao.save(student);
		}
		else
		{
			throw new CourseException("Course Does not exist with Cname "+cname);
		}
	}

	@Override
	public List<Student> findStudentsByName(String name) throws StudentException {
		
		List<Student> students = sDao.findByName(name);
		
		if(students.size()> 0)
		{
			return students;
		}
		else
		{
			throw new StudentException("Student not exist with the name:  " + name);
		}
		
		
	}
	
	
}
