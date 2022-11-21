package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentId;
	
	@NotNull(message = "Name should not be null")
	private String name;
	
	@NotNull(message = "Gender should not be null")
	private String gender;
	
	@Size(min=10,max=10)
	private String cellPhone;
	
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "studs")
//	@JsonIgnore
	private List<Address> adds = new ArrayList<>();

	
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "students")
	private List<Course> courses = new ArrayList<>();
	
}
