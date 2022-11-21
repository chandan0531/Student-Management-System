package com.masai.dto;

public class CourseDto {

	
	private Integer courseId;
	
	private String courseName;
	
	private String description;
	
	private String courseType;

	public CourseDto(Integer courseId, String courseName, String description, String courseType) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.courseType = courseType;
	}

	public CourseDto() {
		
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	
	
	
}
