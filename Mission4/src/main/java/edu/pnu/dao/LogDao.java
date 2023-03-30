package edu.pnu.dao;

import java.util.Date;

public interface LogDao {
	void addlog(String method, String sqlString, boolean success);
}