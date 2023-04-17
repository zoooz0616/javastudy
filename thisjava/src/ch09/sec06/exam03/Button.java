package ch09.sec06.exam03;

public class Button {
	public static interface ClickListener{
		void onClick();
	}
	private ClickListener listener;
	
	public void setClickListener(ClickListener listener) {
		this.listener = listener;
	}
	
	public void click() {
		this.listener.onClick();
	}
}
