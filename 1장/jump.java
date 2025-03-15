package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class jump{
	@GetMapping("/jump")//GetMapping은 특정 URL 요청이 왔을 때 실행할 메서드를 지정하는 역할
	@ResponseBody//메서드의 결과 값을 HTTP 응답으로 변환
	public String hello123() {//
		return "점프 투 스프링 부트";
	}
}//1장 되새김 문제 1번

//스프링이 실행할 메서드를 찾는 과정
//1. 사용자가 http://localhost:8080/hello로 요청을 보냄
//2. Spring Boot는 현재 등록된 컨트롤러(@Controller가 붙은 클래스)를 검색
//3. 모든 컨트롤러에서 @GetMapping("/hello")가 있는 메서드를 찾음
//4. 해당 메서드를 실행하고, 결과값을 반환
//5. @ResponseBody가 있으면 HTML이 아니라 문자열 그대로 응답
