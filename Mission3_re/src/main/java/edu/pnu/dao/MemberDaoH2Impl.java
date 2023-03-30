package edu.pnu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDaoH2Impl implements MemberDao {
	private Connection con;
	
	public MemberDaoH2Impl() {
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

	@Override
	public List<MemberVO> getMembers() {
		Statement stmt = null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from member order by id asc");
			while (rs.next()) {
				MemberVO memberVO = new MemberVO();
				memberVO.setId(rs.getInt("id"));
				memberVO.setPass(rs.getString("pass"));
				memberVO.setName(rs.getString("name"));
				memberVO.setRegidate(rs.getDate("regidate"));
				list.add(memberVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public MemberVO getMember(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO addMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
