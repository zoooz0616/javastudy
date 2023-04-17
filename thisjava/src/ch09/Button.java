package ch09;

public class Button {
	private String label;
	
	public Button(String label) {
		this.label = label;
	}
	
	public void click(final int data) {//data는 읽기 전용
		//click이 불리고 나서 callback을 실행하기 위해 data를 사용하기 때문에 heap에 final형태로 저장됨.
		class EventHandler{
			void callback() {
				System.out.println(label+"버튼 클릭됨.");
				System.out.println("전달된 값: "+data);
			}
		}
		new EventHandler().callback();
	}
}
