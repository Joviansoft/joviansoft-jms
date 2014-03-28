package com.joviansoft.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joviansoft.jms.service.IPush2TopicService;

public class JovianJMS {

	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");

		// 推送案件数据 
		push110Case();
		//推送GPS数据 
		pushCarGps();
		
		while(true){
			try {
				Thread.sleep(100);
				char key = (char) System.in.read();
				switch(key){
				case 'q':
					IPush2TopicService service = (IPush2TopicService) ctx
					.getBean("case110PushService");
					service.stopPush();
					System.out.println(key); 
					System.exit(0);
					break;
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void push110Case() {

		IPush2TopicService service = (IPush2TopicService) ctx
				.getBean("case110PushService");
		service.push2Topic();
	}
	private static void pushCarGps(){
		try{
			IPush2TopicService service = (IPush2TopicService) ctx.getBean("carGpsPushService");
			service.push2Topic();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
}
