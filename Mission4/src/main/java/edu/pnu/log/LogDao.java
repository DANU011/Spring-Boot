package edu.pnu.log;

public interface LogDao {

	void addLog(String method, String sql, boolean success);
	void addLog(String method, String sql, Object result);
	
}