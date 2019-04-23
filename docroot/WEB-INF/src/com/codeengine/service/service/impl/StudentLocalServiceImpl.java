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

package com.codeengine.service.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.codeengine.service.NoSuchStudentException;
import com.codeengine.service.model.Student;
import com.codeengine.service.service.base.StudentLocalServiceBaseImpl;
import com.codeengine.service.service.persistence.StudentFinderUtil;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the student local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.codeengine.service.service.StudentLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author ces
 * @see com.codeengine.service.service.base.StudentLocalServiceBaseImpl
 * @see com.codeengine.service.service.StudentLocalServiceUtil
 */
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {
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
	public Student addStudentManual(String name, String email,
			ServiceContext serviceContext) throws SystemException,
			PortalException, NoSuchUserException {
		long studentId = counterLocalService.increment();
		Student student = studentPersistence.create(studentId);
		student.setName(name);
		student.setEmail(email);
		studentPersistence.update(student);
		return student;
	}
	
	/**
	 * Delete student
	 */
	public Student deleteStudent(long studentId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Student student = getStudent(studentId);
		student = deleteStudent(studentId);
		return student;
	}
	
	/**
	 * Find By Name
	 */
	public List<Student> findByName(String name) throws Exception{
//		return StudentFinderUtil.findByName(name, QueryUtil.ALL_POS,
//				QueryUtil.ALL_POS);
		return StudentFinderUtil.findByNameDynamicQuery(name);
	}
	
	/**
	 * Get all students
	 */
	public List<Student> getAll() throws SystemException {
		return studentPersistence.findAll();
	}

	/**
	 * Get student
	 */
	public Student getStudent(long studentId) throws SystemException,
			NoSuchStudentException {
		return studentPersistence.findByPrimaryKey(studentId);
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
	public Student updateStudent(long studentId, String name, String email,
			ServiceContext serviceContext) throws NoSuchStudentException,
			SystemException {
		Student student = getStudent(studentId);
		student.setName(name);
		student.setEmail(email);
		studentPersistence.update(student);
		return student;
	}

}