package edu.pnu.controller;

import java.util.List;

import org.slf4j.Logger; //LoggerFactory
import org.slf4j.LoggerFactory; //LoggerFactory
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController //어노테이션을 사용하여 컨트롤러를 RESTful 웹 서비스로 구현
public class MemberController { //클래스는 RESTful API 요청을 처리하는 컨트롤러
								//HTTP 요청을 처리하고 응답을 반환하는 데 사용
	private MemberService memberService;
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class); //LoggerFactory
	
	public MemberController() {
		log.info("MemberController 생성자 호출");
		
		log.info("info 로그 메세지");
		log.trace("trace 로그 메세지");
		log.error("error 로그 메세지");
		log.warn("warn 로그 메세지");
		log.debug("debug 로그 메세지");
		
		memberService = new MemberService();
	}
	
	
	@GetMapping("/member") //어노테이션을 사용하여 GET, POST, PUT, DELETE 요청에 대한 메서드를 구현
	public List<MemberVO> getMembers() { //모든 멤버를 반환
		log.info("getMembers()");
		return memberService.getMembers();
	}

	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) { //특정 멤버를 반환
		log.info("getMember()");
		return memberService.getMember(id);
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO member) { //새로운 멤버를 추가
		log.info("addMember()");
		return memberService.addMember(member);
	}

	@PutMapping("/member")
	public MemberVO updateMember(MemberVO member) { //기존 멤버를 업데이트
		log.info("updateMember()");
		return memberService.updateMember(member);
	}
	
	@DeleteMapping("/member/{id}")
	public MemberVO removeMember(@PathVariable Integer id) { // 특정 멤버를 삭제
		log.info("removeMember()");
		return memberService.removeMember(id);
	}
}
