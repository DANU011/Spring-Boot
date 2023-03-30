package edu.pnu.dao;

import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;

public interface MemberDao {

	Map<String, Object> getMembers();

	MemberVO getMember(Integer id);

	MemberVO addMember(MemberVO member);

	MemberVO updateMember(MemberVO member);

	boolean deleteMember(Integer id);

	Map<String, Object> getMembers(Object sqlString);

}