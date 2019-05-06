/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.codeengine.studentmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.codeengine.studentmanagement.exception.StudentException;
import com.codeengine.studentmanagement.model.Student;
import com.codeengine.studentmanagement.service.base.StudentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the student local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.codeengine.studentmanagement.service.StudentLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author ces
 * @see com.codeengine.studentmanagement.service.base.StudentLocalServiceBaseImpl
 * @see com.codeengine.studentmanagement.service.StudentLocalServiceUtil
 */
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {

	/**
	 * Add or update student
	 * 
	 * @param studentId
	 * @param email
	 * @param name
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public Student addOrUpdateStudent(long studentId, String name, String email)
		throws PortalException, SystemException {

		validateStudent(name, email);
		Student student = studentPersistence.fetchByPrimaryKey(studentId);
		if (Validator.isNull(student)) {
			student =
				studentPersistence.create(counterLocalService.increment());
		}
		student.setName(name);
		student.setEmail(email);
		updateStudent(student);
		return student;
	}

	/**
	 * Find By Name
	 * 
	 * @throws Exception
	 */
	public List<Student> findByName(String name)
		throws Exception {

		return studentFinder.findByNameDynamicQuery(name);
	}

	/**
	 * Get all students
	 * 
	 * @throws SystemException
	 */
	public List<Student> getAll()
		throws SystemException {

		return studentPersistence.findAll();
	}

	/**
	 * Validate email and name
	 * 
	 * @param name
	 * @param email
	 * @throws PortalException
	 */
	private void validateStudent(String name, String email)
		throws PortalException {

		List<String> errors = new ArrayList<>();
		if (Validator.isNull(name)) {
			errors.add("please.enter.name");
		}
		if (name.length() > 10 || name.length() < 3) {
			errors.add("name.must.from.3.to.10.character");
		}
		if (Validator.isNull(email)) {
			errors.add("please.enter.email");
		}
		if (!Validator.isEmailAddress(email)) {
			errors.add("please.enter.correct.email.format");
		}
		if (errors.size() > 0) {
			throw new StudentException(errors);
		}

	}
}
