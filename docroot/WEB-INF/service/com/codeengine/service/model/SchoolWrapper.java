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

package com.codeengine.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link School}.
 * </p>
 *
 * @author ces
 * @see School
 * @generated
 */
public class SchoolWrapper implements School, ModelWrapper<School> {
	public SchoolWrapper(School school) {
		_school = school;
	}

	@Override
	public Class<?> getModelClass() {
		return School.class;
	}

	@Override
	public String getModelClassName() {
		return School.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("schoolId", getSchoolId());
		attributes.put("schoolName", getSchoolName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long schoolId = (Long)attributes.get("schoolId");

		if (schoolId != null) {
			setSchoolId(schoolId);
		}

		String schoolName = (String)attributes.get("schoolName");

		if (schoolName != null) {
			setSchoolName(schoolName);
		}
	}

	/**
	* Returns the primary key of this school.
	*
	* @return the primary key of this school
	*/
	@Override
	public long getPrimaryKey() {
		return _school.getPrimaryKey();
	}

	/**
	* Sets the primary key of this school.
	*
	* @param primaryKey the primary key of this school
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_school.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this school.
	*
	* @return the uuid of this school
	*/
	@Override
	public java.lang.String getUuid() {
		return _school.getUuid();
	}

	/**
	* Sets the uuid of this school.
	*
	* @param uuid the uuid of this school
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_school.setUuid(uuid);
	}

	/**
	* Returns the school ID of this school.
	*
	* @return the school ID of this school
	*/
	@Override
	public long getSchoolId() {
		return _school.getSchoolId();
	}

	/**
	* Sets the school ID of this school.
	*
	* @param schoolId the school ID of this school
	*/
	@Override
	public void setSchoolId(long schoolId) {
		_school.setSchoolId(schoolId);
	}

	/**
	* Returns the school name of this school.
	*
	* @return the school name of this school
	*/
	@Override
	public java.lang.String getSchoolName() {
		return _school.getSchoolName();
	}

	/**
	* Sets the school name of this school.
	*
	* @param schoolName the school name of this school
	*/
	@Override
	public void setSchoolName(java.lang.String schoolName) {
		_school.setSchoolName(schoolName);
	}

	@Override
	public boolean isNew() {
		return _school.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_school.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _school.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_school.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _school.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _school.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_school.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _school.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_school.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_school.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_school.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SchoolWrapper((School)_school.clone());
	}

	@Override
	public int compareTo(com.codeengine.service.model.School school) {
		return _school.compareTo(school);
	}

	@Override
	public int hashCode() {
		return _school.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.codeengine.service.model.School> toCacheModel() {
		return _school.toCacheModel();
	}

	@Override
	public com.codeengine.service.model.School toEscapedModel() {
		return new SchoolWrapper(_school.toEscapedModel());
	}

	@Override
	public com.codeengine.service.model.School toUnescapedModel() {
		return new SchoolWrapper(_school.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _school.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _school.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_school.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SchoolWrapper)) {
			return false;
		}

		SchoolWrapper schoolWrapper = (SchoolWrapper)obj;

		if (Validator.equals(_school, schoolWrapper._school)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public School getWrappedSchool() {
		return _school;
	}

	@Override
	public School getWrappedModel() {
		return _school;
	}

	@Override
	public void resetOriginalValues() {
		_school.resetOriginalValues();
	}

	private School _school;
}