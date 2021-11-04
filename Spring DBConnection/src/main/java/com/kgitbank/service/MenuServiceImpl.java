package com.kgitbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgitbank.mapper.IceCreamMapper;
import com.kgitbank.model.IceCream;

import lombok.extern.log4j.Log4j;

//@Service  //@Service만 바꾸면 ServiceImpl를 갈아놓을 수 있다

@Log4j
@Service 
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	IceCreamMapper ice_mapper;
	
	@Override
	public boolean addIce(IceCream ice) {
		log.info(ice_mapper);
		System.out.println("동일한 이름의 메뉴가 있는지 체크라는 코드입니다. 50줄");
		System.out.println("메뉴 이름 형식 체크. 150줄");
		System.out.println("널 값 체크. 30줄");
		
		return true;
		//return ice_mapper.create(ice) > 0;
	}

}
