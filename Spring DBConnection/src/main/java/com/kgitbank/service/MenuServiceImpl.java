package com.kgitbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgitbank.mapper.IceCreamMapper;
import com.kgitbank.model.IceCream;

import lombok.extern.log4j.Log4j;

//@Service  //@Service�� �ٲٸ� ServiceImpl�� ���Ƴ��� �� �ִ�

@Log4j
@Service 
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	IceCreamMapper ice_mapper;
	
	@Override
	public boolean addIce(IceCream ice) {
		log.info(ice_mapper);
		System.out.println("������ �̸��� �޴��� �ִ��� üũ��� �ڵ��Դϴ�. 50��");
		System.out.println("�޴� �̸� ���� üũ. 150��");
		System.out.println("�� �� üũ. 30��");
		
		return true;
		//return ice_mapper.create(ice) > 0;
	}

}
