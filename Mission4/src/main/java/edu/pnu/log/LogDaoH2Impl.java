package edu.pnu.log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

import edu.pnu.dao.LogDao;

public class LogDaoH2Impl implements LogDao {

	private Connection con = null;

	public LogDaoH2Impl() {
		try {
			// JDBC 드라이버 로드
			Class.forName("org.h2.Driver");

			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addlog(String method, String sqlString, boolean success) {
		PreparedStatement st = null;
		try {
			st = con.prepareStatement("insert into dblog (method,sqlString,success) values (?,?,?)");
			st.setString(1, method);
			st.setString(2, sqlString);
			st.setBoolean(3, success);
			st.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
