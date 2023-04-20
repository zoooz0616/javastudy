package ch12.sec04;

import java.io.IOException;

public class InputExample {
	public static void main(String[] args) throws IOException {
//		int key=System.in.read();
//		System.out.println(key);
		
		byte[] buffer = new byte[100];
		int readCount= System.in.read(buffer);
		String lineString = new String(buffer,0,readCount);
		System.out.println("읽은 바이트 수 :"+ readCount);
		System.out.println("읽은 데이터: "+lineString);
		
		
		
		
	}
}
