package ch06.test.test15;

public class MemberService {
	String name;
	String id;
	String password;
	int age;
	
	MemberService() {
		// TODO Auto-generated constructor stub
	}
	
	
	MemberService(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	boolean login(String id, String password) {
		if (id =="hong" && password =="12345") {
			return true;
		} else {
			return false;
		}
	}
	
	void logout(String id) {
		System.out.println(id+"님이 로그아웃 되었습니다.");
	}
}
