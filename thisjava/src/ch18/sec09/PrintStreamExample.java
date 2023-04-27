package ch18.sec09;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExample {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos=new FileOutputStream("printstream.txt");
		PrintStream printStream = new PrintStream(fos);
		
		printStream.print("마치");
		printStream.println("프린터가 출력하는 것처럼");
		printStream.println("데이터를 출력합니다.");
		printStream.printf("| %6d | %-10s | %10s | \n",1,"홍길동","도적");
		printStream.printf("| %6d | %-10s | %10s | \n",2,"감자바","학생");
	}
}
