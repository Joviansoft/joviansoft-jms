package com.joviansoft.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import com.joviansoft.jms.domain1.Case;
import com.joviansoft.util.JovianJsonUtil;

import net.sf.json.JSONObject;

public class ConsumerMessageListener implements javax.jms.MessageListener{

	@Override
	public void onMessage(Message message) {
		  //这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换  
        TextMessage textMsg = (TextMessage) message;  
        try {
     		System.out.println("接收到一个消息。" + message.getJMSDestination().toString());
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
        try {  
            System.out.println("消息内容是：" + textMsg.getText());  
			// Case case110 =
			// (Case)JovianJsonUtil.convertJson2Bean(textMsg.getText(),
			// Case.class);
			//
			// System.out.println(case110.getJjdbh());
			//
            
            
        } catch (JMSException e) {  
            e.printStackTrace();  
        }  
	}

}
