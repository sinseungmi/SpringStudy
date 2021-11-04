package com.kgitbank.service;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 스프링의 root-context에 컴포넌트로서 등록할 것

@Component
public class RockPaperScissors {
	
	String result;
	
	// 가위, 바위, 보 중 하나를 입력 받으면 승/무/패 결과가 리턴되는 메서드를 하나 작성
	public String result(String userInput) {

		int comRandom = (int)(Math.random() * 3 + 1);
		
		int userInt = 0;
		
		switch (userInput) {
		case "가위":
			userInt = 1;
			break;
		case "바위":
			userInt = 2;
			break;
		case "보":
			userInt = 3;
			break;
		default:
			System.out.println("잘못 입력함");
			break;
		}
		
		if(userInt == 0) {
			System.out.println("값 없음");
		}else if (userInt ==  comRandom) {
			result = "무";
		}else if ((userInt == 1 && comRandom == 3) || (userInt == 2 && comRandom == 1)
				|| (userInt == 3 && comRandom == 2)) {
			result = "승";
		} else {
		    result = "패";
		}	
			
		return result;
	}
	
	
	//JUnit 테스트로 메서드를 20회 테스트하고 파일에 메서드 실행 결과에 대한 로그를 남겨보세요
}






