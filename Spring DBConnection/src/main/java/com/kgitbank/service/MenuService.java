package com.kgitbank.service;

import com.kgitbank.model.IceCream;

public interface MenuService {
	
	//����(service)�� ����(serviceImpl)���� ������ �Ǹ� ���� �κ��� ���ο� ������� �����ؾ� �� �� �����ϴ� �κи� 
	//�ս��� �ٲ� �� �ְ� �Ǳ� ������ Service��� interface�� ���� �� �ش� ������ 
	//�����ϴ� ServiceImpl class�� ����� �Ǵ� ���̴�!
	public boolean addIce(IceCream ice); //�̰� �󲮵���

}
