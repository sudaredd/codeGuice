package service;

import java.util.concurrent.atomic.AtomicInteger;

public class TeluguSpellChekerImpl implements SpellChecker{
	static AtomicInteger atomicInteger =new AtomicInteger();
	public TeluguSpellChekerImpl(String checkStyle) {
		System.out.println("in constructor TeluguSpellChekerImpl:"+atomicInteger.incrementAndGet());
	}
	@Override
	public void checkSpelling() {
		System.out.println("spell check in native language");
		
	}

}
