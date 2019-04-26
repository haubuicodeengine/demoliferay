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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Student}.
 * </p>
 *
 * @author ces
 * @see Student
 * @generated
 */
public class StudentWrapper implements Student, ModelWrapper<Student> {
	public StudentWrapper(Student student) {
		_student = student;
	}

	@Override
	public Class<?> getModelClass() {
		return Student.class;
	}

	@Override
	public String getModelClassName() {
		return Student.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("email", getEmail());
		attributes.put("createDate", getCreateDate());
		attributes.put("schoolId", getSchoolId());
		attributes.put("clazzId", getClazzId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long schoolId = (Long)attributes.get("schoolId");

		if (schoolId != null) {
			setSchoolId(schoolId);
		}

		Long clazzId = (Long)attributes.get("clazzId");

		if (clazzId != null) {
			setClazzId(clazzId);
		}
	}

	/**
	* Returns the primary key of this student.
	*
	* @return the primary key of this student
	*/
	@Override
	public long getPrimaryKey() {
		return _student.getPrimaryKey();
	}

	/**
	* Sets the primary key of this student.
	*
	* @param primaryKey the primary key of this student
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_student.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this student.
	*
	* @return the uuid of this student
	*/
	@Override
	public java.lang.String getUuid() {
		return _student.getUuid();
	}

	/**
	* Sets the uuid of this student.
	*
	* @param uuid the uuid of this student
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_student.setUuid(uuid);
	}

	/**
	* Returns the user ID of this student.
	*
	* @return the user ID of this student
	*/
	@Override
	public long getUserId() {
		return _student.getUserId();
	}

	/**
	* Sets the user ID of this student.
	*
	* @param userId the user ID of this student
	*/
	@Override
	public void setUserId(long userId) {
		_student.setUserId(userId);
	}

	/**
	* Returns the user uuid of this student.
	*
	* @return the user uuid of this student
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _student.getUserUuid();
	}

	/**
	* Sets the user uuid of this student.
	*
	* @param userUuid the user uuid of this student
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_student.setUserUuid(userUuid);
	}

	/**
	* Returns the name of this student.
	*
	* @return the name of this student
	*/
	@Override
	public java.lang.String getName() {
		return _student.getName();
	}

	/**
	* Sets the name of this student.
	*
	* @param name the name of this student
	*/
	@Override
	public void setName(java.lang.String name) {
		_student.setName(name);
	}

	/**
	* Returns the email of this student.
	*
	* @return the email of this student
	*/
	@Override
	public java.lang.String getEmail() {
		return _student.getEmail();
	}

	/**
	* Sets the email of this student.
	*
	* @param email the email of this student
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_student.setEmail(email);
	}

	/**
	* Returns the create date of this student.
	*
	* @return the create date of this student
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _student.getCreateDate();
	}

	/**
	* Sets the create date of this student.
	*
	* @param createDate the create date of this student
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_student.setCreateDate(createDate);
	}

	/**
	* Returns the school ID of this student.
	*
	* @return the school ID of this student
	*/
	@Override
	public long getSchoolId() {
		return _student.getSchoolId();
	}

	/**
	* Sets the school ID of this student.
	*
	* @param schoolId the school ID of this student
	*/
	@Override
	public void setSchoolId(long schoolId) {
		_student.setSchoolId(schoolId);
	}

	/**
	* Returns the clazz ID of this student.
	*
	* @return the clazz ID of this student
	*/
	@Override
	public long getClazzId() {
		return _student.getClazzId();
	}

	/**
	* Sets the clazz ID of this student.
	*
	* @param clazzId the clazz ID of this student
	*/
	@Override
	public void setClazzId(long clazzId) {
		_student.setClazzId(clazzId);
	}

	@Override
	public boolean isNew() {
		return _student.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_student.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _student.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_student.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _student.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _student.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_student.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _student.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_student.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_student.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_student.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StudentWrapper((Student)_student.clone());
	}

	@Override
	public int compareTo(com.codeengine.service.model.Student student) {
		return _student.compareTo(student);
	}

	@Override
	public int hashCode() {
		return _student.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.codeengine.service.model.Student> toCacheModel() {
		return _student.toCacheModel();
	}

	@Override
	public com.codeengine.service.model.Student toEscapedModel() {
		return new StudentWrapper(_student.toEscapedModel());
	}

	@Override
	public com.codeengine.service.model.Student toUnescapedModel() {
		return new StudentWrapper(_student.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _student.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _student.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_student.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentWrapper)) {
			return false;
		}

		StudentWrapper studentWrapper = (StudentWrapper)obj;

		if (Validator.equals(_student, studentWrapper._student)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Student getWrappedStudent() {
		return _student;
	}

	@Override
	public Student getWrappedModel() {
		return _student;
	}

	@Override
	public void resetOriginalValues() {
		_student.resetOriginalValues();
	}

	private Student _student;
}