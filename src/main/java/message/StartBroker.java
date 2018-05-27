package message;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;

public class StartBroker {

	public static void startBrokerAsync() {
		new Thread(() -> startBroker()).start();
	}
	static final BrokerService BROKER = new BrokerService();

	private static void startBroker() {
		TransportConnector connector = new TransportConnector();
		try {
			connector.setUri(new URI("tcp://localhost:61616"));
			BROKER.addConnector(connector);
			BROKER.start();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void stop() {
		try {
			BROKER.stop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
