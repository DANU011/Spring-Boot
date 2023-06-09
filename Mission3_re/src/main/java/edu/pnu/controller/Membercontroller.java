package edu.pnu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class Membercontroller implements MemberDao {

	private MemberService memberService;
	
	private static final Logger log = LoggerFactory.getLogger(Membercontroller.class);
	
	public Membercontroller(MemberService memberService) {
		log.info("Membercontroller");
		this.memberService = memberService;
		
	}
	
	@Override
	@GetMapping("/member")
	public List<MemberVO> getMembers(){
		log.info("getMembers()");
		return memberService.getMembers();
	}
	
	@Override
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		log.info("getMember",id);
		return memberService.getMember(id);
	}
	
	@Override
	@PostMapping("/member")
	public MemberVO addMember(MemberVO member) {
		log.info("addMember");
		return memberService.addMember(member);
	}
	
	@Override
	@PutMapping("/member")
	public MemberVO updateMember(MemberVO member) {
		log.info("updateMember");
		return memberService.updateMember(member);
	}
	
	@Override
	@DeleteMapping("/member/{id}")
	public MemberVO delete(@PathVariable Integer id) {
		log.info("deleteMember", id);
		return memberService.deleteMember(id);
	}
}
