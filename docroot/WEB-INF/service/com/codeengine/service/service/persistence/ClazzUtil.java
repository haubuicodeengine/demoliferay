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

import com.codeengine.service.model.Clazz;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the clazz service. This utility wraps {@link ClazzPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ces
 * @see ClazzPersistence
 * @see ClazzPersistenceImpl
 * @generated
 */
public class ClazzUtil {
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
	public static void clearCache(Clazz clazz) {
		getPersistence().clearCache(clazz);
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
	public static List<Clazz> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Clazz> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Clazz> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Clazz update(Clazz clazz) throws SystemException {
		return getPersistence().update(clazz);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Clazz update(Clazz clazz, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(clazz, serviceContext);
	}

	/**
	* Returns all the clazzs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching clazzs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.codeengine.service.model.Clazz> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the clazzs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.service.model.impl.ClazzModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of clazzs
	* @param end the upper bound of the range of clazzs (not inclusive)
	* @return the range of matching clazzs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.codeengine.service.model.Clazz> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the clazzs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.service.model.impl.ClazzModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of clazzs
	* @param end the upper bound of the range of clazzs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching clazzs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.codeengine.service.model.Clazz> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first clazz in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching clazz
	* @throws com.codeengine.service.NoSuchClazzException if a matching clazz could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.codeengine.service.model.Clazz findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.codeengine.service.NoSuchClazzException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first clazz in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching clazz, or <code>null</code> if a matching clazz could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.codeengine.service.model.Clazz fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last clazz in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching clazz
	* @throws com.codeengine.service.NoSuchClazzException if a matching clazz could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.codeengine.service.model.Clazz findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.codeengine.service.NoSuchClazzException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last clazz in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching clazz, or <code>null</code> if a matching clazz could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.codeengine.service.model.Clazz fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the clazzs before and after the current clazz in the ordered set where uuid = &#63;.
	*
	* @param clazzId the primary key of the current clazz
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next clazz
	* @throws com.codeengine.service.NoSuchClazzException if a clazz with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.codeengine.service.model.Clazz[] findByUuid_PrevAndNext(
		long clazzId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.codeengine.service.NoSuchClazzException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(clazzId, uuid, orderByComparator);
	}

	/**
	* Removes all the clazzs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of clazzs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching clazzs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the clazz in the entity cache if it is enabled.
	*
	* @param clazz the clazz
	*/
	public static void cacheResult(com.codeengine.service.model.Clazz clazz) {
		getPersistence().cacheResult(clazz);
	}

	/**
	* Caches the clazzs in the entity cache if it is enabled.
	*
	* @param clazzs the clazzs
	*/
	public static void cacheResult(
		java.util.List<com.codeengine.service.model.Clazz> clazzs) {
		getPersistence().cacheResult(clazzs);
	}

	/**
	* Creates a new clazz with the primary key. Does not add the clazz to the database.
	*
	* @param clazzId the primary key for the new clazz
	* @return the new clazz
	*/
	public static com.codeengine.service.model.Clazz create(long clazzId) {
		return getPersistence().create(clazzId);
	}

	/**
	* Removes the clazz with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clazzId the primary key of the clazz
	* @return the clazz that was removed
	* @throws com.codeengine.service.NoSuchClazzException if a clazz with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.codeengine.service.model.Clazz remove(long clazzId)
		throws com.codeengine.service.NoSuchClazzException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(clazzId);
	}

	public static com.codeengine.service.model.Clazz updateImpl(
		com.codeengine.service.model.Clazz clazz)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(clazz);
	}

	/**
	* Returns the clazz with the primary key or throws a {@link com.codeengine.service.NoSuchClazzException} if it could not be found.
	*
	* @param clazzId the primary key of the clazz
	* @return the clazz
	* @throws com.codeengine.service.NoSuchClazzException if a clazz with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.codeengine.service.model.Clazz findByPrimaryKey(
		long clazzId)
		throws com.codeengine.service.NoSuchClazzException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(clazzId);
	}

	/**
	* Returns the clazz with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param clazzId the primary key of the clazz
	* @return the clazz, or <code>null</code> if a clazz with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.codeengine.service.model.Clazz fetchByPrimaryKey(
		long clazzId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(clazzId);
	}

	/**
	* Returns all the clazzs.
	*
	* @return the clazzs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.codeengine.service.model.Clazz> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the clazzs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.service.model.impl.ClazzModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clazzs
	* @param end the upper bound of the range of clazzs (not inclusive)
	* @return the range of clazzs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.codeengine.service.model.Clazz> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the clazzs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.service.model.impl.ClazzModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clazzs
	* @param end the upper bound of the range of clazzs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of clazzs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.codeengine.service.model.Clazz> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the clazzs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of clazzs.
	*
	* @return the number of clazzs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ClazzPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ClazzPersistence)PortletBeanLocatorUtil.locate(com.codeengine.service.service.ClpSerializer.getServletContextName(),
					ClazzPersistence.class.getName());

			ReferenceRegistry.registerReference(ClazzUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ClazzPersistence persistence) {
	}

	private static ClazzPersistence _persistence;
}