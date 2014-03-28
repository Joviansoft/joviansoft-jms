package com.joviansoft.jms.service;

public interface IPush2TopicService {
	/**
	 * 启动向主题推送数据 
	 */
	void push2Topic();
	/**
	 * 停止向主题推送数据 
	 */
	void stopPush();
	
	void pausePush();
}
