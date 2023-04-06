package com.rubypaper;

import java.lang.annotation.Repeatable;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.border.Border;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Board1;

public class JPAClient_1 {
	public static void main(String[] args) {
		//EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04_MySQL");
		
		insertBoard(emf); // persistence.xml ->li1 <property name="hibernate.hbm2ddl.auto" value="create" /> 매번 지우고 새로 생성
		findBoardOne(emf, 1L);
//		findBoardManyJPAQuery(emf);
//		findBoardManyNativeQuery(emf);
//		
//		updateBoard(emf, 1L);
//		deleteBoard(emf, 1L);
		
		emf.close();
	}
	
	public static void deleteBoard(EntityManagerFactory emf, long l) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			Board board = em.find(Board.class, 1L);
			board.setSeq(1L);
			
			board.setSeq(1L);
			em.remove(board);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			//emf.close();
		}
	}
		

	public static void updateBoard(EntityManagerFactory emf, long l) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx =em.getTransaction();
		try {
			tx.begin();
			
			Board board = em.find(Board.class, 1L);
			board.setTitle("검색한 게시글의 제목 수정");
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			//emf.close();
		}
	}
	

	public static void findBoardManyNativeQuery(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		try {
			// 방법1
			List<?> list = em.createNativeQuery("select * from Board", Board.class).getResultList();
			for (Object b : list) {
				System.out.println(b);
			}
			System.out.println("-".repeat(100));
			// 방법2
			@SuppressWarnings("unchecked")
			List<Object[]> list1 = em.createNativeQuery("select * from Board").getResultList();
			for (Object[] b : list1) {
				for (int i = 0; i < b.length; i++) {
					if (i!=0) System.out.println(",");
					System.out.println(b[i]);
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	


	public static void findBoardManyJPAQuery(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		try {
//			TypedQuery<Board> result = em.createQuery("select b from Board b", Board.class);
//			List<Board> list = result.getResultList(); 
//			//Board listBoard = em.find(Board.class, allList);
//			for(Board b : list) {
//				System.out.println(b);
			TypedQuery<Board1> result = em.createQuery("select b from Board b", Board1.class);
			List<Board1> list = result.getResultList(); 
			for(Board1 b : list) {
				System.out.println(b);
			}
			System.out.println("=".repeat(80));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

	public static void findBoardOne(EntityManagerFactory emf, long seq) {
		EntityManager em = emf.createEntityManager();
		try {
			// 글 상세 조회
//			Board searchBoard = em.find(Board.class, seq);
//			System.out.println("--->"+searchBoard.toString());
			Board1 searchBoard = em.find(Board1.class,seq);
			System.out.println("--->"+searchBoard.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			//emf.close();
		}
	}

	
	public static void insertBoard(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx =em.getTransaction();
		
		try {
//			tx.begin();
//			for(int i = 1 ; i <= 10 ; i++) {
//			Board board = new Board();
//			board.setTitle("JPA 제목"+i);
//			board.setWriter("관리자"+i);
//			board.setContent("JPA 글 등록 잘 되네요."+i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			
//			//글등록
//			em.persist(board);
//			}
//			tx.commit();
			
			tx.begin();
			for(int i=1; i<=10; i++) {
				Board1 board1 = Board1.builder()
						.title("title"+i)
						.content("content"+i)
						.writer("writer")
						//.createDate(new Date())
						.build();
				
				em.persist(board1);
			}
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			//emf.close();
		}
	}

}
