package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

		@Autowired
		private BoardRepository boardRepo;
		
		public List<Board> getBoardList(Board board){
			return (List<Board>)boardRepo.findAll();
		}
		
//		public void insertBoard() {
//			for(int i=1; i<=10;i++) {
//			Board board = new Board();
//			board.setTitle("제목"+i);
//			board.setWriter("작성자"+i);
//			board.setContent(i+"번째 내용입니다.");
//			boardRepo.save(board);	
//			}
//			
//		}
		
		public void insertBoard(Board board) {
			boardRepo.save(board);
		}
		
		
		public Board getBoard(Board board) {
			return boardRepo.findById(board.getSeq()).get();
		}
		
		public void updateBoard(Board board) {
			Board findBoard = boardRepo.findById(board.getSeq()).get();
			
			findBoard.setTitle(board.getTitle());
			findBoard.setContent(board.getContent());
			boardRepo.save(board);
		}
		
		public void deleteBoard(Board board) {
			boardRepo.deleteById(board.getSeq());
		}
}
