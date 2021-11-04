package com.kgitbank.quiz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class MemberController {
	
	@Autowired
	ServletContext application;
//	@Autowired
//	HttpSession session;
	
	@RequestMapping(value={"/user/join"}, method= {RequestMethod.GET,RequestMethod.POST})
	public void input_page() {
		
	}
	
	@PostMapping("/user/memberinfo")
	public String getMemberInfo(MemberInfo member) {
		/*
		 * # ��� ����
		 * 	- �� ���
		 * 	- ������Ʈ ���� ���
		 * 	- ���� ���� ���
		 * 
		 * D:\Microservices\JAVA\spring-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Practice_SpringMVC\
		 *  > �� ��ο� ���� tmp0�̰� ��Ĺ�� ����! 
		 *  > webapp ���δ� ��Ĺ�� �����ϴ� �ڿ�
		 *  > ���� ��Ҷ� webapp �ؿ��ִ� �ֵ鸸 ����. 
		 * 
		 * �뺹 2.14 ���°� ������ �����Ҷ�!!
		 * 
		 * */
		
		String path = application.getRealPath("./") + "data/user/";
		
		if (member.nullExist()) {
			System.out.println("���� ����");
			log.error("ȸ�� ������ Null ���� ������.");
			return "/user/fail";
			// return "redirect:/";
		}
		
		File file = new File(String.format("%s%s.txt",path ,member.getId()));

		try (	
				FileOutputStream fout = new FileOutputStream(file);
	            ObjectOutputStream obj_out = new ObjectOutputStream(fout);
//				FileWriter fr = new FileWriter(file);				
				){
//			fr.append(String.format("%s\n%s\n%s\n%s\n%s\n%s", 
//					member.getId(),member.getPw(), member.getEmail(), member.getName(),
//					member.getAge(), member.getBirthday()));
			obj_out.writeObject(member);
		    log.info("������ ���������� �� ��");

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "/user/success";
	
	}
	
}
