package ch08;

public class HelloPraxy extends Hello{
	
	@Override
	public void sayHello(String name) {
		HelloLog.log();
		super.sayHello(name);
	}
}
