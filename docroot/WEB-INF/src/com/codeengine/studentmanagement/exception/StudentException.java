package com.codeengine.studentmanagement.exception;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;


public class StudentException extends PortalException{
	
	public StudentException(List<String> errors) {

		this.errors = errors;
	}

	public List<String> getErrors() {

		return errors;
	}

	private List<String> errors;

}
