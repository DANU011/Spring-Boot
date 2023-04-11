package edu.pnu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

//@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	public List<Board> getAllBoards() {
		return (List<Board>) boardRepository.findAll();
	}
}
