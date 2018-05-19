package service;

import java.util.concurrent.atomic.AtomicInteger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

@Singleton
public class TextEditor {

	private SpellChecker spellChecker;
	
	static AtomicInteger counter = new AtomicInteger();

	@Inject
	public TextEditor( @Named(value="SpellCheck") SpellChecker spellChecker) {
		System.out.println("in construcotr:"+counter.getAndIncrement());
		this.spellChecker = spellChecker;
	}

	public void makeSpellCheck() {
		spellChecker.checkSpelling();
		
		spellChecker.checkSpelling();
	}

}
