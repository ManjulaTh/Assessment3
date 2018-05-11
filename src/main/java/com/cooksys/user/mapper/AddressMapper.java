package com.cooksys.user.mapper;

import org.mapstruct.Mapper;

import com.cooksys.user.dto.AddressDto;
import com.cooksys.user.entity.Address;


@Mapper(componentModel="spring")
public interface AddressMapper {
	Address fromDto(AddressDto dto);
	AddressDto toDto(Address address);	
	

}
