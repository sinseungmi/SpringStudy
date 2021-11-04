package com.kgitbank.service;

import org.springframework.stereotype.Service;

import com.kgitbank.model.IceCream;

//@Service
public class MenuServiceImpl2 implements MenuService{

	//이름은 같게하고 내용만 살짝 다르게 하고싶을 경우 이렇게 2번째 서비스를
	//만들어서 사용! @Service 클래스만 바꿔주면 됨!
	
	@Override
	public boolean addIce(IceCream ice) {
		return false;
	}

}
