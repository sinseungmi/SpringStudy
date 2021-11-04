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
@RequestMapping("/hello") //Ŭ���� ���� ������ �����ߴٸ� �Ʒ� �޼������ url�˻��� /hello�� �� �Է��ؾ��Ѵ�
public class HelloController {
	
	//�� �ּҿ� �ΰ����̻� ��û ��� ��� ����
	@RequestMapping(
			value = {"/minsu", "/�μ�"}, 
			method = {
					RequestMethod.GET, 
					RequestMethod.POST,
					RequestMethod.DELETE})
	public String minsu() {
		log.info("minsu controller�� ����");
		
		return "/hello/minsu";
		
	}

	//�� �ּҿ� �ΰ��� �̻� ��Ʈ�ѷ� ��밡��
	@GetMapping("/chulsu")  //String name, int age      //�ѹ��� �����ؼ� ���� ������ ���� �ִ�
	public void getChulsu(Human human, 
			@RequestParam("number") int myNumber,    //�������� �޴� �迭�� @RequestParam("taste")�� �ɾ�����ϰ� 
			                         // �ϳ��� ���� ���� ���� @RequestParam ��� ��? �׸��� param�� �Ű����� �̸��� ��ġ�ϴ°� ����
			@RequestParam("taste") ArrayList<String> taste) { 
		log.info("chulsu controller�� ����");   
		log.info("name : " + human.getName());
		log.info("age : " + human.getAge()); //url���� �޴� ���� ��Ʈ���ε� int�� ���� �� �ִ� ������ �˾Ƽ� int�� ��ȯ����
		                                     //(�Ķ���� ����(��ûname)�� �� ������ ��ġ�ϸ� ���� �� ����)
		log.info("myNumber : " + myNumber);
		log.info(taste);
	}
	
	@PostMapping("/chulsu")
	public void postChulsu() {
		log.info("post Chulsu");
	}
	
	/*
	 * ���������� Model�� request.setAttribute()�� ����� ������ �Ѵ�.
	 * - model.addAttribute("attr1", "ABC");
	 * 
	 * */
	
	@GetMapping("/choosinsu")  //���� �ʿ��Ҷ��� ���°� ����(��û���� ������ ���� �߰��� �� �ư� ���� �� ���� �ʿ�!)
	public String choo(Model model, 
			@ModelAttribute("age") int age, 
			@ModelAttribute("name") String name) {
		    //@ModelAttribute�� �ϸ� �ֵ��Ʈ����Ʈ�� ���ص� ��
		
		//�Ķ���Ϳ� �Ƿ��� ���� �Ű������� ����ְ�, �� ��Ʈ����Ʈ���� �ڵ����� �Ƿ��ִ�
		System.out.println("age : " + age);
		System.out.println("name : " + name);
	
		//model.addAttribute("attr2", name + age);
		model.addAttribute("attr1", "ABC");
		model.addAttribute("ABCDEFG"); //${string} : name ������ ���ϸ� �ڱ� Ŭ���� �̸����� ����! ""�� ��Ʈ�� Ŭ����
		
		return "/hello/attrTest";  //���� ������ �ּҿ� ���ϵ� �ּ� �̸��� ���ٸ� ���� ���� ���ص� �Ǳ���
		
	}
	
	@GetMapping("/park") //void�� Mapping������ �ּҷ� �˾Ƽ� ������
	public void park(Human human) { //��û���� ������ ���� �״�� �н��� �� ���� ��
		System.out.println(human.getName());
		System.out.println(human.getAge());
		
	}
	
	@GetMapping("/kim")
	public String kim() {
		//return "redirect:"�� redirect �������� �ּҷ� url��û�� �ٽ� �ϴ� ��!
		//�׷� ���� �ּҰ� �ٲ�� �ش� url�� ���ϴ� ��Ʈ�ѷ��� �Լ��� �ѹ� �� ȣ�� �Ǵ� ���̴�
		return "redirect:/hello/park?name=kim&age=321";
	}
	
	@RequestMapping("/model1") //�̰� ���������� jsp�� ���� �Ͱ� ��������,,
	public ModelAndView modelAndView() {
		ModelAndView mnv = new ModelAndView();
		
		//addObject�� ��Ʈ����Ʈ�� �ư�
		mnv.addObject("a", 10);
		mnv.addObject("b","string");
		mnv.addObject("Integer");
		
		//setViewName���� �������� ������ �� ���������� ������ �� �ִ� ���� ��ü
		mnv.setViewName("/hello/mnv");
		
		return mnv;
	}

}










