package service;

import java.util.concurrent.atomic.AtomicInteger;

public class SpellCheckerServiceImpl implements SpellChecker {

	static AtomicInteger atomicInteger =new AtomicInteger();
	public SpellCheckerServiceImpl() {
		System.out.println("in constructor SpellCheckerServiceImpl:"+atomicInteger.incrementAndGet());
	}

	@Override
	public void checkSpelling() {
		System.out.println("Inside check spelling");
	}

}
