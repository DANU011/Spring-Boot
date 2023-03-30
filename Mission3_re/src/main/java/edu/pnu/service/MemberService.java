package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDao;
import edu.pnu.dao.MemberDaoH2Impl;
import edu.pnu.domain.MemberVO;

public class MemberService{
	private MemberDao memberDao;
	
	
	public MemberService() {
		super();
		this.memberDao = new MemberDaoH2Impl();
//		memberDao = new MemberDaoListImpl();
	}

	public List<MemberVO> getMembers() {
		return memberDao.getMembers();
	}

	public MemberVO getMember(Integer id) {
		return memberDao.getMember(id);
	}

	public MemberVO addMember(MemberVO member) {
		return memberDao.addMember(member);
	}

	public MemberVO updateMember(MemberVO member) {
		return memberDao.updateMember(member);
	}

	public MemberVO deleteMember(Integer id) {
		return memberDao.delete(id);
	}

}
