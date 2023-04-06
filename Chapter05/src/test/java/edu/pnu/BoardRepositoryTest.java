package edu.pnu;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository boardRepo;

//	@Test
	public void BoardInsertTest() {
		for (int i = 1; i <= 100; i++) {
			Board b = new Board();
			Random random = new Random();
			b.setTitle("title" + i);
			b.setContent("content" + i);
			b.setWriter("writer" + i);
			b.setCreateDate(new Date());
			// b.setCnt(0L);
			b.setCnt(random.nextLong(100) + 1);
			boardRepo.save(b);
		}
	}

//	@Test	
	public void TestGetBoard() {
		Board b = boardRepo.findById(1L).get();
		System.out.println(b); // board에 toString 추가해줘서 b에 .toString() 추가해주지 않아도 ok
		// application.properties spring.jpa.hibernate.ddl-auto 설정 update인지 create인지
		// 확인할것.
	}

//	@Test
	public void TestUpdateBoard() {
		System.out.println("===4번 게시글 조회===");
		Board b = boardRepo.findById(4L).get();

		System.out.println("===4번 게시글 제목 수정===");
		b.setTitle("4번 제목을 수정했습니다.");
		boardRepo.save(b);
	}

//	@Test
	public void TestDeleteBoard() {
		boardRepo.deleteById(3L);
	}

//=============================================쿼리 메서드 활용=========================================================

//	@Test
	public void testByTitleContaining() {
		List<Board> boardList = boardRepo.findByTitleContaining("1");
		System.out.println("검색결과");
		for (Board board : boardList) {
			System.out.println("--->" + board);
		}
	}

//	@Test
	public void testByTitleContainingCntGreaterThan() {
		List<Board> boardList = boardRepo.findByTitleContainingAndCntGreaterThan("1", 50L);
		for (Board board : boardList) {
			System.out.println("--->" + board);
		}

	}

//	@Test
	public void testByCntGreaterThanEqualAndCntLessThanEqual() {
		List<Board> boardList = boardRepo.findByCntGreaterThanEqualAndCntLessThanEqual(10L, 50L);
		for (Board board : boardList) {
			System.out.println("--->" + board);
		}
	}

//	@Test
	public void testByCntBetweenOrderBySeqAsc() {
		List<Board> boardList = boardRepo.findByCntBetweenOrderBySeqAsc(10L, 50L);
		for (Board board : boardList) {
			System.out.println("--->" + board);
		}
	}

//	@Test
	public void testByTitleContainingOrContentContaining() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc("10", "2");
		for (Board board : boardList) {
			System.out.println("--->" + board);
		}
	}
//=============================================== Paging test ========================================================

//	@Test
	public void test() {
		Pageable paging = PageRequest.of(0, 10);
		List<Board> boardlist = boardRepo.queryAnnotationTest(paging);

		for (Board board : boardlist) {
			System.out.println("--->" + board);
		}
	}

//	@Test
//	public void findByTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5);
//		List<Board> boardlist = boardRepo.findByTitleContaining("title1", paging);
//		
//		System.out.println("검색 결과");
//		for(Board board : boardlist) {
//			System.out.println("--->"+board);
//		}
//	}

	// @Test
	public void findByTitleContaining() {
		Pageable paging = PageRequest.of(0, 5);
		Page<Board> pageInfo = boardRepo.findByTitleContaining("title1", paging);

		System.out.println("page size :" + pageInfo.getSize());
		System.out.println("total count :" + pageInfo.getTotalElements());
		System.out.println("total page :" + pageInfo.getTotalPages());
		System.out.println("next :" + pageInfo.getPageable());

		List<Board> boardlist = pageInfo.getContent();

		System.out.println("검색 결과");
		for (Board board : boardlist) {
			System.out.println("--->" + board);
		}
	}

//	@Test
	public void testqueryAnnotationTest2() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest2("title10");

		System.out.println("검색 결과");
		for (Object[] row : boardList) {
			System.out.println("--->" + Arrays.toString(row));
		}
	}

	@Test
	public void testQueryAnnotationTest3() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest3("title11");

		System.out.println("검색 결과");
		for (Object[] row : boardList) {
			System.out.println("--->" + Arrays.toString(row));
		}
	}

}
