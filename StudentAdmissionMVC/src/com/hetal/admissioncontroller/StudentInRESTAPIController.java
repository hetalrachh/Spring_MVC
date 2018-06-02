package com.hetal.admissioncontroller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hetal.model.Student;

@RestController
public class StudentInRESTAPIController {

	// Retrieving all student record
	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Student> getStudentsList() {

		ArrayList<Student> list = new ArrayList<Student>();

		Student s1 = new Student();
		s1.setStudentName("hetal");
		s1.setGender("female");

		Student s2 = new Student();
		s2.setStudentName("priya");
		s2.setGender("female");

		Student s3 = new Student();
		s3.setStudentName("pooja");
		s3.setGender("female");

		list.add(s1);
		list.add(s2);
		list.add(s3);

		return list;

	}

	// Retrieving one student record based on name
	@RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("name") String studentName) {

		Student s = new Student();
		s.setStudentName(studentName);
		s.setStudentHobby("Painting");
		return s;
	}

	// updating student record
	@RequestMapping(value = "/students/{name}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateStudent(@PathVariable("name") String studentName,
			@RequestBody Student student) {

		boolean isUpdated = false;

		System.out.println("Student name is " + student.getStudentName());
		System.out.println("Student hobby " + student.getStudentHobby());

		// adding customised headers to response
		HttpHeaders headers = new HttpHeaders();
		headers.add("key1", "value1");

		if (isUpdated) {
			return new ResponseEntity<Boolean>(true, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(false, headers, HttpStatus.NOT_FOUND);
		}

	}

	// creating a new student record
	@RequestMapping(value = "/students", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> createStudent(@RequestBody Student student) {

		System.out.println("Creating a new student record " + student.getStudentName());

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}")
				.buildAndExpand(student.getStudentName()).toUri().toString());

		return new ResponseEntity<Boolean>(true, headers, HttpStatus.CREATED);

	}

	// Deleting a student record
	@RequestMapping(value = "/students/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteStudent(@PathVariable("name") String studentName) {

		System.out.println("Deleting a student record " + studentName);

		return new ResponseEntity<Boolean>(true, HttpStatus.OK);

	}

	// Deleting all student record
	@RequestMapping(value = "/students", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAllStudents() {

		return new ResponseEntity<Boolean>(true, HttpStatus.OK);

	}

}
