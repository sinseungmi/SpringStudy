package com.kgitbank.service;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// �������� root-context�� ������Ʈ�μ� ����� ��

@Component
public class RockPaperScissors {
	
	String result;
	
	// ����, ����, �� �� �ϳ��� �Է� ������ ��/��/�� ����� ���ϵǴ� �޼��带 �ϳ� �ۼ�
	public String result(String userInput) {

		int comRandom = (int)(Math.random() * 3 + 1);
		
		int userInt = 0;
		
		switch (userInput) {
		case "����":
			userInt = 1;
			break;
		case "����":
			userInt = 2;
			break;
		case "��":
			userInt = 3;
			break;
		default:
			System.out.println("�߸� �Է���");
			break;
		}
		
		if(userInt == 0) {
			System.out.println("�� ����");
		}else if (userInt ==  comRandom) {
			result = "��";
		}else if ((userInt == 1 && comRandom == 3) || (userInt == 2 && comRandom == 1)
				|| (userInt == 3 && comRandom == 2)) {
			result = "��";
		} else {
		    result = "��";
		}	
			
		return result;
	}
	
	
	//JUnit �׽�Ʈ�� �޼��带 20ȸ �׽�Ʈ�ϰ� ���Ͽ� �޼��� ���� ����� ���� �α׸� ���ܺ�����
}






