package edu.pnu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.pnu.domain.DBoard;
import edu.pnu.persistence.Boardrepository;


@Service
public class BoardService {
	
	@Autowired
	private Boardrepository boardRepo;
	
	public List<DBoard> getBoardList(){
		return (List<DBoard>)boardRepo.findAll();
	}

	public DBoard getBoard(Long seq) {
		return boardRepo.findById(seq).get();
	}
	
	/*
	@GetMapping("/board")
	public List<DBoard> getBoardList() {
		return (List<DBoard>)boardRepo.findAll();
	}

	@GetMapping("/board")
	public List<DBoard> getBoard(Long seq) {
		if (seq==null) 
			return BoardService.getBoardList(seq);
	}
	
	@GetMapping("/board")
	public List<DBoard> getBoardbyPath(@PathVariable Long seq) {
		boardRepo.findById(seq).get();
		return boardService.getBoard(seq);
	}

	*/
}
