package com.kgitbank.quiz;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NonNull;

@Data
@Component
public class MemberInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String pw;
	private String email; 
	private String name;  //Integer해도 룸복이 알아서 int로 바꿔줌?
	private Integer age;  //Integer로 하는 이유는 null과 비교할 수 있으니까!
	//join에서 입력 받은 생년월일을 여기서 그냥 Date 타입으로 받게 된다면 
	//에러가 난다. 따라서 파라미터로 사용되는 변수에 @DateTimeFormat을 
	//적용해야 변환 가능!
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date birthday;
	
	public boolean nullExist() {
		//trim을하는 이유는 input 값으로 스페이스바가 들어갈수도 있다
		id = id.trim();
		pw = pw.trim();
		name = name.trim();
		email = email.trim();
		
		return id == null 	|| id.equals("") 	||
			   pw == null 	|| pw.equals("") 	||
			   name == null || name.equals("")	||
			   email == null|| email.equals("")	||
			   //숫자 값이 안들어오면 -1 반환!
			   age == -1 	|| age < 0			||
			   age == null	|| birthday == null;
	}


}








