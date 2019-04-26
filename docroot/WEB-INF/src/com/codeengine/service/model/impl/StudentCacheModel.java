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

package com.codeengine.service.model.impl;

import com.codeengine.service.model.Student;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Student in entity cache.
 *
 * @author ces
 * @see Student
 * @generated
 */
public class StudentCacheModel implements CacheModel<Student>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", email=");
		sb.append(email);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", schoolId=");
		sb.append(schoolId);
		sb.append(", clazzId=");
		sb.append(clazzId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Student toEntityModel() {
		StudentImpl studentImpl = new StudentImpl();

		if (uuid == null) {
			studentImpl.setUuid(StringPool.BLANK);
		}
		else {
			studentImpl.setUuid(uuid);
		}

		studentImpl.setUserId(userId);

		if (name == null) {
			studentImpl.setName(StringPool.BLANK);
		}
		else {
			studentImpl.setName(name);
		}

		if (email == null) {
			studentImpl.setEmail(StringPool.BLANK);
		}
		else {
			studentImpl.setEmail(email);
		}

		if (createDate == Long.MIN_VALUE) {
			studentImpl.setCreateDate(null);
		}
		else {
			studentImpl.setCreateDate(new Date(createDate));
		}

		studentImpl.setSchoolId(schoolId);
		studentImpl.setClazzId(clazzId);

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		userId = objectInput.readLong();
		name = objectInput.readUTF();
		email = objectInput.readUTF();
		createDate = objectInput.readLong();
		schoolId = objectInput.readLong();
		clazzId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(userId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(schoolId);
		objectOutput.writeLong(clazzId);
	}

	public String uuid;
	public long userId;
	public String name;
	public String email;
	public long createDate;
	public long schoolId;
	public long clazzId;
}