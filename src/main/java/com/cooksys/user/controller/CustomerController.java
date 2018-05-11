package com.cooksys.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.user.dto.AddressDto;
import com.cooksys.user.dto.CustomerDto;
import com.cooksys.user.entity.Customer;
import com.cooksys.user.mapper.CustomerMapper;
import com.cooksys.user.service.CustomerService;

@RestController
@RequestMapping("user")
public class CustomerController {
	
	private CustomerService cService;
	private CustomerMapper cMapper;
	
	public CustomerController(CustomerService cService, CustomerMapper cMapper) {
		this.cService = cService;
		this.cMapper = cMapper;
	}
	
	@GetMapping
	public List<CustomerDto> getCustomer(){
		return cService.getAllCustomer().stream().map(cMapper::toDto).collect(Collectors.toList());
	}
	
	@GetMapping("{id}")
	public CustomerDto getCustomerById(@PathVariable Integer id) {
		return cService.getCustomer(id);
		
	}
	@PostMapping
	public void createCustomer(@RequestBody CustomerDto dto) {
		cService.save(cMapper.fromDto(dto));
	}
	
	@PutMapping("{id}")
	public void put(@PathVariable Integer id, @RequestBody CustomerDto dto ) {
		dto.setId(id);
		cService.put(cMapper.fromDto(dto));
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		cService.delete(id);
	}

}
