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
		 * # 경로 종류
		 * 	- 웹 경로
		 * 	- 프로젝트 내부 경로
		 * 	- 실제 파일 경로
		 * 
		 * D:\Microservices\JAVA\spring-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Practice_SpringMVC\
		 *  > 위 경로에 보면 tmp0이건 톰캣을 말함! 
		 *  > webapp 내부는 톰캣이 관리하는 자원
		 *  > 서버 운영할때 webapp 밑에있는 애들만 포함. 
		 * 
		 * 룸복 2.14 쓰는게 좋다함 플젝할때!!
		 * 
		 * */
		
		String path = application.getRealPath("./") + "data/user/";
		
		if (member.nullExist()) {
			System.out.println("값이 없음");
			log.error("회원 정보에 Null 값이 존재함.");
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
		    log.info("파일을 성공적으로 다 씀");

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "/user/success";
	
	}
	
}
