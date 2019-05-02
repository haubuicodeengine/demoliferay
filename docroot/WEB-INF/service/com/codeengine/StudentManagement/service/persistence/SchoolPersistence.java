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

package com.codeengine.StudentManagement.service.persistence;

import com.codeengine.StudentManagement.model.School;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the school service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ces
 * @see SchoolPersistenceImpl
 * @see SchoolUtil
 * @generated
 */
public interface SchoolPersistence extends BasePersistence<School> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SchoolUtil} to access the school persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the schools where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching schools
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.codeengine.StudentManagement.model.School> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the schools where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.StudentManagement.model.impl.SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of schools
	* @param end the upper bound of the range of schools (not inclusive)
	* @return the range of matching schools
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.codeengine.StudentManagement.model.School> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the schools where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.StudentManagement.model.impl.SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of schools
	* @param end the upper bound of the range of schools (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching schools
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.codeengine.StudentManagement.model.School> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first school in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching school
	* @throws com.codeengine.StudentManagement.NoSuchSchoolException if a matching school could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.codeengine.StudentManagement.model.School findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.codeengine.StudentManagement.NoSuchSchoolException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first school in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching school, or <code>null</code> if a matching school could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.codeengine.StudentManagement.model.School fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last school in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching school
	* @throws com.codeengine.StudentManagement.NoSuchSchoolException if a matching school could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.codeengine.StudentManagement.model.School findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.codeengine.StudentManagement.NoSuchSchoolException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last school in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching school, or <code>null</code> if a matching school could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.codeengine.StudentManagement.model.School fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the schools before and after the current school in the ordered set where uuid = &#63;.
	*
	* @param schoolId the primary key of the current school
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next school
	* @throws com.codeengine.StudentManagement.NoSuchSchoolException if a school with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.codeengine.StudentManagement.model.School[] findByUuid_PrevAndNext(
		long schoolId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.codeengine.StudentManagement.NoSuchSchoolException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the schools where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of schools where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching schools
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the school in the entity cache if it is enabled.
	*
	* @param school the school
	*/
	public void cacheResult(
		com.codeengine.StudentManagement.model.School school);

	/**
	* Caches the schools in the entity cache if it is enabled.
	*
	* @param schools the schools
	*/
	public void cacheResult(
		java.util.List<com.codeengine.StudentManagement.model.School> schools);

	/**
	* Creates a new school with the primary key. Does not add the school to the database.
	*
	* @param schoolId the primary key for the new school
	* @return the new school
	*/
	public com.codeengine.StudentManagement.model.School create(long schoolId);

	/**
	* Removes the school with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param schoolId the primary key of the school
	* @return the school that was removed
	* @throws com.codeengine.StudentManagement.NoSuchSchoolException if a school with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.codeengine.StudentManagement.model.School remove(long schoolId)
		throws com.codeengine.StudentManagement.NoSuchSchoolException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.codeengine.StudentManagement.model.School updateImpl(
		com.codeengine.StudentManagement.model.School school)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the school with the primary key or throws a {@link com.codeengine.StudentManagement.NoSuchSchoolException} if it could not be found.
	*
	* @param schoolId the primary key of the school
	* @return the school
	* @throws com.codeengine.StudentManagement.NoSuchSchoolException if a school with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.codeengine.StudentManagement.model.School findByPrimaryKey(
		long schoolId)
		throws com.codeengine.StudentManagement.NoSuchSchoolException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the school with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param schoolId the primary key of the school
	* @return the school, or <code>null</code> if a school with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.codeengine.StudentManagement.model.School fetchByPrimaryKey(
		long schoolId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the schools.
	*
	* @return the schools
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.codeengine.StudentManagement.model.School> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.codeengine.StudentManagement.model.School> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the schools.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.StudentManagement.model.impl.SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schools
	* @param end the upper bound of the range of schools (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of schools
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.codeengine.StudentManagement.model.School> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the schools from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of schools.
	*
	* @return the number of schools
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}