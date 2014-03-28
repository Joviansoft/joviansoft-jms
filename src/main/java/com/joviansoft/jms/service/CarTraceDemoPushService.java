package com.joviansoft.jms.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.joviansoft.jms.dao.CarGpsMapper;
import com.joviansoft.jms.domain.CarGps;
import com.joviansoft.util.DateManager;
import com.joviansoft.util.JovianJsonUtil;
import com.joviansoft.util.JsonConvertException;

public class CarTraceDemoPushService extends BaseTopicPushService implements IPush2TopicService {

	List<CarGps> list = null;
	@Autowired
	private CarGpsMapper gpsMapper;
	
	@Override
	protected void push() {
			if(list == null){
				list = gpsMapper.findAll();
			}
					
			for (int i = 0; i < list.size(); i++) {
				long nextWaitingTime = 3000;

				try {
					CarGps gps1 = list.get(i);
					CarGps gps2 = list.get(i + 1);
					nextWaitingTime = DateManager.getTimePlusInMilliseconds(
							gps1.getGpstime(), gps2.getGpstime(),
							"yyyy-MM-dd HH:mm:ss")
							/ pushSpeed;
				} catch (ParseException e2) {
					e2.printStackTrace();
					System.out.println(e2.getStackTrace());
				}catch(Exception ex3){ //有可能捕捉到数组越界 
					
				}
				if(nextWaitingTime<10)
				{
					nextWaitingTime  = 10;
				}
				if(nextWaitingTime > 3000)
					nextWaitingTime = 3000;
				System.out.println("下一次警车轨迹信息推送将在 " + nextWaitingTime + "毫秒后");

				try {
					String strJson = JovianJsonUtil.convertBean2Json(list
							.get(i));
					service.sendMessage(destination, strJson);
				} catch (JsonConvertException e1) {
					e1.printStackTrace();
				} catch(Exception ex2){
					ex2.printStackTrace();
				}
				
				try {
					Thread.sleep(nextWaitingTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

		}
	}
}
