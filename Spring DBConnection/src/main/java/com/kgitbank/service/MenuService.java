package com.kgitbank.service;

import com.kgitbank.model.IceCream;

public interface MenuService {
	
	//역할(service)과 구현(serviceImpl)으로 나누게 되면 역할 부분을 새로운 방식으로 구현해야 할 때 구현하는 부분만 
	//손쉽게 바꿀 수 있게 되기 때문에 Service라는 interface를 만든 후 해당 역할을 
	//구현하는 ServiceImpl class를 만들게 되는 것이다!
	public boolean addIce(IceCream ice); //이건 빈껍데기

}
