package com.joviansoft.jms;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.joviansoft.frame.dao.IJdbcDao;
import com.joviansoft.frame.query.util.IResultSetListMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class CarTraceManagerTest {
	
	
//	@Autowired
//	private IJdbcDao jdbcDao;
//	
	@Test
	public void testJdbc(){
//		IResultSetListMap list = jdbcDao.getAllList("select * from xt_yh");
//		System.out.println("XXXXXXXXXXXXXXXXXX****************" + list.size());
//	//	assertEquals(list.size()>0, true);
	}
	@Test 
	public void testJson(){
		Map<String,String> map = new HashMap<String, String>();
		map.put("id", "123");
		map.put("xm", "test");
		JSONObject json = JSONObject.fromObject(map);
		System.out.println(json.toString());
	}
}
