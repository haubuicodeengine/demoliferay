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

package com.codeengine.StudentManagement.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Clazz}.
 * </p>
 *
 * @author ces
 * @see Clazz
 * @generated
 */
public class ClazzWrapper implements Clazz, ModelWrapper<Clazz> {
	public ClazzWrapper(Clazz clazz) {
		_clazz = clazz;
	}

	@Override
	public Class<?> getModelClass() {
		return Clazz.class;
	}

	@Override
	public String getModelClassName() {
		return Clazz.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("clazzId", getClazzId());
		attributes.put("clazzName", getClazzName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long clazzId = (Long)attributes.get("clazzId");

		if (clazzId != null) {
			setClazzId(clazzId);
		}

		String clazzName = (String)attributes.get("clazzName");

		if (clazzName != null) {
			setClazzName(clazzName);
		}
	}

	/**
	* Returns the primary key of this clazz.
	*
	* @return the primary key of this clazz
	*/
	@Override
	public long getPrimaryKey() {
		return _clazz.getPrimaryKey();
	}

	/**
	* Sets the primary key of this clazz.
	*
	* @param primaryKey the primary key of this clazz
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_clazz.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this clazz.
	*
	* @return the uuid of this clazz
	*/
	@Override
	public java.lang.String getUuid() {
		return _clazz.getUuid();
	}

	/**
	* Sets the uuid of this clazz.
	*
	* @param uuid the uuid of this clazz
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_clazz.setUuid(uuid);
	}

	/**
	* Returns the clazz ID of this clazz.
	*
	* @return the clazz ID of this clazz
	*/
	@Override
	public long getClazzId() {
		return _clazz.getClazzId();
	}

	/**
	* Sets the clazz ID of this clazz.
	*
	* @param clazzId the clazz ID of this clazz
	*/
	@Override
	public void setClazzId(long clazzId) {
		_clazz.setClazzId(clazzId);
	}

	/**
	* Returns the clazz name of this clazz.
	*
	* @return the clazz name of this clazz
	*/
	@Override
	public java.lang.String getClazzName() {
		return _clazz.getClazzName();
	}

	/**
	* Sets the clazz name of this clazz.
	*
	* @param clazzName the clazz name of this clazz
	*/
	@Override
	public void setClazzName(java.lang.String clazzName) {
		_clazz.setClazzName(clazzName);
	}

	@Override
	public boolean isNew() {
		return _clazz.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_clazz.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _clazz.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_clazz.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _clazz.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _clazz.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_clazz.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _clazz.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_clazz.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_clazz.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_clazz.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ClazzWrapper((Clazz)_clazz.clone());
	}

	@Override
	public int compareTo(com.codeengine.StudentManagement.model.Clazz clazz) {
		return _clazz.compareTo(clazz);
	}

	@Override
	public int hashCode() {
		return _clazz.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.codeengine.StudentManagement.model.Clazz> toCacheModel() {
		return _clazz.toCacheModel();
	}

	@Override
	public com.codeengine.StudentManagement.model.Clazz toEscapedModel() {
		return new ClazzWrapper(_clazz.toEscapedModel());
	}

	@Override
	public com.codeengine.StudentManagement.model.Clazz toUnescapedModel() {
		return new ClazzWrapper(_clazz.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _clazz.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _clazz.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_clazz.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClazzWrapper)) {
			return false;
		}

		ClazzWrapper clazzWrapper = (ClazzWrapper)obj;

		if (Validator.equals(_clazz, clazzWrapper._clazz)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Clazz getWrappedClazz() {
		return _clazz;
	}

	@Override
	public Clazz getWrappedModel() {
		return _clazz;
	}

	@Override
	public void resetOriginalValues() {
		_clazz.resetOriginalValues();
	}

	private Clazz _clazz;
}