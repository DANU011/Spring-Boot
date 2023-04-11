package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

//@RestController
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;


//	@RequestMapping("/getBoardList")
//	public String getBoardList(Model model) {
//		List<Board> boardList = new ArrayList<>();
//		for(long i =1; i<=10;i++) {
//			Board board = new Board();
//			board.setSeq(i);
//			board.setTitle("게시판 프로그램 테스트");
//			board.setWriter("도우너");
//			board.setContent("게시판 프로그램 테스트입니다...");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardList.add(board);
//			
//		}
//		model.addAttribute("boardlist",boardList);
//		return "board/getBoardList";
////		return boardList;
//	}
	
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model,Board board) {
		List<Board> boardList = boardService.getBoardList(board);
		
		model.addAttribute("boardList", boardList);
		return "board/getBoardList";}
	
	
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "board/insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
		
}
