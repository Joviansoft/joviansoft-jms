package com.joviansoft.jms.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.joviansoft.jms.domain.CarGps;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})

public class CarGpsMapperTest {

	@Autowired 
	private CarGpsMapper gpsMapper;
	@Test
	public void testInsertGps() {
//		System.out.println("总记录"+gpsMapper.findAll().size());
//
//		CarGps gps = new CarGps();
//		gps.setHh("123");
//		gps.setCph("浙E12345");
//		gpsMapper.insertGps(gps);
//		
//		System.out.println("总记录"+gpsMapper.findAll().size());
		
	}

}
