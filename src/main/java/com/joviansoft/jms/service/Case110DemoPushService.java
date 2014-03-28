package com.joviansoft.jms.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joviansoft.jms.dao.BjlxdmMapper;
import com.joviansoft.jms.dao1.CaseMapper;
import com.joviansoft.jms.domain.Bjlxdm;
import com.joviansoft.jms.domain1.Case;
import com.joviansoft.util.DateManager;
import com.joviansoft.util.JovianJsonUtil;
import com.joviansoft.util.JsonConvertException;

@Service
public class Case110DemoPushService extends BaseTopicPushService {
	@Autowired
	private CaseMapper caseMapper;
	
	@Autowired
	private BjlxdmMapper bjlxdmMapper;
	/**
	 * 案件推送的核心处理.从案件表中查询出所有数据，逐条推送到案件主题 
	 */
	@Override
	protected void push(){
		List<Case> lstCase = caseMapper.findAll();
		for (int i = 0; i < lstCase.size(); i++) {
			
			if(this.flagStop)
				break;
			long nextWaitingTime = 5000;

			try {
				Case case1 = lstCase.get(i);
				Case case2 = lstCase.get(i + 1);
				nextWaitingTime = DateManager.getTimePlusInMilliseconds(
						case1.getBjsj(), case2.getBjsj(),
						"yyyy-MM-dd HH:mm:ss")
						/ pushSpeed;
			} catch (ParseException e2) {
				e2.printStackTrace();
				System.out.println(e2.getStackTrace());
			} catch (Exception e3){
				//e3.printStackTrace();
			}
			
			if(nextWaitingTime > 30000)
				nextWaitingTime = 30000;
			System.out.println("下一次案件推送将在 " + nextWaitingTime / 1000 + "秒后");

			try {
				Case case110 = lstCase.get(i);
				try {
					Bjlxdm bjlxdm = bjlxdmMapper.getBjlxdmByDm(case110
							.getBjlx().substring(11));

					if (bjlxdm != null) {
						case110.setBjlxmc(bjlxdm.getBjlxmc());
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				String strJson = JovianJsonUtil.convertBean2Json(case110);
				service.sendMessage(destination, strJson);
			} catch (JsonConvertException e1) {
				e1.printStackTrace();
			} 

			try {
				Thread.sleep(nextWaitingTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

//	private case110 doFilter(Case case110){
//		String bjrxm = case110.getBjrxm();
//		
//		bjrxm.replace()
//		
//		return null;
//	}
}
