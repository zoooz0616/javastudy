package ch19.sec06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;

import org.json.JSONObject;

public class CreateJsonExample {
	public static void main(String[] args) throws IOException{
		JSONObject root=new JSONObject();
		root.put("id","winter");
		root.put("name", "한겨울");
		root.put("age", 25);
		root.put("student", true);
		
		JSONObject tel= new JSONObject();
		tel.put("home","02-123-1234");
		tel.put("mobile", "010-5744-7339");
		root.put("tel", tel);
		
		String jsonString=root.toString();
		System.out.println(jsonString);
		
		Writer writer = new FileWriter("member.json", Charset.forName("UTF-8"));
		writer.write(jsonString);
		writer.flush();
		writer.close();
	}
}
