package org.hippo.sample.j2se.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDriver {

	public static final String EMPNO = "empno";
	public static final String ENAME = "ename";
	public static final String JOB = "job";
	public static final String MGR = "mgr";
	public static final String HIREDATE = "hiredate";
	public static final String SAL = "sal";
	public static final String COMM = "comm";
	public static final String DEPTNO = "deptno";
	public static final String DNAME = "dname";
	public static final String LOC = "loc";
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStatmentQuery() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// Initialise driver
			Class.forName("oracle.jdbc.driver.OracleDriver"); //com.mysql.jdbc.Driver
			// Connect to database
			conn = DriverManager.getConnection("jdbc:mysql:@localhost:3306:orcl", "scott", "tiger");
				// jdbc:mysql://localhost:3306/test, username, password 
			// Create Statement
			stmt = conn.createStatement();
			// Query
			ResultSet rs = stmt.executeQuery("select * from emp");
			// Iterate result
			while(rs.next()) {
				// Fetch column data
				int empno = rs.getInt(EMPNO);
				String ename = rs.getString(ENAME);
				String job = rs.getString(JOB);
				int mgr = rs.getInt(MGR);
				Date hirdate = rs.getDate(HIREDATE);
				double sal = rs.getDouble(SAL);
				double comm = rs.getDouble(COMM);
				int deptno = rs.getInt(DEPTNO);
				// Printout
				System.out.println("(" + empno + ", " + ename + ", "
						+ job + ", " + mgr + ", " + hirdate + ", " + sal + ", " + comm + ", " + deptno + ")");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( stmt != null )
					stmt.close();
				if( conn != null ) {
					conn.rollback();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testStatmentUpdate() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// Initialise driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Connect to database
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			boolean autoCommit = conn.getAutoCommit(); conn.setAutoCommit(false);
			// Create Statement
			stmt = conn.createStatement();
			// Update
			int empno = 9999;
			String ename = "test";
			String job = "test";
			int mgr = 7698;
			String hirdate = "null";
			double sal = 1.0;
			double comm = 0.0;
			int deptno = 30;
			String sql = "insert into emp values ("+empno+",'"+ename+"','"+job+"',"+mgr+","+hirdate+","+sal+","+comm+","+deptno+")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			// Transaction
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( stmt != null )
					stmt.close();
				if( conn != null ) {
					conn.rollback();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testPrepareStatment() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// Initialise driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Connect to database
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			boolean autoCommit = conn.getAutoCommit(); conn.setAutoCommit(false);
			// Create Statement
			pstmt = conn.prepareStatement(
					"insert into dept values (?, ?, ?)");
			// Update
			int deptno = 99;		pstmt.setInt(1, deptno);
			String dname = "test";	pstmt.setString(2, dname);
			String loc = "test";	pstmt.setString(3, loc);
			pstmt.executeUpdate();
			// Transaction
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null )
					pstmt.close();
				if( conn != null ) {
					conn.rollback();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testPrepareCall() {
		Connection conn = null;
		CallableStatement cstmt = null;
		try {
			// Initialise driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Connect to database
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			// Create Statement
			cstmt = conn.prepareCall("{call p(?, ?, ?, ?)}");
			int a = 2;		cstmt.setInt(1, a);
			int b = 3;		cstmt.setInt(2, b);
			int c;			cstmt.registerOutParameter(3, Types.INTEGER);
			int d = 4;		cstmt.registerOutParameter(4, Types.INTEGER); cstmt.setInt(4, d);
			// Execute
			cstmt.execute();
			c = cstmt.getInt(3);
			d = cstmt.getInt(4);
			// Printout
			System.out.println(c);
			System.out.println(d);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( cstmt != null )
					cstmt.close();
				if( conn != null ) {
					conn.rollback();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
