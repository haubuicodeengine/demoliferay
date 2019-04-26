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

package com.codeengine.service.service.base;

import com.codeengine.service.model.Clazz;
import com.codeengine.service.service.ClazzService;
import com.codeengine.service.service.persistence.ClazzPersistence;
import com.codeengine.service.service.persistence.SchoolPersistence;
import com.codeengine.service.service.persistence.StudentFinder;
import com.codeengine.service.service.persistence.StudentPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the clazz remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.codeengine.service.service.impl.ClazzServiceImpl}.
 * </p>
 *
 * @author ces
 * @see com.codeengine.service.service.impl.ClazzServiceImpl
 * @see com.codeengine.service.service.ClazzServiceUtil
 * @generated
 */
public abstract class ClazzServiceBaseImpl extends BaseServiceImpl
	implements ClazzService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.codeengine.service.service.ClazzServiceUtil} to access the clazz remote service.
	 */

	/**
	 * Returns the clazz local service.
	 *
	 * @return the clazz local service
	 */
	public com.codeengine.service.service.ClazzLocalService getClazzLocalService() {
		return clazzLocalService;
	}

	/**
	 * Sets the clazz local service.
	 *
	 * @param clazzLocalService the clazz local service
	 */
	public void setClazzLocalService(
		com.codeengine.service.service.ClazzLocalService clazzLocalService) {
		this.clazzLocalService = clazzLocalService;
	}

	/**
	 * Returns the clazz remote service.
	 *
	 * @return the clazz remote service
	 */
	public com.codeengine.service.service.ClazzService getClazzService() {
		return clazzService;
	}

	/**
	 * Sets the clazz remote service.
	 *
	 * @param clazzService the clazz remote service
	 */
	public void setClazzService(
		com.codeengine.service.service.ClazzService clazzService) {
		this.clazzService = clazzService;
	}

	/**
	 * Returns the clazz persistence.
	 *
	 * @return the clazz persistence
	 */
	public ClazzPersistence getClazzPersistence() {
		return clazzPersistence;
	}

	/**
	 * Sets the clazz persistence.
	 *
	 * @param clazzPersistence the clazz persistence
	 */
	public void setClazzPersistence(ClazzPersistence clazzPersistence) {
		this.clazzPersistence = clazzPersistence;
	}

	/**
	 * Returns the school local service.
	 *
	 * @return the school local service
	 */
	public com.codeengine.service.service.SchoolLocalService getSchoolLocalService() {
		return schoolLocalService;
	}

	/**
	 * Sets the school local service.
	 *
	 * @param schoolLocalService the school local service
	 */
	public void setSchoolLocalService(
		com.codeengine.service.service.SchoolLocalService schoolLocalService) {
		this.schoolLocalService = schoolLocalService;
	}

	/**
	 * Returns the school remote service.
	 *
	 * @return the school remote service
	 */
	public com.codeengine.service.service.SchoolService getSchoolService() {
		return schoolService;
	}

	/**
	 * Sets the school remote service.
	 *
	 * @param schoolService the school remote service
	 */
	public void setSchoolService(
		com.codeengine.service.service.SchoolService schoolService) {
		this.schoolService = schoolService;
	}

	/**
	 * Returns the school persistence.
	 *
	 * @return the school persistence
	 */
	public SchoolPersistence getSchoolPersistence() {
		return schoolPersistence;
	}

	/**
	 * Sets the school persistence.
	 *
	 * @param schoolPersistence the school persistence
	 */
	public void setSchoolPersistence(SchoolPersistence schoolPersistence) {
		this.schoolPersistence = schoolPersistence;
	}

	/**
	 * Returns the student local service.
	 *
	 * @return the student local service
	 */
	public com.codeengine.service.service.StudentLocalService getStudentLocalService() {
		return studentLocalService;
	}

	/**
	 * Sets the student local service.
	 *
	 * @param studentLocalService the student local service
	 */
	public void setStudentLocalService(
		com.codeengine.service.service.StudentLocalService studentLocalService) {
		this.studentLocalService = studentLocalService;
	}

	/**
	 * Returns the student remote service.
	 *
	 * @return the student remote service
	 */
	public com.codeengine.service.service.StudentService getStudentService() {
		return studentService;
	}

	/**
	 * Sets the student remote service.
	 *
	 * @param studentService the student remote service
	 */
	public void setStudentService(
		com.codeengine.service.service.StudentService studentService) {
		this.studentService = studentService;
	}

	/**
	 * Returns the student persistence.
	 *
	 * @return the student persistence
	 */
	public StudentPersistence getStudentPersistence() {
		return studentPersistence;
	}

	/**
	 * Sets the student persistence.
	 *
	 * @param studentPersistence the student persistence
	 */
	public void setStudentPersistence(StudentPersistence studentPersistence) {
		this.studentPersistence = studentPersistence;
	}

	/**
	 * Returns the student finder.
	 *
	 * @return the student finder
	 */
	public StudentFinder getStudentFinder() {
		return studentFinder;
	}

	/**
	 * Sets the student finder.
	 *
	 * @param studentFinder the student finder
	 */
	public void setStudentFinder(StudentFinder studentFinder) {
		this.studentFinder = studentFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Clazz.class;
	}

	protected String getModelClassName() {
		return Clazz.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = clazzPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.codeengine.service.service.ClazzLocalService.class)
	protected com.codeengine.service.service.ClazzLocalService clazzLocalService;
	@BeanReference(type = com.codeengine.service.service.ClazzService.class)
	protected com.codeengine.service.service.ClazzService clazzService;
	@BeanReference(type = ClazzPersistence.class)
	protected ClazzPersistence clazzPersistence;
	@BeanReference(type = com.codeengine.service.service.SchoolLocalService.class)
	protected com.codeengine.service.service.SchoolLocalService schoolLocalService;
	@BeanReference(type = com.codeengine.service.service.SchoolService.class)
	protected com.codeengine.service.service.SchoolService schoolService;
	@BeanReference(type = SchoolPersistence.class)
	protected SchoolPersistence schoolPersistence;
	@BeanReference(type = com.codeengine.service.service.StudentLocalService.class)
	protected com.codeengine.service.service.StudentLocalService studentLocalService;
	@BeanReference(type = com.codeengine.service.service.StudentService.class)
	protected com.codeengine.service.service.StudentService studentService;
	@BeanReference(type = StudentPersistence.class)
	protected StudentPersistence studentPersistence;
	@BeanReference(type = StudentFinder.class)
	protected StudentFinder studentFinder;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private ClazzServiceClpInvoker _clpInvoker = new ClazzServiceClpInvoker();
}