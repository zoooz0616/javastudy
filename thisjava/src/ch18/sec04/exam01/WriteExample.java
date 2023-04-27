package ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {
	public static void main(String[] args) {
		try {
			Writer writer = new FileWriter("test.txt");
			writer.write('A');
			writer.write('B');
			
			char[] arr= {'C','D','E'};
			writer.write(arr);
			writer.write("FGH");
			writer.flush();
			System.out.println("파일 생성 완!");
			writer.close();
		}catch (IOException e) {
			// TODO: handle exception
		}
	}
}
