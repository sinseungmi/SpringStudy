package com.kgitbank.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgitbank.rest.model.FruitVO;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/sample")
public class RestSampleController {    //서버 응답 표시는 produces
	                                   //현재 메시지 내용이 text/html 타입이고 문자열은 utf-8 문자열임을 알려줍니다.
	@GetMapping(value = "/getstr", produces = "text/plain; charset=UTF-8")
	public String getString() {
		return "안녕하세요 REST컨트롤러입니다";
	}
	
	//하나의 주소의 하나의 자원 
	@GetMapping(value = "/getstr2", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8")
	public String getString2() {
		return "<h3>헬로우</h3>";
	}
	                             //어떤 방식으로 리턴할지 타입을 표기
	@GetMapping(value="/getstr3", produces=MediaType.TEXT_HTML_VALUE + ";charset=UTF-8")
	public String getString3() {
	    return "<h3>Hello Rest!</h3>";
	}
	   
	@GetMapping(value="getSample", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	public FruitVO getSampleObject() {
	    return new FruitVO();
	}
	  
	@GetMapping(value="getSampleXML", produces = MediaType.APPLICATION_XML_VALUE + ";charset=UTF-8")
	public FruitVO getSampleObject2() {
		return new FruitVO();
		//데이터를 리턴할때는 원시적인 방법이 좋다. 훨씬 빠름
	}
	 
	@GetMapping(value = "getList", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8") //produces가 없어도 알아서 바꿔줌
	public List<FruitVO> getSampleList() {  //자바스크립트오브젝트랑 제이슨은 다르다. 제이슨은 표기법일 뿐
		ArrayList<FruitVO> list = new ArrayList<>();
		
		list.add(new FruitVO());
		list.add(new FruitVO());
		list.add(new FruitVO());
		list.add(new FruitVO());
		list.add(new FruitVO());
		
		return list;
	}
	
	@GetMapping(value = "getMap", produces = MediaType.APPLICATION_JSON_VALUE) //produces가 없어도 알아서 바꿔줌
	public Map<String, FruitVO> getSampleMap() {  //자바스크립트오브젝트랑 제이슨은 다르다. 제이슨은 표기법일 뿐
		Map<String, FruitVO> map = new HashMap<>();
		
		map.put("apple1", new FruitVO());
		map.put("apple2", new FruitVO());
		map.put("apple3", new FruitVO());
		
		return map;
		
	}
	
	@GetMapping(value = "getMap2", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8") 
	public Map<String, FruitVO> getSampleMap2() {  
		Map<String, FruitVO> map = new HashMap<>();
		
		map.put("apple1", new FruitVO());
		map.put("apple2", new FruitVO());
		map.put("apple3", new FruitVO());
		
		return map;
		
	}
	
	@GetMapping(value = "getRespEntity", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	public ResponseEntity<FruitVO> getRespEntity() {
		
		//ResponseEntity는 프로그래머가 직접 Http 응답을 자세히 설정할 수 있다.
		//응답을 받는 측에서 status 코드를 활용할 수 있다
		ResponseEntity<FruitVO> result =null;
		
		//ResponseEntity를 메소드를 통해 작성하게 되면 status -> header -> body 
		//순으로 자동으로 작성되도록 되어있다
		
		result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FruitVO());
		//상태 코드 변경                                       //매개변수로 응답할 데이터를 담아준다
		
		return result;
	}
	
	@GetMapping(value = "/path/{year}/{month}", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8")
	public String pathTest(
			@PathVariable("year") Integer year,
			@PathVariable("month") Integer month
			//@PathVariable : URI에 들어있는 값을 파라미터로 추출할 때 사용한다
	) {
		return "Hello! you putted" + year + "/" + month + "in your uri path.";
	}
	
	/*
	 * @RequestBody
	 * 
	 * 	- 컨트롤러에서 JSON 데이터를 받아야할 때 사용하는 어노테이션
	 *  - 요청의 body에 실려 있는 JSON 데이터를 알아서 변환해준다
	 * 
	 * @PostMapping에 메세지를 보내는 방법?
	 * 
	 *  - 크롬의 REST Client 확장 프로그램 중 마음에 드는 것을 쓴다
	 * 
	 * */
	
	@PostMapping(value = "/fruit", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8")
	public String convertJsonFruit(@RequestBody FruitVO fruit) {
		
		
		return "Your fruit is" + fruit;
	}

}
























