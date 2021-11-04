package com.kgitbank.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.kgitbank.model.IceCream;

public interface IceCreamMapper {
	
	public int create(IceCream ice);
	
	public int update(@Param("ic")IceCream ice, @Param("change_na")String change_name);
                    //���� Ÿ���� 2�� �̻��̸� @Param�� ����������Ѵ�. Ÿ���� �ϳ��϶��� mybatice�� �˾Ƽ� �ν��ϰ�
	                //2�� �̻��� �ν� ���ؼ� �˷������
	
	public int delete(IceCream ice);
	
	public List<IceCream> select();
}
