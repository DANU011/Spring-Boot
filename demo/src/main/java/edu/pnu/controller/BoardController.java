package edu.pnu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import edu.pnu.domain.Person;


//@Bean, @Component...등 많음
//@Controller는 뷰를 찾으려고 해서 오류가 뜸.
//클래스 리턴 가능
//객체 리턴 가능 > 자동으로 json object으로 변경해서 보내줌. 
//기본적으로 부트에서는 json사용
@RestController //실행과 동시에 부트가 자기 패키지 안에있는 클래스를 인스턴스 생성해서 올려둠. 클래스 하나로도 구현 가능 
public class BoardController {

	public BoardController() {
		System.out.println("===>BoardController 생성");
	}

	/*
	 * @GetMapping("/hello") public String hello(String name) { return
	 * "Hello : "+name; }
	 */

	@PostMapping("/hello")
	public String hello(String name) {
		return "Hello Post : " + name;
	}

	
	@GetMapping("/getPerson")
	public Person getPerson() {
		return new Person("홍길동", 2000, "백수", "선플");
	}
	
	//리스트 리턴
	@GetMapping("/getPersons")
	public List<Person> getPersons() {
		List<Person> list = new ArrayList<>();
		list.add(new Person("홍길동", 2000, "백수", "선플"));
		list.add(new Person("홍이동", 1995, "백수", "악플"));
		list.add(new Person("홍삼동", 2005, "백수", "없음"));
		
		return list;
	}

}