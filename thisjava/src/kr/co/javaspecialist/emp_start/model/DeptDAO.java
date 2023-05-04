package kr.co.javaspecialist.emp_start.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeptDAO implements IDeptDAO {

	public DeptDAO() {
	}
	

	public ArrayList<DeptVO> getAllDepts() {
		ArrayList<DeptVO> deptList = new ArrayList<DeptVO>();
		String sql="select deptno, dname, loc from dept";
		
		Connection con=null;
		try {
			con=EmpDataSource.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				DeptVO dept=new DeptVO();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				
				deptList.add(dept);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			EmpDataSource.closeConnection(con);
		}
		
		return deptList;
	}
	
}
