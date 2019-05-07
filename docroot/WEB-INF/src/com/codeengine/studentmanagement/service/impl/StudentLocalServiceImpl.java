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

package com.codeengine.studentmanagement.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codeengine.studentmanagement.exception.StudentException;
import com.codeengine.studentmanagement.model.Student;
import com.codeengine.studentmanagement.model.impl.StudentImpl;
import com.codeengine.studentmanagement.service.base.StudentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the student local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.codeengine.studentmanagement.service.StudentLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author ces
 * @see com.codeengine.studentmanagement.service.base.StudentLocalServiceBaseImpl
 * @see com.codeengine.studentmanagement.service.StudentLocalServiceUtil
 */
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {
	

	
	/**
	 * Add or update student
	 * 
	 * @param studentId
	 * @param email
	 * @param name
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public Student addOrUpdateStudent(
			long companyId, long studentId, String name, String email)
		throws PortalException, SystemException {

		validateStudent(name, email);
		Student student = studentPersistence.fetchByPrimaryKey(studentId);
		if (Validator.isNull(student)) {
			student =
				studentPersistence.create(counterLocalService.increment());
		}
		student.setName(name);
		student.setEmail(email);
		student.setCompanyId(companyId);
		updateStudent(student);

		Indexer indexer =
			IndexerRegistryUtil.nullSafeGetIndexer(Student.class.getName());
		indexer.reindex(student);
		return student;
	}
	
	/**
	 * Build search context
	 * @param companyId
	 * @return
	 */
	private SearchContext buildSearchContext(long companyId) {
		if(SEARCH_CONTEXT == null){
			SEARCH_CONTEXT = new SearchContext();
			SEARCH_CONTEXT.setAndSearch(true);
			QueryConfig queryConfig = new QueryConfig();
			queryConfig.setHighlightEnabled(false);
			queryConfig.setScoreEnabled(false);
			SEARCH_CONTEXT.setQueryConfig(queryConfig);
		}
		SEARCH_CONTEXT.setCompanyId(companyId);
		return SEARCH_CONTEXT;
	}
	
	/**
	 * Delete student
	 */
	public void deleteStudentIndexer(long studentId)
		throws PortalException, SystemException {

		Student student = deleteStudent(studentId);
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Student.class);
		indexer.delete(student);
	}

	/**
	 * Find By Name
	 * 
	 * @throws Exception
	 */
	public List<Student> findByName(long companyId, String name)
		throws Exception {

		SearchContext searchContext = buildSearchContext(companyId);

		Map<String, Serializable> attributes =
			new HashMap<String, Serializable>();
		attributes.put("name", name);
		searchContext.setAttributes(attributes);

		return getStudentFromSearchContext(searchContext);
	}

	/**
	 * Get all students
	 * 
	 * @throws SystemException
	 */
	public List<Student> getAll()
		throws SystemException {

		return studentPersistence.findAll();
	}
	
	/**
	 * Get all student from search context
	 * @param searchContext
	 * @return
	 * @throws SearchException
	 */
	private List<Student> getStudentFromSearchContext(
			SearchContext searchContext)
		throws SearchException {

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Student.class);
		List<Document> docs = indexer.search(searchContext).toList();

		List<Student> result = new ArrayList<>();
		for (int i = 0; i < docs.size(); i++) {
			result.add(parseFromDocumentToStudent(docs.get(i)));
		}
		return result;
	}
	
	/**
	 * Parse from document to student
	 * @param doc
	 * @return
	 */
	private Student parseFromDocumentToStudent(Document doc) {

		Student student = new StudentImpl();
		student.setUserId(GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK)));
		student.setName(GetterUtil.getString(doc.get("name")));
		student.setEmail(GetterUtil.getString(doc.get("email")));
		return student;
	}
	
	/**
	 * Validate email and name
	 * 
	 * @param name
	 * @param email
	 * @throws PortalException
	 */
	private void validateStudent(String name, String email)
		throws PortalException {

		List<String> errors = new ArrayList<>();
		if (Validator.isNull(name)) {
			errors.add("please.enter.name");
		}
		if (name.length() > 10 || name.length() < 3) {
			errors.add("name.must.from.3.to.10.character");
		}
		if (Validator.isNull(email)) {
			errors.add("please.enter.email");
		}
		if (!Validator.isEmailAddress(email)) {
			errors.add("please.enter.correct.email.format");
		}
		if (errors.size() > 0) {
			throw new StudentException(errors);
		}

	}
	
	private static SearchContext SEARCH_CONTEXT = null;
}
