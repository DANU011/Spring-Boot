package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

public class MemberService {
	private MemberDao memberDao;

	public MemberService() {
		memberDao = new MemberDao(); 
	}
	
	public List<MemberVO> getMembers() { 
		return memberDao.getMembers();
	}

	public MemberVO getMember(Integer id) {
		return memberDao.getMember(id);
	}

	public MemberVO addMember(MemberVO member) {
		// TODO Auto-generated method stub
		return memberDao.addMember(member);
	}

	public MemberVO updateMember(MemberVO member) {
		return memberDao.updateMember(member);
	}

	public MemberVO removeMember(Integer id) {
		return memberDao.removeMember(id);
	}


}
