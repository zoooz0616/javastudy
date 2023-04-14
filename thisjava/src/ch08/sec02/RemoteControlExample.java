package ch08.sec02;

public class RemoteControlExample {

	public static void main(String[] args) {
		RemoteControl rControl;
		rControl = new Television();
		rControl.turnOn();
		
		rControl=new Audio();
		rControl.turnOn();
	}

}
