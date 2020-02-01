package com.rodrigofujioka;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.rodrigofujioka.entity.Paciente;

public class Consumer {
	
	public Paciente run() throws JMSException {

		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

		Connection connection = factory.createConnection();
		connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination queue = session.createQueue("com.vinicius");

        MessageConsumer consumer = session.createConsumer(queue);

        Message message = consumer.receive();
        Paciente paciente = null;
        if(message instanceof  ObjectMessage ) {
        	ObjectMessage objectMessage = (ObjectMessage) message;
        	paciente = (Paciente)objectMessage.getObject();
        }
        session.close();
        connection.close();
		
        return paciente;
	}

}
