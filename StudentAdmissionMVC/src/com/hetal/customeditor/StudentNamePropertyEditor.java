package com.hetal.customeditor;

import java.beans.PropertyEditorSupport;

public class StudentNamePropertyEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String studentName) throws IllegalArgumentException {
		if(studentName.contains("Ms.") || studentName.contains("Mr.")) {
			setValue(studentName);
		} else {
			setValue("Ms." + studentName);
		}
	}

}
