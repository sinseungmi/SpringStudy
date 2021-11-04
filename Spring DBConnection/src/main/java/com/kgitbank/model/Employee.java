package com.kgitbank.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor //기본생성자가 있으면 알아서 해줌
@RequiredArgsConstructor
@Data
public class Employee {
	//디비랑 이름 완전 똑같아야함
	private Integer employee_id;
	private String 	first_name;
	@NonNull
	private String 	last_name;
	@NonNull
	private String 	email;
	private String	phone_number;
	@NonNull
	private Date 	hire_date;
	@NonNull
	private String 	job_id;
	private double	salary;
	private double 	commission_pct;
	private Integer manager_id;
	private Integer department_id;

}






