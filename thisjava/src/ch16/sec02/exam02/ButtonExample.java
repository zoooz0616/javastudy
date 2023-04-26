package ch16.sec02.exam02;

public class ButtonExample {
	public static void main(String[] args) {
		Button button=new Button();
		
		button.setClickListener(()->{
			System.out.println("Ok버튼을 클릭했습니다.");
		});
		
		button.click();
		
		Button cancel=new Button();
		cancel.setClickListener(()->{
			System.out.println("cancel 버튼을 클릭했습니다.");
		});
		cancel.click();
	}
}
