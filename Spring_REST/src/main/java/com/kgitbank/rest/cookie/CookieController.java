package com.kgitbank.rest.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/cookie")
@Controller
public class CookieController {
	
	@GetMapping("/login")
	public void login(String id, String password ,Model model ,HttpServletResponse response) {
		if(id.equals("abcd") && password.equals("1234")) {
			//쿠키는 모델에 어트리뷰트로 자동으로 실어주지 않는다 때문에 내가 모델에 실어줘야함
			//원래 쿠키에서 login 성공시 1대신 암호를 전달해야함
			//쿠키는 문자열로 밖에 받지 못한다
			Cookie cookie1 = new Cookie("login", "1");
			Cookie cookie2 = new Cookie("id", "abcd");
			
			cookie1.setMaxAge(50);
			cookie1.setHttpOnly(true);
			
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
			model.addAttribute("login", true);
			//session.setAttribute("login", true);
			log.info("로그인 성공");
		}else {
			
			//로그인 실패시 쿠키 삭제하기(삭제하고 싶은 쿠키의 수명을 0으로 설정한다)
			Cookie cookie = new Cookie("id","");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			
			//로그인 쿠키 값 수정하기
			response.addCookie(new Cookie("login", "0"));
			
			model.addAttribute("login", false);
			log.info("로그인 실패");
			//session.setAttribute("login", false);
		}
		
	}
	
	@GetMapping("/read-all-cookies")
	public String readAllCookies(HttpServletRequest request) {
		//쿠키는 기본적으로 배열.JSP의 쿠키는 배열로 꺼낼 수 밖에 없다. 사용하기 불편하다
		
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				log.info("name : " + cookie.getName());
				log.info("value : " + cookie.getValue());
			}
		}
		
		return "/cookie/check";
	}
	
	@GetMapping("/check")
	public void check(
		@CookieValue(value = "id", defaultValue = "비회원") String id,
		@CookieValue(value = "login", defaultValue = "0") String login,
		Model model
	) {
		model.addAttribute("id", id);
		model.addAttribute("login", login);

	}

}












