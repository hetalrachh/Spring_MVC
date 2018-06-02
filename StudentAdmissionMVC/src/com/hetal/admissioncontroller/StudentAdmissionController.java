package com.hetal.admissioncontroller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hetal.customeditor.StudentNamePropertyEditor;
import com.hetal.model.Student;

@Controller
public class StudentAdmissionController {

	@InitBinder
	public void initBinder(WebDataBinder bind) {
		bind.setDisallowedFields(new String[] { "studentMobile" });
		SimpleDateFormat format = new SimpleDateFormat("yyyy****mm****dd");
		bind.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(format, false));

		// using custom property editor
		bind.registerCustomEditor(String.class, "studentName", new StudentNamePropertyEditor());
	}

	@RequestMapping(value = "/admissionform.html", method = RequestMethod.GET)
	public ModelAndView submitAdmissionForm() {

		/*String exceptionOccured = "ARITHMETIC-EXCEPTION";

		if (exceptionOccured.equals("NULL-POINTER")) {
			throw new NullPointerException("Null pointer exception");
		} else if (exceptionOccured.equals("ARITHMETIC-EXCEPTION")) {
			throw new ArithmeticException("Arithmetic exception");
		}*/

		ModelAndView model = new ModelAndView("admission-form");
		return model;

	}

	@RequestMapping(value = "/submitadmissionform.html", method = RequestMethod.POST)
	public ModelAndView displayAdmissionForm(@Valid @ModelAttribute("studentDetails") Student studentDetails,
			BindingResult result) {

		if (result.hasErrors()) {
			ModelAndView model1 = new ModelAndView("admission-form");
			return model1;
		}

		ModelAndView model = new ModelAndView("display-form");

		// Use below when using @RequestParam
		/*
		 * String studentName = studentData.get("studentName");
		 * 
		 * String studentdob = studentData.get("studentDOB");
		 * 
		 * String gender = studentData.get("gender");
		 * 
		 * String address = studentData.get("address");
		 */

		/*
		 * Student s = new Student(); s.setStudentName(studentName);
		 * s.setStudentDOB(studentdob); s.setGender(gender);
		 * s.setAddress(address);
		 */

		model.addObject("message", "Your registered details are: ");

		// Use below when using @RequestParam
		// model.addObject("studentDetails", s);

		return model;

	}

	@ModelAttribute
	public void addingCommonObjects(Model model) {
		model.addAttribute("headerMessage", "Rave Technologies Admission Process");
	}

}
