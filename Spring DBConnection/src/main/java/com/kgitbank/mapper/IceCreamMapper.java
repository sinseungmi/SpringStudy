package com.kgitbank.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.kgitbank.model.IceCream;

public interface IceCreamMapper {
	
	public int create(IceCream ice);
	
	public int update(@Param("ic")IceCream ice, @Param("change_na")String change_name);
                    //들어가는 타입이 2개 이상이면 @Param을 지정해줘야한다. 타입이 하나일때만 mybatice가 알아서 인식하고
	                //2개 이상은 인식 못해서 알려줘야함
	
	public int delete(IceCream ice);
	
	public List<IceCream> select();
}
