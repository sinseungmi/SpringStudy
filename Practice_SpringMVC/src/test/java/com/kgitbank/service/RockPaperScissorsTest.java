package com.kgitbank.service;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.log4j.Log4j;

@Log4j  //Logger.getLogger하는 대신 어노테이션을 설정해서 할 수 있다
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class RockPaperScissorsTest {
	
	@Autowired
	RockPaperScissors RPS;
	
	//Logger log = Logger.getLogger(this.getClass());

	@Test
	public void test() {
		
		int num = 0;
		while (num++ < 20) {
			log.info(RPS.result("가위"));
			
		}
		
	}

}
