package ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExample {
	public static void main(String[] args) {
			//데이터를 저장하려면...
			//1.node정하기=>file
			//2.입출력단위 =>byte
			//3.FileOutputStream 클래스 필요
		//리소스 자동 close()해주도록 try()안에 넣음 
		//아니면 먼저 null로 해주고 try안에서 코딩 또 해야됨
//		try(FileOutputStream fos = new FileOutputStream("test.txt")){
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream("test.txt");
//			byte[] data = {'A','B','C','D','E'};
			byte[] data="abcdefghijklmn".getBytes();
//			fos.write('A');
//			fos.write('B');
//			
//			for (int i=65;i<75;i++){
//				fos.write(i);
//			}
			
			fos.write(data,1,3);
			fos.flush();
			System.out.println("파일에 데이터 기록됨");
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try{fos.close();}catch (Exception e) {}
		}
		
		
	}
}
