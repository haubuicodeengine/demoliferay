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

package com.codeengine.service.service.impl;

import com.codeengine.service.model.Clazz;
import com.codeengine.service.service.base.ClazzLocalServiceBaseImpl;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the clazz local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.codeengine.service.service.ClazzLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ces
 * @see com.codeengine.service.service.base.ClazzLocalServiceBaseImpl
 * @see com.codeengine.service.service.ClazzLocalServiceUtil
 */
public class ClazzLocalServiceImpl extends ClazzLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.codeengine.service.service.ClazzLocalServiceUtil} to access the clazz local service.
	 */
	public Clazz addNewClass(String name,
			ServiceContext serviceContext) throws SystemException,
			PortalException, NoSuchUserException {
		return null;
	}
	
}