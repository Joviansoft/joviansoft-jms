package com.joviansoft.jms.dao1;

import java.util.List;

import com.joviansoft.jms.domain1.Case;
public interface CaseMapper {
	Case getCaseById(String casdId);
	List<Case> findAll();
	List<Case> findUpdatedCase();
	void updateCaseBZ();
//	void insertCase(Case case110);
 }
