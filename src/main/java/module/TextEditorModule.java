package module;

import com.google.inject.AbstractModule;

import service.SpellChecker;
import service.SpellCheckerServiceImpl;

public class TextEditorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(SpellChecker.class).to(SpellCheckerServiceImpl.class);
	}

}
