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

package com.codeengine.studentmanagement.service.persistence;

import com.codeengine.studentmanagement.model.Clazz;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the clazz service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ces
 * @see ClazzPersistenceImpl
 * @see ClazzUtil
 * @generated
 */
public interface ClazzPersistence extends BasePersistence<Clazz> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClazzUtil} to access the clazz persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the clazzs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching clazzs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.codeengine.studentmanagement.model.Clazz> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the clazzs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.studentmanagement.model.impl.ClazzModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of clazzs
	* @param end the upper bound of the range of clazzs (not inclusive)
	* @return the range of matching clazzs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.codeengine.studentmanagement.model.Clazz> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the clazzs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.studentmanagement.model.impl.ClazzModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of clazzs
	* @param end the upper bound of the range of clazzs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching clazzs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.codeengine.studentmanagement.model.Clazz> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first clazz in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching clazz
	* @throws com.codeengine.studentmanagement.NoSuchClazzException if a matching clazz could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.codeengine.studentmanagement.model.Clazz findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.codeengine.studentmanagement.NoSuchClazzException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first clazz in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching clazz, or <code>null</code> if a matching clazz could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.codeengine.studentmanagement.model.Clazz fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last clazz in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching clazz
	* @throws com.codeengine.studentmanagement.NoSuchClazzException if a matching clazz could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.codeengine.studentmanagement.model.Clazz findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.codeengine.studentmanagement.NoSuchClazzException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last clazz in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching clazz, or <code>null</code> if a matching clazz could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.codeengine.studentmanagement.model.Clazz fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the clazzs before and after the current clazz in the ordered set where uuid = &#63;.
	*
	* @param clazzId the primary key of the current clazz
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next clazz
	* @throws com.codeengine.studentmanagement.NoSuchClazzException if a clazz with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.codeengine.studentmanagement.model.Clazz[] findByUuid_PrevAndNext(
		long clazzId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.codeengine.studentmanagement.NoSuchClazzException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the clazzs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clazzs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching clazzs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the clazz in the entity cache if it is enabled.
	*
	* @param clazz the clazz
	*/
	public void cacheResult(com.codeengine.studentmanagement.model.Clazz clazz);

	/**
	* Caches the clazzs in the entity cache if it is enabled.
	*
	* @param clazzs the clazzs
	*/
	public void cacheResult(
		java.util.List<com.codeengine.studentmanagement.model.Clazz> clazzs);

	/**
	* Creates a new clazz with the primary key. Does not add the clazz to the database.
	*
	* @param clazzId the primary key for the new clazz
	* @return the new clazz
	*/
	public com.codeengine.studentmanagement.model.Clazz create(long clazzId);

	/**
	* Removes the clazz with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clazzId the primary key of the clazz
	* @return the clazz that was removed
	* @throws com.codeengine.studentmanagement.NoSuchClazzException if a clazz with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.codeengine.studentmanagement.model.Clazz remove(long clazzId)
		throws com.codeengine.studentmanagement.NoSuchClazzException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.codeengine.studentmanagement.model.Clazz updateImpl(
		com.codeengine.studentmanagement.model.Clazz clazz)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the clazz with the primary key or throws a {@link com.codeengine.studentmanagement.NoSuchClazzException} if it could not be found.
	*
	* @param clazzId the primary key of the clazz
	* @return the clazz
	* @throws com.codeengine.studentmanagement.NoSuchClazzException if a clazz with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.codeengine.studentmanagement.model.Clazz findByPrimaryKey(
		long clazzId)
		throws com.codeengine.studentmanagement.NoSuchClazzException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the clazz with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param clazzId the primary key of the clazz
	* @return the clazz, or <code>null</code> if a clazz with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.codeengine.studentmanagement.model.Clazz fetchByPrimaryKey(
		long clazzId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the clazzs.
	*
	* @return the clazzs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.codeengine.studentmanagement.model.Clazz> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the clazzs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.studentmanagement.model.impl.ClazzModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clazzs
	* @param end the upper bound of the range of clazzs (not inclusive)
	* @return the range of clazzs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.codeengine.studentmanagement.model.Clazz> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the clazzs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.studentmanagement.model.impl.ClazzModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clazzs
	* @param end the upper bound of the range of clazzs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of clazzs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.codeengine.studentmanagement.model.Clazz> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the clazzs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clazzs.
	*
	* @return the number of clazzs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}