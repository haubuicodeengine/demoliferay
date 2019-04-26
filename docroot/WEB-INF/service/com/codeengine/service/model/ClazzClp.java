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

import com.codeengine.service.service.ClazzLocalServiceUtil;
import com.codeengine.service.service.ClpSerializer;

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
public class ClazzClp extends BaseModelImpl<Clazz> implements Clazz {
	public ClazzClp() {
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
	public long getPrimaryKey() {
		return _clazzId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setClazzId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _clazzId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_clazzRemoteModel != null) {
			try {
				Class<?> clazz = _clazzRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_clazzRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClazzId() {
		return _clazzId;
	}

	@Override
	public void setClazzId(long clazzId) {
		_clazzId = clazzId;

		if (_clazzRemoteModel != null) {
			try {
				Class<?> clazz = _clazzRemoteModel.getClass();

				Method method = clazz.getMethod("setClazzId", long.class);

				method.invoke(_clazzRemoteModel, clazzId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClazzName() {
		return _clazzName;
	}

	@Override
	public void setClazzName(String clazzName) {
		_clazzName = clazzName;

		if (_clazzRemoteModel != null) {
			try {
				Class<?> clazz = _clazzRemoteModel.getClass();

				Method method = clazz.getMethod("setClazzName", String.class);

				method.invoke(_clazzRemoteModel, clazzName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getClazzRemoteModel() {
		return _clazzRemoteModel;
	}

	public void setClazzRemoteModel(BaseModel<?> clazzRemoteModel) {
		_clazzRemoteModel = clazzRemoteModel;
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

		Class<?> remoteModelClass = _clazzRemoteModel.getClass();

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

		Object returnValue = method.invoke(_clazzRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ClazzLocalServiceUtil.addClazz(this);
		}
		else {
			ClazzLocalServiceUtil.updateClazz(this);
		}
	}

	@Override
	public Clazz toEscapedModel() {
		return (Clazz)ProxyUtil.newProxyInstance(Clazz.class.getClassLoader(),
			new Class[] { Clazz.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ClazzClp clone = new ClazzClp();

		clone.setUuid(getUuid());
		clone.setClazzId(getClazzId());
		clone.setClazzName(getClazzName());

		return clone;
	}

	@Override
	public int compareTo(Clazz clazz) {
		long primaryKey = clazz.getPrimaryKey();

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

		if (!(obj instanceof ClazzClp)) {
			return false;
		}

		ClazzClp clazz = (ClazzClp)obj;

		long primaryKey = clazz.getPrimaryKey();

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
		sb.append(", clazzId=");
		sb.append(getClazzId());
		sb.append(", clazzName=");
		sb.append(getClazzName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.codeengine.service.model.Clazz");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clazzId</column-name><column-value><![CDATA[");
		sb.append(getClazzId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clazzName</column-name><column-value><![CDATA[");
		sb.append(getClazzName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _clazzId;
	private String _clazzName;
	private BaseModel<?> _clazzRemoteModel;
	private Class<?> _clpSerializerClass = com.codeengine.service.service.ClpSerializer.class;
}