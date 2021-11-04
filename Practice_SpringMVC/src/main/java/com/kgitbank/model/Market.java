package com.kgitbank.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Market {
	
	private Fruit fruit;
	
	public Market() {}
	
	public Market(Fruit fruit) {
		this.fruit = fruit;
	}
	/*
	 * @Autowired�� private Fruit fruit���� �ٿ��� �ǰ�
	 * public Market(Fruit fruit) {
		this.fruit = fruit;} ���� �ٿ��� �ǰ�
	 * public void setFruit(Fruit fruit) {
		this.fruit = fruit;} ���� �ٿ��� �ȴ�
		
	 */
	
	@Autowired
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
	
	public Fruit getFruit() {
		return fruit;
	}

}
