package com.kgitbank.model;

import org.apache.log4j.Logger;
import org.junit.Test;

import junit.framework.TestCase;

public class LombokTest extends TestCase {
	
	// �� Ŭ������ �α��� ����ϴ� �ΰŸ� �����Ѵ�  (LombokTest.class)��� this.getClass()����
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
		assertEquals("Getter�� ���� �� ����", 0, emp.getDepartment_id());
	}


}
