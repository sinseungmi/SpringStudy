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
	
	@PostMapping("/createIce") //���̽�ũ�� db ���� �߰�!
	public String createIce(IceCream ice) {
		
		//���� ���ο� �޴��� �߰��� �� �ؾ��� �۾����� ó���ؾ��Ѵ�. (����Ͻ� ����)
		// ex) ������ �̸��� �޴��� �ִ��� üũ, �޴� �̸��� ���Ŀ� �´��� üũ, ���� ����� �Դ��� üũ
		//����Ͻ� ������ ������ ������ ����! �׷��� ��Ʈ�ѷ��� ���ӽ�Ű�� �ȵȴ�
		//��Ʈ�ѷ������� �����͸� ��Ʈ����Ʈ�� �ư� ���� �������� �ȳ��ϴ� �۾��� �ϴ� ���� �ٶ����ϴ�
		ice_service.addIce(ice); //iceCreamMapper.create(ic)�̰Ÿ� ����ȭ ���Ѽ�!
		
		//int row = iceCreamMapper.create(ic);
		//System.out.println(row);
		
		return "/CRUD";
		
	}
	
	@PostMapping("/updateIce")
	public String updateIce(IceCream ic, @RequestParam("change_name") String change_name) {
		System.out.println(ic.getIce_name()); //model��ü ������� �Ķ���� name�� ���ƾ��ϴ� ����!
		System.out.println(ic.getPrice());    //�Ű������� IceCream ic �̷��� ��ü�� �޾��� �� �������� 
		                                      //model��ü ������� �Ķ���� name�� ��ġ�ϴ� �ֵ�� ¦�� �����ش�!
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
	
	
	//�߰��ϱ� �������� ���� ���� url
	@RequestMapping(value = {"/CRUD"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void ice() {
		
	}
	
	//�� �߰��ϱ� a�±׿� �߰��� url
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
