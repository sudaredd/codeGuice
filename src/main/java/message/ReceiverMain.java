package message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

import message.module.MessageModule;

public class ReceiverMain {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverMain.class);

	public static void main(String[] args) throws Exception {

		StartBroker.startBrokerAsync();
		LOGGER.info("before create injector");
		Injector injector = Guice.createInjector(new MessageModule());
		LOGGER.info("created receiver injector");
		injector.getInstance(Listener.class);
	}
}
