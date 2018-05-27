package message;

import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

import message.module.MessageModule;

public class SederMain {
	private static final Logger LOGGER = LoggerFactory.getLogger(SederMain.class);

	public static void main(String[] args) throws Exception {

		StartBroker.startBrokerAsync();
		LOGGER.info("before create injector");
		Injector injector = Guice.createInjector(new MessageModule());
		LOGGER.info("created injector");
		Sender sender = injector.getInstance(Sender.class);
		IntStream.rangeClosed(1, 100).forEach(i -> sender.sendMsg("hello" + i));
		StartBroker.stop();
	}

}
