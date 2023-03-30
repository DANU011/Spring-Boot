package edu.pnu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.HashMap;

import edu.pnu.domain.MemberVO;

public class MemberDaoH2Impl implements MemberDao {
	private Connection con = null;

	public MemberDaoH2Impl() {
		try {
			// JDBC 드라이버 로드
			Class.forName("org.h2.Driver");

			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> getMembers() {
		Statement st = null;
		ResultSet rs = null;
		String sqlString = "select * from member order by id asc";
		try {
			List<MemberVO> list = new ArrayList<>();
			st = con.createStatement();
			rs = st.executeQuery(sqlString);
			while (rs.next()) {
				MemberVO m = new MemberVO();
				m.setId(rs.getInt("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("name"));
				m.setRegidate(rs.getDate("regidate"));
				list.add(m);
			}
			Map<String, Object> map = new HashMap();
			map.put("sql", sqlString);
			map.put("data", list);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public MemberVO getMember(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		String sqlString = "select * from member where id=?";
		try {
			st = con.prepareStatement(sqlString);
			st.setInt(1, id);
			rs = st.executeQuery();
			rs.next();
			MemberVO m = new MemberVO();
			m.setId(rs.getInt("id"));
			m.setPass(rs.getString("pass"));
			m.setName(rs.getString("name"));
			m.setRegidate(rs.getDate("regidate"));
			return m;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private int getNextId() {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select max(id) from member");
			rs.next();
			return rs.getInt(1) + 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}

	@Override
	public MemberVO addMember(MemberVO member) {

		int id = getNextId();

		PreparedStatement st = null;
		try {
			st = con.prepareStatement("insert into member (id,name,pass,regidate) values (?,?,?,?)");
			st.setInt(1, id);
			st.setString(2, member.getName());
			st.setString(3, member.getPass());
			st.setDate(4, new Date(System.currentTimeMillis()));
			st.executeUpdate();

			return getMember(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public MemberVO updateMember(MemberVO member) {
		PreparedStatement st = null;
		try {
			st = con.prepareStatement("update member set name=?,pass=? where id=?");
			st.setString(1, member.getName());
			st.setString(2, member.getPass());
			st.setInt(3, member.getId());
			st.executeUpdate();

			return getMember(member.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean deleteMember(Integer id) {
		PreparedStatement st = null;
		try {
			st = con.prepareStatement("delete from member where id=?");
			st.setInt(1, id);
			if (st.executeUpdate() == 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Map<String, Object> getMembers(Object sqlString) {
		// TODO Auto-generated method stub
		return null;
	}
}
