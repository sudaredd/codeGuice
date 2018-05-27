package message;

import java.net.URI;
import java.net.URISyntaxException;

import javax.jms.JMSException;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

import message.module.MessageModule;

public class ReceiverMain {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverMain.class);

	public static void main(String[] args) throws Exception {
		
		Runnable r = ()->{
			try {
				startBroker();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		new Thread(r).start();
		LOGGER.info("before create injector");
		Injector injector = Guice.createInjector(new MessageModule());
		LOGGER.info("created receiver injector");
		injector.getInstance(Listener.class);
	}

	private static void startBroker() throws URISyntaxException, Exception {
		BrokerService broker = new BrokerService();
		TransportConnector connector = new TransportConnector();
		connector.setUri(new URI("tcp://localhost:61616"));
		broker.addConnector(connector);
		broker.start();
	}

}
