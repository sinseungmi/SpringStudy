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
	private String name;  //Integer�ص� �뺹�� �˾Ƽ� int�� �ٲ���?
	private Integer age;  //Integer�� �ϴ� ������ null�� ���� �� �����ϱ�!
	//join���� �Է� ���� ��������� ���⼭ �׳� Date Ÿ������ �ް� �ȴٸ� 
	//������ ����. ���� �Ķ���ͷ� ���Ǵ� ������ @DateTimeFormat�� 
	//�����ؾ� ��ȯ ����!
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date birthday;
	
	public boolean nullExist() {
		//trim���ϴ� ������ input ������ �����̽��ٰ� ������ �ִ�
		id = id.trim();
		pw = pw.trim();
		name = name.trim();
		email = email.trim();
		
		return id == null 	|| id.equals("") 	||
			   pw == null 	|| pw.equals("") 	||
			   name == null || name.equals("")	||
			   email == null|| email.equals("")	||
			   //���� ���� �ȵ����� -1 ��ȯ!
			   age == -1 	|| age < 0			||
			   age == null	|| birthday == null;
	}


}








