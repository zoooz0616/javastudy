package ch18.sec02.exam03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
	public static void main(String[] args) {
		try {
			OutputStream os=new FileOutputStream("test3.txt");
			byte[] array= {'A','B','C','D','E'};
			os.write(array,1,4);
			os.flush();
			os.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
