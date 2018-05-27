package message;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

public class Sender {

	@Inject
	private MessageProducer messageProducer;

	@Inject
	private Session session;

	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

	public void sendMsg(String msg) throws JMSException {
		// create a JMS TextMessage
		TextMessage textMessage = session.createTextMessage(msg);
		// send the message to the queue destination
		messageProducer.send(textMessage);
		LOGGER.info("message sent:" + msg);

	}
}
