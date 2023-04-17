package ch09.sec06.exam02;

public class Button {
	public static interface ClickListener {
		void onClick();
	}
	
	private ClickListener clicklistener;
	
	public void setClickListener(ClickListener clicklistener) {
		this.clicklistener = clicklistener;
	}
}
