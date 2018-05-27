package message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

public class Listener implements MessageListener {
	private static final Logger logger = LoggerFactory.getLogger(Listener.class);

	@Inject
	private MessageConsumer messageConsumer;

	@Inject
	public void init() throws JMSException {
		logger.info("setting listener");
		messageConsumer.setMessageListener(this);
	}
	
	@Override
	public void onMessage(Message message) {

		TextMessage textMessage = (TextMessage) message;
		try {
			logger.info("message received:" + textMessage.getText());
		} catch (JMSException e) {
			logger.error("Error occured while reading msg:" + e.getMessage());
		}

	}

}
