package ch09.sec06;

import ch09.sec06.Button.ClickListener;

public class ActionMain {
	public static void main(String[] args) {
		Button btn1=new Button("Red");
		Button.ClickListener listener = new Button.ClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("버튼을 클릭했습니다.");
			}
		};//익명클래스.익명 클래스 변수
		btn1.setListener(listener);
		btn1.setListener(new Button.ClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("버튼을 클릭했습니다.");
			}
		});//익명 클래스
		
		
		class ButtonClickListenr implements ClickListener{
			@Override
			public void onClick() {
				System.out.println("버튼을 클릭했습니다.");
				
			}
		}
		btn1.setListener(new ButtonClickListenr());	
		
		btn1.action();
	}
}
