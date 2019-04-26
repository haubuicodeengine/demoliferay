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

package com.codeengine.service.service.persistence;

import com.codeengine.service.model.School;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the school service. This utility wraps {@link SchoolPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ces
 * @see SchoolPersistence
 * @see SchoolPersistenceImpl
 * @generated
 */
public class SchoolUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(School school) {
		getPersistence().clearCache(school);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<School> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<School> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<School> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static School update(School school) throws SystemException {
		return getPersistence().update(school);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static School update(School school, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(school, serviceContext);
	}

	/**
	* Returns all the schools where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching schools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.codeengine.service.model.School> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the schools where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.service.model.impl.SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of schools
	* @param end the upper bound of the range of schools (not inclusive)
	* @return the range of matching schools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.codeengine.service.model.School> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the schools where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.service.model.impl.SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of schools
	* @param end the upper bound of the range of schools (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching schools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.codeengine.service.model.School> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first school in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching school
	* @throws com.codeengine.service.NoSuchSchoolException if a matching school could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.codeengine.service.model.School findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.codeengine.service.NoSuchSchoolException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first school in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching school, or <code>null</code> if a matching school could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.codeengine.service.model.School fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last school in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching school
	* @throws com.codeengine.service.NoSuchSchoolException if a matching school could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.codeengine.service.model.School findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.codeengine.service.NoSuchSchoolException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last school in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching school, or <code>null</code> if a matching school could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.codeengine.service.model.School fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the schools before and after the current school in the ordered set where uuid = &#63;.
	*
	* @param schoolId the primary key of the current school
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next school
	* @throws com.codeengine.service.NoSuchSchoolException if a school with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.codeengine.service.model.School[] findByUuid_PrevAndNext(
		long schoolId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.codeengine.service.NoSuchSchoolException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(schoolId, uuid, orderByComparator);
	}

	/**
	* Removes all the schools where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of schools where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching schools
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the school in the entity cache if it is enabled.
	*
	* @param school the school
	*/
	public static void cacheResult(com.codeengine.service.model.School school) {
		getPersistence().cacheResult(school);
	}

	/**
	* Caches the schools in the entity cache if it is enabled.
	*
	* @param schools the schools
	*/
	public static void cacheResult(
		java.util.List<com.codeengine.service.model.School> schools) {
		getPersistence().cacheResult(schools);
	}

	/**
	* Creates a new school with the primary key. Does not add the school to the database.
	*
	* @param schoolId the primary key for the new school
	* @return the new school
	*/
	public static com.codeengine.service.model.School create(long schoolId) {
		return getPersistence().create(schoolId);
	}

	/**
	* Removes the school with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param schoolId the primary key of the school
	* @return the school that was removed
	* @throws com.codeengine.service.NoSuchSchoolException if a school with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.codeengine.service.model.School remove(long schoolId)
		throws com.codeengine.service.NoSuchSchoolException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(schoolId);
	}

	public static com.codeengine.service.model.School updateImpl(
		com.codeengine.service.model.School school)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(school);
	}

	/**
	* Returns the school with the primary key or throws a {@link com.codeengine.service.NoSuchSchoolException} if it could not be found.
	*
	* @param schoolId the primary key of the school
	* @return the school
	* @throws com.codeengine.service.NoSuchSchoolException if a school with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.codeengine.service.model.School findByPrimaryKey(
		long schoolId)
		throws com.codeengine.service.NoSuchSchoolException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(schoolId);
	}

	/**
	* Returns the school with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param schoolId the primary key of the school
	* @return the school, or <code>null</code> if a school with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.codeengine.service.model.School fetchByPrimaryKey(
		long schoolId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(schoolId);
	}

	/**
	* Returns all the schools.
	*
	* @return the schools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.codeengine.service.model.School> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the schools.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.service.model.impl.SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schools
	* @param end the upper bound of the range of schools (not inclusive)
	* @return the range of schools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.codeengine.service.model.School> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the schools.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.service.model.impl.SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schools
	* @param end the upper bound of the range of schools (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of schools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.codeengine.service.model.School> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the schools from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of schools.
	*
	* @return the number of schools
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SchoolPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SchoolPersistence)PortletBeanLocatorUtil.locate(com.codeengine.service.service.ClpSerializer.getServletContextName(),
					SchoolPersistence.class.getName());

			ReferenceRegistry.registerReference(SchoolUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SchoolPersistence persistence) {
	}

	private static SchoolPersistence _persistence;
}