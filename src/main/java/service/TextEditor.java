package service;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class TextEditor {

	private SpellChecker spellChecker;

	@Inject
	public TextEditor(SpellChecker spellChecker) {
		super();
		this.spellChecker = spellChecker;
	}

	public void makeSpellCheck() {
		spellChecker.checkSpelling();
	}

}
