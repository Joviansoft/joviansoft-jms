package com.joviansoft.jms;

import javax.jms.Destination;

public interface ProducerService {
	void sendMessage(Destination destination, String message);
	//void sendMessage()
}
