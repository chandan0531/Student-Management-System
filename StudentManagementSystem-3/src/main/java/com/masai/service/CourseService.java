package com.masai.service;

import com.masai.exception.CourseException;
import com.masai.model.Course;

public interface CourseService {

	public String saveCourseDetails(Course course, Integer stdId) throws CourseException;
	
}
