package com.kgitbank.model;


//��Ű�� ��ġ�� �ٸ��� �̸��� ���� ����
//���������� �ٸ� ��Ű�������� ��� ���� ��Ű��. �׷��� ����Ʈ ���� Ǫ��� ���� ��� ����
//���� �ٸ� ��Ű���� �ִ� Ŭ������ �����ö�� import�ؾ���!!! ��� �� ����


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
