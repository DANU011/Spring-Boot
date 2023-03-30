package edu.pnu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDaoListImpl implements MemberDao {

	private List<MemberVO> list; 
	
	public MemberDaoListImpl() {
		list = new ArrayList<>();
		for(int i = 1; i <=5;i++) {
			list.add(new MemberVO(i, "1234", "이름"+i, new Date()));
		}
	}

	@Override
	public List<MemberVO> getMembers() {
		return list;
	}

	@Override
	public MemberVO getMember(Integer id) {
		for(MemberVO memberVO : list) {
			if(memberVO.getId()==id)
				return memberVO;
		}
		return null;
	}

	@Override
	public MemberVO addMember(MemberVO member) {
		member.setId(list.size()+1);
		member.setRegidate(new Date());
		list.add(member);
		return member;
	}

	@Override
	public MemberVO updateMember(MemberVO member) {
		for(MemberVO memberVO:list) {
			if(memberVO.getId()==member.getId()) {
				memberVO.setName(member.getName());
				memberVO.setPass(member.getPass());
				return memberVO;
			}
		}
		return null;
	}

	@Override
	public boolean deleteMember(Integer id) {
		for(MemberVO memberVO:list) {
			if(memberVO.getId()==id) {
				list.remove(memberVO);
				return true;
			}
		}
		return false;
	}

}
