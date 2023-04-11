package ch06.sec15;

public class Singleton {
	private static Singleton singleton = new Singleton();
	
	private Singleton() {
		
	}
	
	public static Singleton getInSingleton() {
		return singleton;
	}

}
