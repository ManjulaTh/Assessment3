package com.cooksys.user.mapper;

import org.mapstruct.Mapper;

import com.cooksys.user.dto.CustomerDto;
import com.cooksys.user.entity.Customer;

@Mapper(componentModel="spring")
public interface CustomerMapper {
	
	Customer fromDto (CustomerDto cDto);
	
	CustomerDto toDto (Customer customer);

}
