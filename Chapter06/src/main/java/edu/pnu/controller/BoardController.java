package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aj.org.objectweb.asm.Attribute;
import ch.qos.logback.core.model.Model;
import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.service.BoardService;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@RestController
public class BoardController {
	
	//@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public List<Board> getAllBoards() {
		List<Board> boardList = boardService.getAllBoards();
		return boardList;
//		System.out.println("test");
//		return null;
		
	}
}
