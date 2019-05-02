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

package com.codeengine.StudentManagement.service.impl;

import java.util.List;

import com.codeengine.StudentManagement.NoSuchStudentException;
import com.codeengine.StudentManagement.model.Student;
import com.codeengine.StudentManagement.service.base.StudentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the student local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.codeengine.StudentManagement.service.StudentLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author ces
 * @see com.codeengine.StudentManagement.service.base.StudentLocalServiceBaseImpl
 * @see com.codeengine.StudentManagement.service.StudentLocalServiceUtil
 */
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.codeengine.StudentManagement.service.StudentLocalServiceUtil} to
	 * access the student local service.
	 */
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.codeengine.service.service.StudentLocalServiceUtil} to access the
	 * student local service.
	 */

	/**
	 * Add new student
	 * 
	 * @param name
	 * @param email
	 * @return
	 * @throws SystemException
	 */
	public Student addStudentManual(String name, String email)
			throws SystemException, PortalException {
		long studentId = counterLocalService.increment();
		Student student = studentPersistence.create(studentId);
		student.setName(name);
		student.setEmail(email);
		studentPersistence.update(student);
		return student;
	}

	/**
	 * Find By Name
	 * 
	 * @throws Exception
	 */
	public List<Student> findByName(String name) throws Exception {
		// return StudentFinderUtil.findByName(name, QueryUtil.ALL_POS,
		// QueryUtil.ALL_POS);
		return studentFinder.findByNameDynamicQuery(name);
	}

	/**
	 * Get all students
	 * 
	 * @throws SystemException
	 */
	public List<Student> getAll() throws SystemException {
		return studentPersistence.findAll();
	}

	/**
	 * Update student
	 * 
	 * @param studentId
	 * @param name
	 * @param email
	 * @param serviceContext
	 * @return
	 * @throws SystemException
	 * @throws NoSuchStudentException
	 */
	public Student updateStudent(long studentId, String name, String email)
			throws SystemException, NoSuchStudentException {
		Student student = studentPersistence.findByPrimaryKey(studentId);
		student.setName(name);
		student.setEmail(email);
		updateStudent(student);
		return student;
	}
}