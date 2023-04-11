package ch06.test.test18;

public class ShopServiceExample {

	public static void main(String[] args) {
		ShopService s1 = ShopService.getInstance();
		ShopService s2 = ShopService.getInstance();
		
		if (s1==s2) {
			System.out.println("같은 객체입니다.");
		}else {
			System.out.println("다른 객체입니다.");
		}
	}

}
