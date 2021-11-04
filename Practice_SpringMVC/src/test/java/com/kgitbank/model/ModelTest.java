package com.kgitbank.model;


//패키지 위치는 다르고 이름이 같은 것은
//물리적으로 다른 패키지같지만 사실 같은 패키지. 그래서 임포트 없이 푸룻과 마켓 사용 가능
//원래 다른 패키지에 있는 클래스는 가져올라면 import해야함!!! 까묵지 좀 마셈


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class ModelTest {
	
	@Autowired
	private static Market market;
	
	@Test
	public void simpleTest() {
		int a = 10;
		int b = 20;
		
		assertEquals(30, a + b);
		System.out.println(market);

	}


}
