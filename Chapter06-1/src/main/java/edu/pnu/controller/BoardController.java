package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model; //이 모델 맞나??
import edu.pnu.domain.DBoard;
import edu.pnu.service.BoardService;
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/board")
	//public List<DBoard> getBoardList(Model model){
	public void getBoardList(Model model) {
		List<DBoard> list = boardService.getBoardList();
		model.addAttribute("boardList", list);
	} 
	
	//Model은 Controller에서 View로 데이터를 전달하기 위한 객체
	//addAttribute() 메서드는 Model 객체에 데이터를 추가
	
	
	
	@GetMapping("/")
	
	public DBoard getBoard(Long seq){
		return boardService.getBoard(seq);
	}
	// Long nullable, long null값 취급x
	
	
	/*
	// parameter 형식 ?=..
	@GetMapping("/board")
	public List<DBoard> getBoard(Long seq){
		if(seq == null) return boardService.getBoardList();
		
		List<DBoard> list = new ArrayList<>();
		list.add(boardService.getBoard(seq));
		return list;
	}
	*/
	
	@GetMapping("/board/{seq}")
	public DBoard getBoardbyPath(@PathVariable Long seq){
		
		System.out.println("getBoard PathVariable : " + seq);
		return boardService.getBoard(seq);
	}
	
	/*
	@GetMapping("/board")
	public List<DBoard> getBoardList(){
		return boardService.getBoardList();
	}
	
	@GetMapping("/board")
	// Long nullable, long null값 취급x
	public DBoard getBoard(Long seq){
		return boardService.getBoard(seq);
	}
	
	
	
	@GetMapping("/board")
	public List<DBoard> getBoard(Long seq){
		if(seq == null) return boardService.getBoardList();
		
		List<DBoard> list = new ArrayList<>();
		list.add(boardService.getBoard(seq));
		return list;
	}
	
	@GetMapping("/board/{seq}")
	public DBoard getBoardbyPath(@PathVariable Long seq){
		
		System.out.println("getBoard PathVariable : " + seq);
		return boardService.getBoard(seq);
	}
	*/
}
