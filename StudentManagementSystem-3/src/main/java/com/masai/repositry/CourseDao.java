package com.masai.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer>{
	
	public Course findByCourseName(String cname);
}
