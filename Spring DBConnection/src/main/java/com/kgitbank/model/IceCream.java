package com.kgitbank.model;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class IceCream {
	
	private int ice_id;
	@NonNull
	private String ice_name;
	@NonNull
	private int price;

}
