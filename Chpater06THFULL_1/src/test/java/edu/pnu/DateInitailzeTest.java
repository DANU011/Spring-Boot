package edu.pnu;

import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.lenient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.repository.BoardRepository;
import edu.pnu.repository.MemberRepository;

@SpringBootTest
public class DateInitailzeTest {
	@Autowired
	private MemberRepository memberRepo;

	@Autowired
	private BoardRepository boardRepo;

	@Test
	public void testDateInsert() {
		Member member1 = new Member();
		member1.setId("mem1");
		member1.setName("둘리");
		member1.setPassword("mem111");
		member1.setRole("user");
		memberRepo.save(member1);
		
		Member member2 = new Member();
		member2.setId("mem2");
		member2.setName("도우너");
		member2.setPassword("mem222");
		member2.setRole("admin");
		memberRepo.save(member2);
		
		for(int i = 1; i <=5 ; i++) {
			Board board = new Board();
			board.setWriter("둘리");
			board.setTitle("둘리가 등록한 게시글");
			board.setContent("둘리가 등록한 게시글 내용"+i);
			boardRepo.save(board);
		}
		
		for(int i = 1; i <=5 ; i++) {
			Board board = new Board();
			board.setWriter("도우너");
			board.setTitle("도우너가 등록한 게시글");
			board.setContent("도우너가 등록한 게시글 내용"+i);
			boardRepo.save(board);
		}
}
}
