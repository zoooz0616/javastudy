package ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;



public class ReadExample {
	public static void main(String[] args) {
		try(InputStream is=new FileInputStream("test.txt")){
			byte[] data = new byte[100];
			while (true) {
				int num = is.read(data);
				if (num == -1) {
					break;
				}

				System.out.println(new String(data,0,num));

				
			}
		}catch (IOException e) {
			// TODO: handle exception
		}
	}
}
