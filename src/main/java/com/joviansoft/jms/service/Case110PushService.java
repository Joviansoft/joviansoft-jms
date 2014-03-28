package com.joviansoft.jms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.joviansoft.jms.dao.BjlxdmMapper;
import com.joviansoft.jms.dao1.CaseMapper;
import com.joviansoft.jms.domain.Bjlxdm;
import com.joviansoft.jms.domain1.Case;
import com.joviansoft.util.JovianJsonUtil;
import com.joviansoft.util.JsonConvertException;

public class Case110PushService extends BaseTopicPushService implements
		IPush2TopicService {

	@Autowired
	private CaseMapper caseMapper;

	@Autowired
	private BjlxdmMapper bjlxdmMapper;

	@Override
	protected void push() {

		System.out.println("read 110 cases from database");

		List<Case> lstCase = caseMapper.findUpdatedCase();
		int size = lstCase.size();

		for (int i = 0; i < size; i++) {
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

		}
		// 更新标志位
		if (size > 0) {
			updateBz();
		}
	}

	private void updateBz() {
		try {
			caseMapper.updateCaseBZ();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
