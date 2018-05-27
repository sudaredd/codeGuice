package message.module;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;

public class MessageModule extends AbstractModule {
	final static String MESSAGE_BROKER_URL = "tcp://:61616";
	String messageQueueName = "client.messages";
	int ackMode = Session.AUTO_ACKNOWLEDGE;

	@Provides
	private ConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory(MESSAGE_BROKER_URL);
	}

	@Provides
	private Connection connection(ActiveMQConnectionFactory connectionFactory) throws JMSException {
		Connection connection = connectionFactory.createConnection();
		connection.start();
		return connection;
	}
	
	

	@Provides
	private Session session(Connection connection) throws JMSException {
		return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	}
	
	@Provides
	private MessageProducer messageProducer(Session session) throws JMSException {
		Queue queue = session.createQueue(messageQueueName);
		return session.createProducer(queue);
	}
	
	@Provides
	private MessageConsumer messageConsumer(Session session) throws JMSException {
		Queue queue = session.createQueue(messageQueueName);
		return session.createConsumer(queue);
	}
}
