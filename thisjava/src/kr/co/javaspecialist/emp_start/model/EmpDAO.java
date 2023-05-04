package kr.co.javaspecialist.emp_start.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

//import oracle.net.aso.c;

public class EmpDAO implements IEmpDAO {
	
	public int getEmpCount() {
		int rowCount = 0;
		String sql = "select count(*) from emp";
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			con = EmpDataSource.getConnection();
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();
			rs.next();
			rowCount=rs.getInt(1);
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException();
		} finally {
			if(rs!=null) try {rs.close();} catch (Exception e) {}
			if(stmt!=null)try {stmt.close();}catch(Exception e) {}
			if(con!=null)try {con.close();}catch(Exception e) {}
		}
		
		return rowCount;
	}
	
	public ArrayList<Integer> getAllEmpno() {
		ArrayList<Integer> empnoList = new ArrayList<Integer>();
		String sql = "select empno from emp";
		Connection con =null;
		try {
			con = EmpDataSource.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				empnoList.add(rs.getInt("empno"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			EmpDataSource.closeConnection(con);
		}

		return empnoList;
	}
	
	public ArrayList<EmpVO> getAllEmps() {
		ArrayList<EmpVO> empList = new ArrayList<EmpVO>();
		String sql = "select * from emp";
		Connection con = null;
		
		try {
			con = EmpDataSource.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				EmpVO emp = new EmpVO();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				empList.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			EmpDataSource.closeConnection(con); 
		}
		
		return empList;
	}
	
	public int insertEmp(EmpVO vo) {
		int count=0;
		String sql = "insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)" +
				" values (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection con = null;
		
		try {
			con = EmpDataSource.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, vo.getEmpno());
			stmt.setString(2, vo.getEname());
			stmt.setString(3, vo.getJob());
			stmt.setInt(4, vo.getMgr());
			stmt.setDate(5, vo.getHiredate());
			stmt.setDouble(6, vo.getSal());
			stmt.setDouble(7,vo.getComm());
			stmt.setInt(8, vo.getDeptno());
			count=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			EmpDataSource.closeConnection(con); 
		}
		
		return count;
	}
	
	public int updateEmp(EmpVO vo) {
		int count=0;
		String sql = "update emp set ename=?, job=? where empno=?";
		Connection con=null;
		try {
			con=EmpDataSource.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, vo.getEname());
			stmt.setString(2, vo.getJob());
			stmt.setInt(3, vo.getEmpno());
			count=stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			EmpDataSource.closeConnection(con);
		}
		
		return count;
	}
	
	public int deleteEmp(int empno) {
		int deletedRow = 0;
		String sql = "delete from emp where empno=?";
		Connection con=null;
		try {
			con=EmpDataSource.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, empno);
			deletedRow=stmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			EmpDataSource.closeConnection(con);
		}
		
		return deletedRow;
	}

	public ArrayList<String> getAllColumnNames() {
		ArrayList<String> columnNames = new ArrayList<String>();
		String sql = "select * from emp";
		Connection con = null;
		
		try {
			con = EmpDataSource.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			for(int i=0; i<columnCount; i++) {
				columnNames.add(metaData.getColumnName(i+1).toUpperCase());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			EmpDataSource.closeConnection(con); 
		}
		
		return columnNames;
	}

}
