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

import com.codeengine.service.model.Clazz;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Clazz in entity cache.
 *
 * @author ces
 * @see Clazz
 * @generated
 */
public class ClazzCacheModel implements CacheModel<Clazz>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", clazzId=");
		sb.append(clazzId);
		sb.append(", clazzName=");
		sb.append(clazzName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Clazz toEntityModel() {
		ClazzImpl clazzImpl = new ClazzImpl();

		if (uuid == null) {
			clazzImpl.setUuid(StringPool.BLANK);
		}
		else {
			clazzImpl.setUuid(uuid);
		}

		clazzImpl.setClazzId(clazzId);

		if (clazzName == null) {
			clazzImpl.setClazzName(StringPool.BLANK);
		}
		else {
			clazzImpl.setClazzName(clazzName);
		}

		clazzImpl.resetOriginalValues();

		return clazzImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		clazzId = objectInput.readLong();
		clazzName = objectInput.readUTF();
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

		objectOutput.writeLong(clazzId);

		if (clazzName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(clazzName);
		}
	}

	public String uuid;
	public long clazzId;
	public String clazzName;
}