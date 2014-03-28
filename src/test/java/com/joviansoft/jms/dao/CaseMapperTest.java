package com.joviansoft.jms.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.joviansoft.jms.dao1.CaseMapper;
import com.joviansoft.jms.domain1.Case;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class CaseMapperTest {

	@Autowired 
	private CaseMapper caseMapper;
	@Test
	public void test() {
//		Case case110 = new Case();
//		case110.setJjdbh("123");
//		
//		caseMapper.insertCase(case110);
//		
//		assertEquals(case110.getJjdbh(), caseMapper.getCaseById("123").getJjdbh());
	}

}
