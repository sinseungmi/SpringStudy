package com.kgitbank.practice;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kgitbank.model.Human;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/hello") //클래스 위에 매핑을 설정했다면 아래 메서드들의 url검색시 /hello도 꼭 입력해야한다
public class HelloController {
	
	//한 주소에 두가지이상 요청 방식 사용 가능
	@RequestMapping(
			value = {"/minsu", "/민수"}, 
			method = {
					RequestMethod.GET, 
					RequestMethod.POST,
					RequestMethod.DELETE})
	public String minsu() {
		log.info("minsu controller에 도착");
		
		return "/hello/minsu";
		
	}

	//한 주소에 두가지 이상 컨트롤러 사용가능
	@GetMapping("/chulsu")  //String name, int age      //넘버로 지정해서 값을 가져올 수도 있다
	public void getChulsu(Human human, 
			@RequestParam("number") int myNumber,    //여러값을 받는 배열은 @RequestParam("taste")을 걸어줘야하고 
			                         // 하나의 값을 받을 때는 @RequestParam 없어도 됨? 그리고 param과 매개변수 이름은 일치하는게 좋음
			@RequestParam("taste") ArrayList<String> taste) { 
		log.info("chulsu controller에 도착");   
		log.info("name : " + human.getName());
		log.info("age : " + human.getAge()); //url에서 받는 값은 스트링인데 int에 들어올 수 있는 이유는 알아서 int로 변환해줌
		                                     //(파라미터 변수(요청name)와 모델 변수명만 일치하면 값이 잘 들어간다)
		log.info("myNumber : " + myNumber);
		log.info(taste);
	}
	
	@PostMapping("/chulsu")
	public void postChulsu() {
		log.info("post Chulsu");
	}
	
	/*
	 * 스프링에서 Model은 request.setAttribute()와 비슷한 역할을 한다.
	 * - model.addAttribute("attr1", "ABC");
	 * 
	 * */
	
	@GetMapping("/choosinsu")  //모델은 필요할때만 쓰는게 편함(요청으로 전달한 값에 추가로 더 싣고 싶을 때 모델이 필요!)
	public String choo(Model model, 
			@ModelAttribute("age") int age, 
			@ModelAttribute("name") String name) {
		    //@ModelAttribute를 하면 애드어트리뷰트도 안해도 됨
		
		//파라미터에 실려온 값이 매개변수에 들어있고, 모델 어트리뷰트에도 자동으로 실려있다
		System.out.println("age : " + age);
		System.out.println("name : " + name);
	
		//model.addAttribute("attr2", name + age);
		model.addAttribute("attr1", "ABC");
		model.addAttribute("ABCDEFG"); //${string} : name 설정을 안하면 자기 클래스 이름으로 간다! ""는 스트링 클래스
		
		return "/hello/attrTest";  //위에 설정한 주소와 리턴될 주소 이름이 같다면 리턴 설정 안해도 되긴함
		
	}
	
	@GetMapping("/park") //void는 Mapping설정된 주소로 알아서 보내줌
	public void park(Human human) { //요청으로 전달한 값을 그대로 패스할 때 쓰는 법
		System.out.println(human.getName());
		System.out.println(human.getAge());
		
	}
	
	@GetMapping("/kim")
	public String kim() {
		//return "redirect:"는 redirect 오른쪽의 주소로 url요청을 다시 하는 것!
		//그로 인해 주소가 바뀌고 해당 url에 속하는 컨트롤러의 함수가 한번 더 호출 되는 것이다
		return "redirect:/hello/park?name=kim&age=321";
	}
	
	@RequestMapping("/model1") //이건 스프링에서 jsp를 쓰는 것과 마찬가지,,
	public ModelAndView modelAndView() {
		ModelAndView mnv = new ModelAndView();
		
		//addObject로 어트리뷰트도 싣고
		mnv.addObject("a", 10);
		mnv.addObject("b","string");
		mnv.addObject("Integer");
		
		//setViewName으로 다음으로 포워드 할 페이지까지 선택할 수 있는 만능 객체
		mnv.setViewName("/hello/mnv");
		
		return mnv;
	}

}










