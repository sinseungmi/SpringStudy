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
public class RestSampleController {    //���� ���� ǥ�ô� produces
	                                   //���� �޽��� ������ text/html Ÿ���̰� ���ڿ��� utf-8 ���ڿ����� �˷��ݴϴ�.
	@GetMapping(value = "/getstr", produces = "text/plain; charset=UTF-8")
	public String getString() {
		return "�ȳ��ϼ��� REST��Ʈ�ѷ��Դϴ�";
	}
	
	//�ϳ��� �ּ��� �ϳ��� �ڿ� 
	@GetMapping(value = "/getstr2", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8")
	public String getString2() {
		return "<h3>��ο�</h3>";
	}
	                             //� ������� �������� Ÿ���� ǥ��
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
		//�����͸� �����Ҷ��� �������� ����� ����. �ξ� ����
	}
	 
	@GetMapping(value = "getList", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8") //produces�� ��� �˾Ƽ� �ٲ���
	public List<FruitVO> getSampleList() {  //�ڹٽ�ũ��Ʈ������Ʈ�� ���̽��� �ٸ���. ���̽��� ǥ����� ��
		ArrayList<FruitVO> list = new ArrayList<>();
		
		list.add(new FruitVO());
		list.add(new FruitVO());
		list.add(new FruitVO());
		list.add(new FruitVO());
		list.add(new FruitVO());
		
		return list;
	}
	
	@GetMapping(value = "getMap", produces = MediaType.APPLICATION_JSON_VALUE) //produces�� ��� �˾Ƽ� �ٲ���
	public Map<String, FruitVO> getSampleMap() {  //�ڹٽ�ũ��Ʈ������Ʈ�� ���̽��� �ٸ���. ���̽��� ǥ����� ��
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
		
		//ResponseEntity�� ���α׷��Ӱ� ���� Http ������ �ڼ��� ������ �� �ִ�.
		//������ �޴� ������ status �ڵ带 Ȱ���� �� �ִ�
		ResponseEntity<FruitVO> result =null;
		
		//ResponseEntity�� �޼ҵ带 ���� �ۼ��ϰ� �Ǹ� status -> header -> body 
		//������ �ڵ����� �ۼ��ǵ��� �Ǿ��ִ�
		
		result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FruitVO());
		//���� �ڵ� ����                                       //�Ű������� ������ �����͸� ����ش�
		
		return result;
	}
	
	@GetMapping(value = "/path/{year}/{month}", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8")
	public String pathTest(
			@PathVariable("year") Integer year,
			@PathVariable("month") Integer month
			//@PathVariable : URI�� ����ִ� ���� �Ķ���ͷ� ������ �� ����Ѵ�
	) {
		return "Hello! you putted" + year + "/" + month + "in your uri path.";
	}
	
	/*
	 * @RequestBody
	 * 
	 * 	- ��Ʈ�ѷ����� JSON �����͸� �޾ƾ��� �� ����ϴ� ������̼�
	 *  - ��û�� body�� �Ƿ� �ִ� JSON �����͸� �˾Ƽ� ��ȯ���ش�
	 * 
	 * @PostMapping�� �޼����� ������ ���?
	 * 
	 *  - ũ���� REST Client Ȯ�� ���α׷� �� ������ ��� ���� ����
	 * 
	 * */
	
	@PostMapping(value = "/fruit", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8")
	public String convertJsonFruit(@RequestBody FruitVO fruit) {
		
		
		return "Your fruit is" + fruit;
	}

}
























