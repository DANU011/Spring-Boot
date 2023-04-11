package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import edu.pnu.domain.DBoard;
import edu.pnu.persistence.Boardrepository;
import edu.pnu.service.BoardService;

@SpringBootTest
class Chapter061ApplicationTests {

	@Autowired
	Boardrepository boardRepo;

	@Autowired
	BoardService boardService;

	@Test
	void contextLoads() {
	}

	@Test
	void insertDataTest() {
		for (int i = 1; i <= 10; i++) {

			DBoard board = new DBoard();
			board.setTitle("title" + i);
			board.setContent("content" + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);

			boardRepo.save(board);

		}
	}

	@Test
	void getBoardListTest() {
		List<DBoard> list = boardService.getBoardList();
		for (DBoard board : list) {
			System.out.println(board); // string 형태가 들어가야 할 경우 알아서 string 형태로 출력함. toString() 안 적어도 됨
		}
	}

//	@Test
//	public class BoardServiceTest {
//		public List<DBoard> getBoardList() {
//			List<DBoard> list = boardService.getBoardList();
//			for (DBoard board : list) {
//				System.out.println();
//			}
//		}

}
