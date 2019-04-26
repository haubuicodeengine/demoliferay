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

import com.codeengine.service.service.ClpSerializer;
import com.codeengine.service.service.SchoolLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ces
 */
public class SchoolClp extends BaseModelImpl<School> implements School {
	public SchoolClp() {
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
	public long getPrimaryKey() {
		return _schoolId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSchoolId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _schoolId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_schoolRemoteModel != null) {
			try {
				Class<?> clazz = _schoolRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_schoolRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSchoolId() {
		return _schoolId;
	}

	@Override
	public void setSchoolId(long schoolId) {
		_schoolId = schoolId;

		if (_schoolRemoteModel != null) {
			try {
				Class<?> clazz = _schoolRemoteModel.getClass();

				Method method = clazz.getMethod("setSchoolId", long.class);

				method.invoke(_schoolRemoteModel, schoolId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSchoolName() {
		return _schoolName;
	}

	@Override
	public void setSchoolName(String schoolName) {
		_schoolName = schoolName;

		if (_schoolRemoteModel != null) {
			try {
				Class<?> clazz = _schoolRemoteModel.getClass();

				Method method = clazz.getMethod("setSchoolName", String.class);

				method.invoke(_schoolRemoteModel, schoolName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSchoolRemoteModel() {
		return _schoolRemoteModel;
	}

	public void setSchoolRemoteModel(BaseModel<?> schoolRemoteModel) {
		_schoolRemoteModel = schoolRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _schoolRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_schoolRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SchoolLocalServiceUtil.addSchool(this);
		}
		else {
			SchoolLocalServiceUtil.updateSchool(this);
		}
	}

	@Override
	public School toEscapedModel() {
		return (School)ProxyUtil.newProxyInstance(School.class.getClassLoader(),
			new Class[] { School.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SchoolClp clone = new SchoolClp();

		clone.setUuid(getUuid());
		clone.setSchoolId(getSchoolId());
		clone.setSchoolName(getSchoolName());

		return clone;
	}

	@Override
	public int compareTo(School school) {
		long primaryKey = school.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SchoolClp)) {
			return false;
		}

		SchoolClp school = (SchoolClp)obj;

		long primaryKey = school.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", schoolId=");
		sb.append(getSchoolId());
		sb.append(", schoolName=");
		sb.append(getSchoolName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.codeengine.service.model.School");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>schoolId</column-name><column-value><![CDATA[");
		sb.append(getSchoolId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>schoolName</column-name><column-value><![CDATA[");
		sb.append(getSchoolName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _schoolId;
	private String _schoolName;
	private BaseModel<?> _schoolRemoteModel;
	private Class<?> _clpSerializerClass = com.codeengine.service.service.ClpSerializer.class;
}