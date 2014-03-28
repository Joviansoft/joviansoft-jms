package com.joviansoft.jms.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.joviansoft.jms.domain.Bjlxdm;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class BjlxdmMapperTest {

	@Autowired
	private BjlxdmMapper mapper;
	@Test
	public void testBjlx() {
		String strBjlxdm = "100100";
		
		Bjlxdm bjlxdm = mapper.getBjlxdmByDm(strBjlxdm);   
		
		System.out.println(bjlxdm.getBjlxmc());
		assertEquals(strBjlxdm, bjlxdm.getBjlxdm());
		
	}

}
