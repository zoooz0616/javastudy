package ch19;

import lombok.ToString;
import lombok.Setter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;

public class GsonExample {
	public static void main(String[] args) {
		List<Member> memberList = new ArrayList<Member>();
		memberList.add(new Member("홍길동", 23, 3000.0, "gildong@hong.com"));
		memberList.add(new Member("홍길서", 20, 6000.0, "gil@hong.com"));
		memberList.add(new Member("홍길남", 21, 4000.0, "dong@hong.com"));
		
		Gson gson = new Gson();
		String json = gson.toJson(memberList);
		System.out.println(json);
		System.out.println(gson.toJson(memberList.get(0)));
		Map<String, String> map = new HashMap<String, String>();
		map.put("a","a1");
		map.put("b","b1");
		System.out.println(gson.toJson(map));
	}
}

@AllArgsConstructor
@Getter @Setter @ToString
class Member{
	private String name;
	private int age;
	private double salary;
	private String email;
	
	public String toJSON() {
		return "{ \"name\": " +name+ ", \"age\":"+age+"}";
	}
}
