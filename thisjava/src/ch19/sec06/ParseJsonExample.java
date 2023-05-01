package ch19.sec06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import org.json.JSONObject;

public class ParseJsonExample {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(
				new FileReader("member.json",Charset.forName("UTF-8"))
				);
		String json=br.readLine();
		br.close();
		
		JSONObject root=new JSONObject(json);
		
		System.out.println("id: "+root.getString("id"));
		System.out.println("name: "+root.getString("name"));
		System.out.println("age: "+root.getInt("age"));
		System.out.println("student: "+root.getBoolean("student"));
	}
}
