package com.joviansoft.jms.service;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;

import com.joviansoft.jms.ProducerService;

/**
 * 消息推送服务的基类 ，该类实现IPush2TopicService接口 ，此类本身也是一个线程类，实现 Runnable接口
 * @author bigbao
 *
 */
public abstract class BaseTopicPushService implements IPush2TopicService,Runnable{
	@Autowired
	protected ProducerService service; // 发送消息服务

	protected Destination destination; // 推送目的地，消息主题或者 Queue
	protected int pushSpeed = 1;  //demo 推送频率 
	protected Thread thread;
	
	protected boolean flagStop = false;
	
	public ProducerService getService() {
		return service;
	}
	public void setService(ProducerService service) {
		this.service = service;
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	public int getPushSpeed() {
		return pushSpeed;
	}
	public void setPushSpeed(int pushSpeed) {
		this.pushSpeed = pushSpeed;
	}
	/**
	 * 启动线程 ，开始向主题推送数据 
	 * @see com.joviansoft.jms.service.IPush2TopicService#push2Topic()
	 */
	@Override
	public void push2Topic() {
		thread = new Thread(this);
		thread.start();
	}
	/**
	 * 停止推送 
	 */
	@Override
	public void stopPush(){
		this.flagStop = true;
	}
	
	public void pausePush(){
		
	}
	@Override
	public void run() {
		while(!flagStop){
			
			try {
				push();
				System.out.println("数据推送完毕，将在15秒以后重新开始推送。 ");
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("退出推送....");
			
		
	}
	/**
	 * 具体业务的实现，交给不同的子类来处理 
	 */
	protected abstract void push();
}
