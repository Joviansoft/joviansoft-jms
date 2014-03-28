package com.joviansoft.jms;

import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ProducerServiceTest {

	@Autowired
	private ProducerService service;

	@Autowired
	@Qualifier("queueDestination")
	private Destination destination;

	@Test
	public void testSend() {
		service.sendMessage(destination, "hihihihihi");
	}
}
