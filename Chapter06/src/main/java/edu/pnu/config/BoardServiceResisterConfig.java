package edu.pnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.pnu.service.BoardService;

@Configuration
public class BoardServiceResisterConfig {
	
	@Bean
	public BoardService getBoardService() {
		return new BoardService();
	}
	
	// @Service와 기능은 똑같으나 편의성으로 봤을 때 @Service가 더 좋다
	// 암호화 객체에 많이 사용됨. 레파지토리 컨트롤러 등 다른것도 가능. 

}
