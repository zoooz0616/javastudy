package ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
	public static void main(String[] args)throws Exception  {
		String originalFileName="test.txt";
		String targetFileName="text.txt";
		
		InputStream is=new FileInputStream(originalFileName);
		OutputStream os=new FileOutputStream(targetFileName);
		
		byte[] data = new byte[1024];
		while (true) {
			int count=is.read(data);
			if(count == -1) break;
			os.write(data,0,count);
			
		}
		os.flush();
		os.close();
		is.close();
		System.out.println("복사 끝!");
	}
}
