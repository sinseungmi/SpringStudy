package com.kgitbank.model;

import org.apache.log4j.Logger;
import org.junit.Test;

import junit.framework.TestCase;

public class LombokTest extends TestCase {
	
	// 이 클래스의 로깅을 담당하는 로거를 생성한다  (LombokTest.class)얘랑 this.getClass()같음
	Logger log = Logger.getLogger(this.getClass());
	
	@Test
	public void test() {
		Employee emp = new Employee(10, "Smith", "ASMITH");
		
		log.fatal(emp);
		log.error(emp);
		log.warn(emp);
		log.info(emp);
		log.debug(emp);
		log.trace(emp);
		
		System.out.println(emp);
		assertEquals("Getter가 없는 것 같음", 0, emp.getDepartment_id());
	}


}
