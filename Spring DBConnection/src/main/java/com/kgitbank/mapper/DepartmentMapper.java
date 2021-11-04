package com.kgitbank.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kgitbank.model.Departments;

public interface DepartmentMapper {
	
	@Select("SELECT * FROM departments")
	public List<Departments> getDepList();
	

}
