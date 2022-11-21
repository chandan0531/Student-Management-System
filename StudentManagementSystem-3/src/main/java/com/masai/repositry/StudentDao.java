package com.masai.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.dto.StudentDto;
import com.masai.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{

	public List<Student> findByName(String name);
	
//	@Query("select new com.masai.dto.StudentDto(s.name,s.cellPhone) from student s inner join course c where s.studentId = ?1")
//	public StudentDto studentFromCourse(Integer id);
	
	
}
