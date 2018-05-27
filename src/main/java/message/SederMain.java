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

public class SederMain {
	private static final Logger LOGGER = LoggerFactory.getLogger(SederMain.class);

	public static void main(String[] args) throws Exception {
		
		Runnable r = ()->{
			try {
				startBroker();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		LOGGER.info("before create injector");

		new Thread(r).start();
		Injector injector = Guice.createInjector(new MessageModule());
		LOGGER.info("created injector");
		Sender sender = injector.getInstance(Sender.class);
		sender.sendMsg("hello1232");
	}

	private static void startBroker() throws URISyntaxException, Exception {
		BrokerService broker = new BrokerService();
		TransportConnector connector = new TransportConnector();
		connector.setUri(new URI("tcp://localhost:61616"));
		broker.addConnector(connector);
		broker.start();
	}

}
