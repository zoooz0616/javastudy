
package ch12.sec06;

import java.util.Date;
public class WrapperExample {

	public static void main(String[] args) {
		Object[] objArr= new Object[5];
		objArr[0] = "Hello";
		objArr[1] = new Date();
//		objArr[2] = 10; //주소 10을 넣어라.
		objArr[2] = new Integer(10);
	}

}