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

package com.codeengine.studentmanagement.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.codeengine.studentmanagement.service.http.ClazzServiceSoap}.
 *
 * @author ces
 * @see com.codeengine.studentmanagement.service.http.ClazzServiceSoap
 * @generated
 */
public class ClazzSoap implements Serializable {
	public static ClazzSoap toSoapModel(Clazz model) {
		ClazzSoap soapModel = new ClazzSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setClazzId(model.getClazzId());
		soapModel.setClazzName(model.getClazzName());

		return soapModel;
	}

	public static ClazzSoap[] toSoapModels(Clazz[] models) {
		ClazzSoap[] soapModels = new ClazzSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClazzSoap[][] toSoapModels(Clazz[][] models) {
		ClazzSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClazzSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClazzSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClazzSoap[] toSoapModels(List<Clazz> models) {
		List<ClazzSoap> soapModels = new ArrayList<ClazzSoap>(models.size());

		for (Clazz model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClazzSoap[soapModels.size()]);
	}

	public ClazzSoap() {
	}

	public long getPrimaryKey() {
		return _clazzId;
	}

	public void setPrimaryKey(long pk) {
		setClazzId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getClazzId() {
		return _clazzId;
	}

	public void setClazzId(long clazzId) {
		_clazzId = clazzId;
	}

	public String getClazzName() {
		return _clazzName;
	}

	public void setClazzName(String clazzName) {
		_clazzName = clazzName;
	}

	private String _uuid;
	private long _clazzId;
	private String _clazzName;
}