package com.kgitbank.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kgitbank.model.Employee;

//연습 : Departments 테이블도 똑같은 방식으로 꺼내보세요
public interface EmployeeMapper {
	
	@Select("SELECT * FROM employees") //이게 리절트셋! 이걸 해주는게 마이바티스!
	public List<Employee> getEmpList();  //이것만 가지고 메서드를 만들어줌.
	
	//복잡한 쿼리문은 어노테이션 대신 xml로 연결!
	public List<Employee> getEmpList2();
	
	public Employee getEmployee(int id);
	
	public int create(Employee e);
	
	
}
