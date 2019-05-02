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

package com.codeengine.studentmanagement.model.impl;

import com.codeengine.studentmanagement.model.School;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing School in entity cache.
 *
 * @author ces
 * @see School
 * @generated
 */
public class SchoolCacheModel implements CacheModel<School>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", schoolId=");
		sb.append(schoolId);
		sb.append(", schoolName=");
		sb.append(schoolName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public School toEntityModel() {
		SchoolImpl schoolImpl = new SchoolImpl();

		if (uuid == null) {
			schoolImpl.setUuid(StringPool.BLANK);
		}
		else {
			schoolImpl.setUuid(uuid);
		}

		schoolImpl.setSchoolId(schoolId);

		if (schoolName == null) {
			schoolImpl.setSchoolName(StringPool.BLANK);
		}
		else {
			schoolImpl.setSchoolName(schoolName);
		}

		schoolImpl.resetOriginalValues();

		return schoolImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		schoolId = objectInput.readLong();
		schoolName = objectInput.readUTF();
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

		objectOutput.writeLong(schoolId);

		if (schoolName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(schoolName);
		}
	}

	public String uuid;
	public long schoolId;
	public String schoolName;
}