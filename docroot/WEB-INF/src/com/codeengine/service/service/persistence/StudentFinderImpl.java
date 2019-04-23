package com.codeengine.service.service.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.ServiceMode;

import com.codeengine.service.model.Student;
import com.codeengine.service.model.impl.StudentImpl;
import com.codeengine.service.service.StudentLocalServiceUtil;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQL;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class StudentFinderImpl extends BasePersistenceImpl<Student> implements
		StudentFinder {

	/**
	 * Find by name
	 */

	public List<Student> findByName(String name, int begin, int end) {
		List<Student> result = new ArrayList<>();
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(_FIND_BY_NAME);
			// String sql =
			// "SELECT GB_Student.* FROM GB_Student WHERE GB_Student.name LIKE ?";
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("GB_Student", StudentImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add("%" + name + "%");
			result = (List<Student>) QueryUtil
					.list(q, getDialect(), begin, end);
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession(session);
		}
		return result;
	}

	/**
	 * Find by Name using DynamicQuery
	 */
	public List<Student> findByNameDynamicQuery(String name) throws Exception{
		List<Student> result = new ArrayList<>();
		Session session = null;
		try {
			session = openSession();
			DynamicQuery studentQuery = DynamicQueryFactoryUtil.forClass(Student.class)
					.add(RestrictionsFactoryUtil.like("name", "%" + name + "%"));
			result = StudentLocalServiceUtil.dynamicQuery(studentQuery);
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	private static final String _FIND_BY_NAME = StudentFinder.class.getName()
			+ ".findByName";
}
