package service;

import com.google.inject.Guice;
import com.google.inject.Injector;

import module.TextEditorModule;

public class GuiceSpellhecckTester {

	public static void main(String[] args) {

		Injector injector = Guice.createInjector(new TextEditorModule());
		TextEditor editor = injector.getInstance(TextEditor.class);
		editor.makeSpellCheck();
		TextEditor editor2 = injector.getInstance(TextEditor.class);
		editor2.makeSpellCheck();
		
		injector.getInstance(RawEditor.class).makeSpellCheck();
	}

}
