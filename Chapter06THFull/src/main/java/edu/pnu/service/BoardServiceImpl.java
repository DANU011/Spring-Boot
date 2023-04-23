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
	
	@Override
	public List<Board> getBoardList(Board board) {
		return (List<Board>) boardRepo.findAll();
	}

	@Override
	public void insertBoard(Board board) {
		boardRepo.save(board);
	}

	@Override
	public Board getBoard(Board board) {
		return boardRepo.findById(board.getSeq()).get();
	}

	@Override
	public Board updateBoard(Board board) {
		Board b = boardRepo.findById(board.getSeq()).get();
		b.setTitle(board.getTitle());
		b.setContent(board.getContent());
		boardRepo.save(b);
		return b;
	}

	@Override
	public Board deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());
		return board;
	}
}