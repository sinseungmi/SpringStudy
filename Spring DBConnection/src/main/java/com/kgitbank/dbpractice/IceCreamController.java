package com.kgitbank.dbpractice;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kgitbank.mapper.IceCreamMapper;
import com.kgitbank.model.Employee;
import com.kgitbank.model.IceCream;
import com.kgitbank.service.MenuService;

import lombok.extern.log4j.Log4j;


@Log4j
@Controller
@Component
public class IceCreamController {
	
	@Autowired
	MenuService ice_service;
	
	@Autowired
	IceCreamMapper iceCreamMapper;
	
	@PostMapping("/createIce") //아이스크림 db 정보 추가!
	public String createIce(IceCream ice) {
		
		//원래 새로운 메뉴를 추가할 때 해야할 작업들을 처리해야한다. (비즈니스 로직)
		// ex) 동일한 이름의 메뉴가 있는지 체크, 메뉴 이름이 형식에 맞는지 체크, 값은 제대로 왔는지 체크
		//비즈니스 로직은 재사용할 여지가 많다! 그래서 컨트롤러에 종속시키면 안된다
		//컨트롤러에서는 데이터를 어트리뷰트에 싣고 다음 페이지로 안내하는 작업만 하는 것이 바람직하다
		ice_service.addIce(ice); //iceCreamMapper.create(ic)이거를 세분화 시켜서!
		
		//int row = iceCreamMapper.create(ic);
		//System.out.println(row);
		
		return "/CRUD";
		
	}
	
	@PostMapping("/updateIce")
	public String updateIce(IceCream ic, @RequestParam("change_name") String change_name) {
		System.out.println(ic.getIce_name()); //model객체 변수명과 파라미터 name이 같아야하는 이유!
		System.out.println(ic.getPrice());    //매개변수를 IceCream ic 이렇게 객체로 받았을 때 스프링은 
		                                      //model객체 변수명과 파라미터 name이 일치하는 애들로 짝을 지어준다!
		System.out.println(change_name);
		
		int row = iceCreamMapper.update(ic, change_name);
		System.out.println(row);
		
		return "/CRUD";
	}
	
	@PostMapping("/deleteIce")
	public String delete(IceCream ice) {
		System.out.println(ice.getIce_name());
		int row = iceCreamMapper.delete(ice);
		System.out.println(row);
		
		return "/CRUD";
	}
	
	@GetMapping("/ice/select") 
	public void selectIce(Model model) {
		List<IceCream> iceList = iceCreamMapper.select();
		
		for (IceCream ice : iceList) {
			System.out.println(ice);
		}
		
		model.addAttribute("iceList", iceList);
		
	}
	
	
	//추가하기 페이지로 가는 매핑 url
	@RequestMapping(value = {"/CRUD"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void ice() {
		
	}
	
	//각 추가하기 a태그에 추가할 url
	@RequestMapping(value = {"/ice/insert"}, method = {
			RequestMethod.GET, 
			RequestMethod.POST,
			RequestMethod.DELETE})
	public void insert() {
		
	}
	
//	@RequestMapping(value = {"/ice/select"}, method = {
//			RequestMethod.GET, 
//			RequestMethod.POST,
//			RequestMethod.DELETE})
//	public void select() {
//		
//	}
	
	@RequestMapping(value = {"/ice/update"}, method = {
			RequestMethod.GET, 
			RequestMethod.POST,
			RequestMethod.DELETE})
	public void update() {
		
	}
	
	@RequestMapping(value = {"/ice/delete"}, method = {
			RequestMethod.GET, 
			RequestMethod.POST,
			RequestMethod.DELETE})
	public void delete() {
		
	}
	

}
