package edu.pnu.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import edu.pnu.dao.LogDao;
import edu.pnu.dao.MemberDao;
import edu.pnu.dao.MemberDaoH2Impl;
import edu.pnu.domain.MemberVO;
import edu.pnu.log.LogDaoH2Impl;

@Service
public class MemberService {
	private MemberDao memberDao;
	private LogDao logDao;
	
	public MemberService() {
		memberDao = new MemberDaoH2Impl();
		logDao = new LogDaoH2Impl();
	}

	@SuppressWarnings("unchecked")
	public List<MemberVO> getMembers() {
		Map<String, Object> map = memberDao.getMembers();//
		logDao.addlog("get", map.get("sql").toString(), true);
		
		return (List<MemberVO>)map.get("data");
	}

	public MemberVO getMember(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public MemberVO addMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

	public MemberVO updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteMember(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}