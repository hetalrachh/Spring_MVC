package com.hetal.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hetal.validators.IsValidHobby;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"studentSkills"})
@JsonPropertyOrder({"student_name", "studentDOB", "gender", "studentMobile", "studentSkills", "studentHobby"})
public class Student {

	//@Pattern(regexp="^[0-9]*")
	@JsonProperty("student_name")
	private String studentName;

	@Past
	private Date studentDOB;

	private String gender;

	@Max(2222)
	private Long studentMobile;

	private List<String> studentSkills;

	private Address studentAddress;
	
	@Size(min = 2, max = 10, message="Please enter value of student hobby of length between {min} and {max}")
	@IsValidHobby(validHobbyList="cricket|football|badminton")
	private String studentHobby;

	public String getStudentHobby() {
		return studentHobby;
	}

	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	public List<String> getStudentSkills() {
		return studentSkills;
	}

	public void setStudentSkills(List<String> studentSkills) {
		this.studentSkills = studentSkills;
	}

	public Date getStudentDOB() {
		return studentDOB;
	}

	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}

	public Long getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
