package ch08.sec02;

public interface RemoteControl {
	int DEFAULT = 10; //italic체.bold =>public static final.자동 생성.	
	
	void turnOn(); //public abstract
}

class A {
	int hello;
	static int hello2=10;
	static final int hello3 = 20;
}