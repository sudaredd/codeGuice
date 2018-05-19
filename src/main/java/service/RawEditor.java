package service;

import java.util.concurrent.atomic.AtomicInteger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

@Singleton
public class RawEditor {
private SpellChecker spellChecker;
	
	static AtomicInteger counter = new AtomicInteger();

	@Inject
	public RawEditor( @Named(value="SpellCheck") SpellChecker spellChecker) {
		System.out.println("in construcotr:"+counter.getAndIncrement());
		this.spellChecker = spellChecker;
	}

	public void makeSpellCheck() {
		System.out.println("call spell check from raw editor");
		spellChecker.checkSpelling();
	}
}
