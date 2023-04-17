package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

//@RestControllers
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
//	@GetMapping("/boardList")
//	public List<Board> getBoardList(Board board) {
//		return boardService.getBoardList(board);
//	}
	
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		List<Board> boardList = boardService.getBoardList(board);
		
		model.addAttribute("boardList",boardList);
		return "getBoardList";
	}
	
	
//	@PostMapping("/insertBoard")
//	public void insertBoardView() {
//		boardService.insertBoard();
//		
//	}
	
//	@PostMapping("/insertBoard")
//	public void insertBoardView() {
//	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "insertBoard";
	}	
	
	@PostMapping("/insertBoard")
	public String insertBoardView(Board board) {
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
//	@GetMapping("/getBoard/{seq}")
//	public Board getBoard(@PathVariable Long seq) { //Rest Api 호출시 URI를 이용해 파라미터 처리를 할수있다
//		Board board = boardService.getBoard(seq);
//		return board;
//	}
	
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board",boardService.getBoard(board));
		return "getBoard";
	}
	
//	@PutMapping("/updateBoard")
//	public void updateBoard(Board board) {
//		boardService.updateBoard(board);
//
//	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	
//	@DeleteMapping("/deleteBoard")
//	public void deleteBoard(Board board) {
//		boardService.deleteBoard(board);
//	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
	
////	@GetMapping("/hello")
//	public String hello(Model model) {
//		model.addAttribute("greeting","hello 타임리프.^^");
//		return "hello";
//	}
//	
}
