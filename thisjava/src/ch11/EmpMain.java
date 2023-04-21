<<<<<<< HEAD
package ch11;

import java.sql.SQLException;

public class EmpMain {
	public static void main(String[] args) {
		IEmpService empService = new EmpService();
		
		try{
			empService.insert(null);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
}
=======
package ch11;

import java.sql.SQLException;

public class EmpMain {
	public static void main(String[] args) {
		IEmpService empService = new EmpService();
		
		try{
			empService.insert(null);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
}
>>>>>>> branch 'main' of https://github.com/zoooz0616/javastudy.git
