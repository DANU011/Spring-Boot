package edu.pnu;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
public class RelationMappingTest2 {
	@Autowired
	private BoardRepository boradRepo;
	@Autowired
	private MemberRepository memberRepo;
	
	@Test
	public void testManyToOneInsert() {
		Member member3 = new Member();
		member3.setId("member3");
		member3.setPassword("member333");
		member3.setName("둘리");
		member3.setRole("User");
//		memberRepo.save(member3);
		
		Member member4 = new Member();
		member4.setId("member4");
		member4.setPassword("member444");
		member4.setName("도우너");
		member4.setRole("Admin");
//		memberRepo.save(member4);
		
		for(int i=1; i <= 3; i++) {
			Board board = new Board();
			board.setMember(member3);
			board.setTitle("둘리가 등록한 게시글"+i);
			board.setContent("둘리가 등록한 게시글내용"+i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
//			boradRepo.save(board);
		}
		
		for(int i=1; i <= 3; i++) {
			Board board = new Board();
			board.setMember(member4);
			board.setTitle("도우너가 등록한 게시글"+i);
			board.setContent("도우너가 등록한 게시글내용"+i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
//			boradRepo.save(board);
		}
	}
	
	//@Test
	public void testTwoWayMapping() {
		Member member = memberRepo.findById("member3").get();
		System.out.println("==============================");
		System.out.println(member.getName()+"가(이) 저장한 게시글 목록");
		System.out.println("==============================");
		List<Board> list = member.getBoardList();
		for(Board board : list) {
			System.out.println(board);
		}
	}
	
	@Test
	public void testCascadeDeelete() {
		memberRepo.deleteById("member4");
	}
}
