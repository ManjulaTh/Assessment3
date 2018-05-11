package com.cooksys.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.user.dto.AddressDto;
import com.cooksys.user.dto.CustomerDto;
import com.cooksys.user.entity.Address;
import com.cooksys.user.mapper.AddressMapper;
import com.cooksys.user.service.AddressService;


@RestController
@RequestMapping("address") 
public class AddressController {
	
	private AddressService aService;
	private AddressMapper aMapper;
	
	public AddressController(AddressService aService, AddressMapper aMapper) {
		this.aService = aService;
		this.aMapper = aMapper;
	}
	
	
	@GetMapping
	public List<AddressDto> getAddress(){
		return aService.getAllAddress().stream().map(aMapper::toDto).collect(Collectors.toList());
	
	}
	
	@GetMapping("{id}")
	public AddressDto getAddressById(@PathVariable Integer id) {
		return aService.getAddress(id);
		
	}
		
	
	@PostMapping
	public void createAddress(@RequestParam AddressDto dto) {
		aService.create(aMapper.fromDto(dto));
	}

	@PutMapping("{id}")
	public void put(@PathVariable Integer id, @RequestBody AddressDto dto ) {
		dto.setId(id);
		aService.create(aMapper.fromDto(dto));
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		aService.delete(id);
	}
	
	
}
