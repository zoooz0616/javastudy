<<<<<<< HEAD
package ch11.sec05;

public class ThrowsExample1 {
	public static void main(String[] args) {
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			System.out.println("에외 처리: "+e.toString());
		}
	}
	
	public static void findClass() throws ClassNotFoundException{
		Class.forName("java.lang.String2");
	}
}
=======
package ch11.sec05;

public class ThrowsExample1 {
	public static void main(String[] args) {
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			System.out.println("에외 처리: "+e.toString());
		}
	}
	
	public static void findClass() throws ClassNotFoundException{
		Class.forName("java.lang.String2");
	}
}
>>>>>>> branch 'main' of https://github.com/zoooz0616/javastudy.git
