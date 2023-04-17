package ch09.sec06;

public class Button {
	String label;
	public Button(String label) {
		this.label = label;
	}
	
	private ClickListener listener;
	
	public void setListener(ClickListener listener) {
		this.listener = listener;
	}
	public static interface ClickListener{
		void onClick();
	}
	
	public void action() {
		listener.onClick();
	}
}
