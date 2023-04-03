package edu.pnu.log;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Repository;

//@Repository
public class LogDaoListImpl implements LogDao {
	FileWriter fileWriter;

	@Override
	public void addLog(String method, String sql, boolean success) {	
		try {
			fileWriter = new FileWriter("test.txt");
			fileWriter.append(method);
			fileWriter.append(sql);
			fileWriter.append(String.valueOf(success));
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public LogDaoListImpl() {
		
	}

	@Override
	public void addLog(String method, String sql, Object result) {
		addLog(method, sql, result==null? false: true);
	}
}