package com.rodrigofujioka;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.rodrigofujioka.entity.Paciente;

public class JavaProducer  {

	public void run(Paciente paciente) throws JMSException {
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			
			Connection connection = factory.createConnection();
			connection.start();

	        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        
	        Destination queue = session.createQueue("com.vinicius");
	        
	        MessageProducer producer = session.createProducer(queue);
	        
	        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        

	        ObjectMessage objectMessage = session.createObjectMessage(paciente);
	        
	        producer.send(objectMessage);
			
			connection.close();
	}

}
