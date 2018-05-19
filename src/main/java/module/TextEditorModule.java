package module;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

import service.SpellChecker;
import service.SpellCheckerServiceImpl;

public class TextEditorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(SpellChecker.class).
		annotatedWith(Names.named("SpellCheck")).
		to(SpellCheckerServiceImpl.class).
		in(Scopes.SINGLETON);;
	}

}
