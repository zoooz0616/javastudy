<<<<<<< HEAD
package ch11;

import java.sql.SQLException;

public class EmpService implements IEmpService{
	
	@Override
	public void insert(EmpVO vo){
		try{
			if (vo==null) {
		
			throw new SQLException("객체가 널입니다.");
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
=======
package ch11;

import java.sql.SQLException;

public class EmpService implements IEmpService{
	
	@Override
	public void insert(EmpVO vo){
		try{
			if (vo==null) {
		
			throw new SQLException("객체가 널입니다.");
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
>>>>>>> branch 'main' of https://github.com/zoooz0616/javastudy.git
