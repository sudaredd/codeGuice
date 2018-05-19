package module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

import service.SpellChecker;
import service.SpellCheckerServiceImpl;
import service.TeluguSpellChekerImpl;

public class TextEditorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(SpellChecker.class).
		annotatedWith(Names.named("SpellCheck")).
		to(SpellCheckerServiceImpl.class).
		in(Scopes.SINGLETON);;
	}
	
	@Provides
	private SpellChecker teluguSpellChecker() {
		return new TeluguSpellChekerImpl("Check in local language");
	}

}
