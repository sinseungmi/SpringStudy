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
	 * @Autowired은 private Fruit fruit여따 붙여도 되고
	 * public Market(Fruit fruit) {
		this.fruit = fruit;} 여따 붙여도 되고
	 * public void setFruit(Fruit fruit) {
		this.fruit = fruit;} 여따 붙여도 된다
		
	 */
	
	@Autowired
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
	
	public Fruit getFruit() {
		return fruit;
	}

}
