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

package com.codeengine.StudentManagement.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SchoolLocalService}.
 *
 * @author ces
 * @see SchoolLocalService
 * @generated
 */
public class SchoolLocalServiceWrapper implements SchoolLocalService,
	ServiceWrapper<SchoolLocalService> {
	public SchoolLocalServiceWrapper(SchoolLocalService schoolLocalService) {
		_schoolLocalService = schoolLocalService;
	}

	/**
	* Adds the school to the database. Also notifies the appropriate model listeners.
	*
	* @param school the school
	* @return the school that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.codeengine.StudentManagement.model.School addSchool(
		com.codeengine.StudentManagement.model.School school)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _schoolLocalService.addSchool(school);
	}

	/**
	* Creates a new school with the primary key. Does not add the school to the database.
	*
	* @param schoolId the primary key for the new school
	* @return the new school
	*/
	@Override
	public com.codeengine.StudentManagement.model.School createSchool(
		long schoolId) {
		return _schoolLocalService.createSchool(schoolId);
	}

	/**
	* Deletes the school with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param schoolId the primary key of the school
	* @return the school that was removed
	* @throws PortalException if a school with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.codeengine.StudentManagement.model.School deleteSchool(
		long schoolId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _schoolLocalService.deleteSchool(schoolId);
	}

	/**
	* Deletes the school from the database. Also notifies the appropriate model listeners.
	*
	* @param school the school
	* @return the school that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.codeengine.StudentManagement.model.School deleteSchool(
		com.codeengine.StudentManagement.model.School school)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _schoolLocalService.deleteSchool(school);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _schoolLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _schoolLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.StudentManagement.model.impl.SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _schoolLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.StudentManagement.model.impl.SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _schoolLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _schoolLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _schoolLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.codeengine.StudentManagement.model.School fetchSchool(
		long schoolId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _schoolLocalService.fetchSchool(schoolId);
	}

	/**
	* Returns the school with the primary key.
	*
	* @param schoolId the primary key of the school
	* @return the school
	* @throws PortalException if a school with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.codeengine.StudentManagement.model.School getSchool(
		long schoolId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _schoolLocalService.getSchool(schoolId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _schoolLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the schools.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.StudentManagement.model.impl.SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schools
	* @param end the upper bound of the range of schools (not inclusive)
	* @return the range of schools
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.codeengine.StudentManagement.model.School> getSchools(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _schoolLocalService.getSchools(start, end);
	}

	/**
	* Returns the number of schools.
	*
	* @return the number of schools
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSchoolsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _schoolLocalService.getSchoolsCount();
	}

	/**
	* Updates the school in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param school the school
	* @return the school that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.codeengine.StudentManagement.model.School updateSchool(
		com.codeengine.StudentManagement.model.School school)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _schoolLocalService.updateSchool(school);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _schoolLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_schoolLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _schoolLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SchoolLocalService getWrappedSchoolLocalService() {
		return _schoolLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSchoolLocalService(
		SchoolLocalService schoolLocalService) {
		_schoolLocalService = schoolLocalService;
	}

	@Override
	public SchoolLocalService getWrappedService() {
		return _schoolLocalService;
	}

	@Override
	public void setWrappedService(SchoolLocalService schoolLocalService) {
		_schoolLocalService = schoolLocalService;
	}

	private SchoolLocalService _schoolLocalService;
}