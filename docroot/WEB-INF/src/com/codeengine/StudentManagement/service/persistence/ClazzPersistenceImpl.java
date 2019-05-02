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

import com.codeengine.StudentManagement.NoSuchClazzException;
import com.codeengine.StudentManagement.model.Clazz;
import com.codeengine.StudentManagement.model.impl.ClazzImpl;
import com.codeengine.StudentManagement.model.impl.ClazzModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the clazz service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ces
 * @see ClazzPersistence
 * @see ClazzUtil
 * @generated
 */
public class ClazzPersistenceImpl extends BasePersistenceImpl<Clazz>
	implements ClazzPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ClazzUtil} to access the clazz persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ClazzImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ClazzModelImpl.ENTITY_CACHE_ENABLED,
			ClazzModelImpl.FINDER_CACHE_ENABLED, ClazzImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ClazzModelImpl.ENTITY_CACHE_ENABLED,
			ClazzModelImpl.FINDER_CACHE_ENABLED, ClazzImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ClazzModelImpl.ENTITY_CACHE_ENABLED,
			ClazzModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ClazzModelImpl.ENTITY_CACHE_ENABLED,
			ClazzModelImpl.FINDER_CACHE_ENABLED, ClazzImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ClazzModelImpl.ENTITY_CACHE_ENABLED,
			ClazzModelImpl.FINDER_CACHE_ENABLED, ClazzImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ClazzModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ClazzModelImpl.ENTITY_CACHE_ENABLED,
			ClazzModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the clazzs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching clazzs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Clazz> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clazzs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.StudentManagement.model.impl.ClazzModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of clazzs
	 * @param end the upper bound of the range of clazzs (not inclusive)
	 * @return the range of matching clazzs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Clazz> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the clazzs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.StudentManagement.model.impl.ClazzModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of clazzs
	 * @param end the upper bound of the range of clazzs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clazzs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Clazz> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Clazz> list = (List<Clazz>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Clazz clazz : list) {
				if (!Validator.equals(uuid, clazz.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CLAZZ_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ClazzModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Clazz>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Clazz>(list);
				}
				else {
					list = (List<Clazz>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first clazz in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clazz
	 * @throws com.codeengine.StudentManagement.NoSuchClazzException if a matching clazz could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Clazz findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchClazzException, SystemException {
		Clazz clazz = fetchByUuid_First(uuid, orderByComparator);

		if (clazz != null) {
			return clazz;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClazzException(msg.toString());
	}

	/**
	 * Returns the first clazz in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clazz, or <code>null</code> if a matching clazz could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Clazz fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Clazz> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last clazz in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clazz
	 * @throws com.codeengine.StudentManagement.NoSuchClazzException if a matching clazz could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Clazz findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchClazzException, SystemException {
		Clazz clazz = fetchByUuid_Last(uuid, orderByComparator);

		if (clazz != null) {
			return clazz;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClazzException(msg.toString());
	}

	/**
	 * Returns the last clazz in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clazz, or <code>null</code> if a matching clazz could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Clazz fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Clazz> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the clazzs before and after the current clazz in the ordered set where uuid = &#63;.
	 *
	 * @param clazzId the primary key of the current clazz
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clazz
	 * @throws com.codeengine.StudentManagement.NoSuchClazzException if a clazz with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Clazz[] findByUuid_PrevAndNext(long clazzId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchClazzException, SystemException {
		Clazz clazz = findByPrimaryKey(clazzId);

		Session session = null;

		try {
			session = openSession();

			Clazz[] array = new ClazzImpl[3];

			array[0] = getByUuid_PrevAndNext(session, clazz, uuid,
					orderByComparator, true);

			array[1] = clazz;

			array[2] = getByUuid_PrevAndNext(session, clazz, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Clazz getByUuid_PrevAndNext(Session session, Clazz clazz,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CLAZZ_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ClazzModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(clazz);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Clazz> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the clazzs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Clazz clazz : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(clazz);
		}
	}

	/**
	 * Returns the number of clazzs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching clazzs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CLAZZ_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "clazz.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "clazz.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(clazz.uuid IS NULL OR clazz.uuid = '')";

	public ClazzPersistenceImpl() {
		setModelClass(Clazz.class);
	}

	/**
	 * Caches the clazz in the entity cache if it is enabled.
	 *
	 * @param clazz the clazz
	 */
	@Override
	public void cacheResult(Clazz clazz) {
		EntityCacheUtil.putResult(ClazzModelImpl.ENTITY_CACHE_ENABLED,
			ClazzImpl.class, clazz.getPrimaryKey(), clazz);

		clazz.resetOriginalValues();
	}

	/**
	 * Caches the clazzs in the entity cache if it is enabled.
	 *
	 * @param clazzs the clazzs
	 */
	@Override
	public void cacheResult(List<Clazz> clazzs) {
		for (Clazz clazz : clazzs) {
			if (EntityCacheUtil.getResult(ClazzModelImpl.ENTITY_CACHE_ENABLED,
						ClazzImpl.class, clazz.getPrimaryKey()) == null) {
				cacheResult(clazz);
			}
			else {
				clazz.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all clazzs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ClazzImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ClazzImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the clazz.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Clazz clazz) {
		EntityCacheUtil.removeResult(ClazzModelImpl.ENTITY_CACHE_ENABLED,
			ClazzImpl.class, clazz.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Clazz> clazzs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Clazz clazz : clazzs) {
			EntityCacheUtil.removeResult(ClazzModelImpl.ENTITY_CACHE_ENABLED,
				ClazzImpl.class, clazz.getPrimaryKey());
		}
	}

	/**
	 * Creates a new clazz with the primary key. Does not add the clazz to the database.
	 *
	 * @param clazzId the primary key for the new clazz
	 * @return the new clazz
	 */
	@Override
	public Clazz create(long clazzId) {
		Clazz clazz = new ClazzImpl();

		clazz.setNew(true);
		clazz.setPrimaryKey(clazzId);

		String uuid = PortalUUIDUtil.generate();

		clazz.setUuid(uuid);

		return clazz;
	}

	/**
	 * Removes the clazz with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clazzId the primary key of the clazz
	 * @return the clazz that was removed
	 * @throws com.codeengine.StudentManagement.NoSuchClazzException if a clazz with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Clazz remove(long clazzId)
		throws NoSuchClazzException, SystemException {
		return remove((Serializable)clazzId);
	}

	/**
	 * Removes the clazz with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the clazz
	 * @return the clazz that was removed
	 * @throws com.codeengine.StudentManagement.NoSuchClazzException if a clazz with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Clazz remove(Serializable primaryKey)
		throws NoSuchClazzException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Clazz clazz = (Clazz)session.get(ClazzImpl.class, primaryKey);

			if (clazz == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClazzException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(clazz);
		}
		catch (NoSuchClazzException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Clazz removeImpl(Clazz clazz) throws SystemException {
		clazz = toUnwrappedModel(clazz);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(clazz)) {
				clazz = (Clazz)session.get(ClazzImpl.class,
						clazz.getPrimaryKeyObj());
			}

			if (clazz != null) {
				session.delete(clazz);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (clazz != null) {
			clearCache(clazz);
		}

		return clazz;
	}

	@Override
	public Clazz updateImpl(com.codeengine.StudentManagement.model.Clazz clazz)
		throws SystemException {
		clazz = toUnwrappedModel(clazz);

		boolean isNew = clazz.isNew();

		ClazzModelImpl clazzModelImpl = (ClazzModelImpl)clazz;

		if (Validator.isNull(clazz.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			clazz.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (clazz.isNew()) {
				session.save(clazz);

				clazz.setNew(false);
			}
			else {
				session.merge(clazz);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ClazzModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((clazzModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { clazzModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { clazzModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		EntityCacheUtil.putResult(ClazzModelImpl.ENTITY_CACHE_ENABLED,
			ClazzImpl.class, clazz.getPrimaryKey(), clazz);

		return clazz;
	}

	protected Clazz toUnwrappedModel(Clazz clazz) {
		if (clazz instanceof ClazzImpl) {
			return clazz;
		}

		ClazzImpl clazzImpl = new ClazzImpl();

		clazzImpl.setNew(clazz.isNew());
		clazzImpl.setPrimaryKey(clazz.getPrimaryKey());

		clazzImpl.setUuid(clazz.getUuid());
		clazzImpl.setClazzId(clazz.getClazzId());
		clazzImpl.setClazzName(clazz.getClazzName());

		return clazzImpl;
	}

	/**
	 * Returns the clazz with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the clazz
	 * @return the clazz
	 * @throws com.codeengine.StudentManagement.NoSuchClazzException if a clazz with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Clazz findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClazzException, SystemException {
		Clazz clazz = fetchByPrimaryKey(primaryKey);

		if (clazz == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClazzException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return clazz;
	}

	/**
	 * Returns the clazz with the primary key or throws a {@link com.codeengine.StudentManagement.NoSuchClazzException} if it could not be found.
	 *
	 * @param clazzId the primary key of the clazz
	 * @return the clazz
	 * @throws com.codeengine.StudentManagement.NoSuchClazzException if a clazz with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Clazz findByPrimaryKey(long clazzId)
		throws NoSuchClazzException, SystemException {
		return findByPrimaryKey((Serializable)clazzId);
	}

	/**
	 * Returns the clazz with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the clazz
	 * @return the clazz, or <code>null</code> if a clazz with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Clazz fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Clazz clazz = (Clazz)EntityCacheUtil.getResult(ClazzModelImpl.ENTITY_CACHE_ENABLED,
				ClazzImpl.class, primaryKey);

		if (clazz == _nullClazz) {
			return null;
		}

		if (clazz == null) {
			Session session = null;

			try {
				session = openSession();

				clazz = (Clazz)session.get(ClazzImpl.class, primaryKey);

				if (clazz != null) {
					cacheResult(clazz);
				}
				else {
					EntityCacheUtil.putResult(ClazzModelImpl.ENTITY_CACHE_ENABLED,
						ClazzImpl.class, primaryKey, _nullClazz);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ClazzModelImpl.ENTITY_CACHE_ENABLED,
					ClazzImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return clazz;
	}

	/**
	 * Returns the clazz with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clazzId the primary key of the clazz
	 * @return the clazz, or <code>null</code> if a clazz with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Clazz fetchByPrimaryKey(long clazzId) throws SystemException {
		return fetchByPrimaryKey((Serializable)clazzId);
	}

	/**
	 * Returns all the clazzs.
	 *
	 * @return the clazzs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Clazz> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clazzs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.StudentManagement.model.impl.ClazzModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of clazzs
	 * @param end the upper bound of the range of clazzs (not inclusive)
	 * @return the range of clazzs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Clazz> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the clazzs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.codeengine.StudentManagement.model.impl.ClazzModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of clazzs
	 * @param end the upper bound of the range of clazzs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clazzs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Clazz> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Clazz> list = (List<Clazz>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CLAZZ);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CLAZZ;

				if (pagination) {
					sql = sql.concat(ClazzModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Clazz>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Clazz>(list);
				}
				else {
					list = (List<Clazz>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the clazzs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Clazz clazz : findAll()) {
			remove(clazz);
		}
	}

	/**
	 * Returns the number of clazzs.
	 *
	 * @return the number of clazzs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CLAZZ);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the clazz persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.codeengine.StudentManagement.model.Clazz")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Clazz>> listenersList = new ArrayList<ModelListener<Clazz>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Clazz>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ClazzImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CLAZZ = "SELECT clazz FROM Clazz clazz";
	private static final String _SQL_SELECT_CLAZZ_WHERE = "SELECT clazz FROM Clazz clazz WHERE ";
	private static final String _SQL_COUNT_CLAZZ = "SELECT COUNT(clazz) FROM Clazz clazz";
	private static final String _SQL_COUNT_CLAZZ_WHERE = "SELECT COUNT(clazz) FROM Clazz clazz WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "clazz.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Clazz exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Clazz exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ClazzPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Clazz _nullClazz = new ClazzImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Clazz> toCacheModel() {
				return _nullClazzCacheModel;
			}
		};

	private static CacheModel<Clazz> _nullClazzCacheModel = new CacheModel<Clazz>() {
			@Override
			public Clazz toEntityModel() {
				return _nullClazz;
			}
		};
}