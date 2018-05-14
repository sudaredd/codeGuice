package service;

public class SpellCheckerServiceImpl implements SpellChecker {

	public SpellCheckerServiceImpl() {
		System.out.println("in constructor SpellCheckerServiceImpl");
	}

	@Override
	public void checkSpelling() {
		System.out.println("Inside check spelling");
	}

}
