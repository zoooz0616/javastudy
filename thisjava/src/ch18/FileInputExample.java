package ch18;

import java.io.FileInputStream;
import java.io.IOException;


public class FileInputExample {
	public static void main(String[] args) {
		try(FileInputStream fis =new FileInputStream("test.txt")){
//			int data = fis.read();
			byte[] buffer = new byte[100];//한 번에 최대 10바이트 읽음
			int readCount=0;
			while (true) {
				readCount = fis.read(buffer);
				if (readCount<=0) {
					break;
				}
				System.out.println(new String(buffer,0,readCount));
			}
//			System.out.println(readCount);
//			System.out.println(new String(buffer,0,readCount));
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
