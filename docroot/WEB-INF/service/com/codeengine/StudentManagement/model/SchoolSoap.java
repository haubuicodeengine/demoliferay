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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.codeengine.StudentManagement.service.http.SchoolServiceSoap}.
 *
 * @author ces
 * @see com.codeengine.StudentManagement.service.http.SchoolServiceSoap
 * @generated
 */
public class SchoolSoap implements Serializable {
	public static SchoolSoap toSoapModel(School model) {
		SchoolSoap soapModel = new SchoolSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSchoolId(model.getSchoolId());
		soapModel.setSchoolName(model.getSchoolName());

		return soapModel;
	}

	public static SchoolSoap[] toSoapModels(School[] models) {
		SchoolSoap[] soapModels = new SchoolSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SchoolSoap[][] toSoapModels(School[][] models) {
		SchoolSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SchoolSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SchoolSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SchoolSoap[] toSoapModels(List<School> models) {
		List<SchoolSoap> soapModels = new ArrayList<SchoolSoap>(models.size());

		for (School model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SchoolSoap[soapModels.size()]);
	}

	public SchoolSoap() {
	}

	public long getPrimaryKey() {
		return _schoolId;
	}

	public void setPrimaryKey(long pk) {
		setSchoolId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSchoolId() {
		return _schoolId;
	}

	public void setSchoolId(long schoolId) {
		_schoolId = schoolId;
	}

	public String getSchoolName() {
		return _schoolName;
	}

	public void setSchoolName(String schoolName) {
		_schoolName = schoolName;
	}

	private String _uuid;
	private long _schoolId;
	private String _schoolName;
}