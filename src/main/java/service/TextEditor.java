package service;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

@Singleton
public class TextEditor {

	private SpellChecker spellChecker;
	
	private SpellChecker teluguSpellChecker;
	
	static AtomicInteger counter = new AtomicInteger();

	private final Logger logger;

	@Inject
	public TextEditor( @Named(value="SpellCheck") SpellChecker spellChecker, SpellChecker teluguSpellChecker, Logger logger) {
		logger.info("in construcotr:"+counter.getAndIncrement());
		this.spellChecker = spellChecker;
		this.teluguSpellChecker=teluguSpellChecker;
		this.logger=logger;
	}

	public void makeSpellCheck() {
		spellChecker.checkSpelling();
		teluguSpellChecker.checkSpelling();
	}
}
