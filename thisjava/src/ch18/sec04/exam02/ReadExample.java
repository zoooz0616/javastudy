package ch18.sec04.exam02;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class ReadExample {
	public static void main(String[] args) {
		try{
			Reader reader = new FileReader("test.txt");
			while(true) {
				int data=reader.read();
				if (data == -1) {
					break;
				}
				System.out.print((char)data);
			}
			reader.close();
			System.out.println("읽기 완!");
			
			
			reader = new FileReader("test.txt");
			char[] data = new char[100];
			while (true) {
				int count = reader.read(data);
				if(count == -1) break;
				System.out.println(new String(data,0,count));
			}
			reader.close();
		}catch (IOException e) {
			// TODO: handle exception
		}
	}
}
