package com.masai.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentDto {

	
	@NotNull(message = "Name should not be null")
	private String name;
	
	@NotNull(message = "Gender should not be null")
	private String gender;
	
	@Size(min=10,max=10)
	private String cellPhone;
	
	private String email;

	public StudentDto(@NotNull(message = "Name should not be null") String name,
			@NotNull(message = "Gender should not be null") String gender, @Size(min = 10, max = 10) String cellPhone,
			String email) {
		super();
		this.name = name;
		this.gender = gender;
		this.cellPhone = cellPhone;
		this.email = email;
	}

	public StudentDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
