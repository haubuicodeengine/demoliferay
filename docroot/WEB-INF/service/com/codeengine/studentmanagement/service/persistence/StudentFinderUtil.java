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

package com.codeengine.studentmanagement.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author ces
 */
public class StudentFinderUtil {
	public static java.util.List<com.codeengine.studentmanagement.model.Student> findByName(
		java.lang.String name, int begin, int end) {
		return getFinder().findByName(name, begin, end);
	}

	public static java.util.List<com.codeengine.studentmanagement.model.Student> findByNameDynamicQuery(
		java.lang.String name) throws java.lang.Exception {
		return getFinder().findByNameDynamicQuery(name);
	}

	public static StudentFinder getFinder() {
		if (_finder == null) {
			_finder = (StudentFinder)PortletBeanLocatorUtil.locate(com.codeengine.studentmanagement.service.ClpSerializer.getServletContextName(),
					StudentFinder.class.getName());

			ReferenceRegistry.registerReference(StudentFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(StudentFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(StudentFinderUtil.class, "_finder");
	}

	private static StudentFinder _finder;
}