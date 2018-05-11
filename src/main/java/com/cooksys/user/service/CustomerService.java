package com.cooksys.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.user.dto.AddressDto;
import com.cooksys.user.dto.CustomerDto;
import com.cooksys.user.entity.Customer;
import com.cooksys.user.mapper.CustomerMapper;
import com.cooksys.user.repository.AddressRepository;
import com.cooksys.user.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private CustomerMapper cMapper;
	private CustomerRepository cRepo;
	private AddressRepository aRepo;
	
	public CustomerService(CustomerMapper cMapper, CustomerRepository cRepo, AddressRepository aRepo) {
		this.cMapper = cMapper;
		this.cRepo = cRepo;
		this.aRepo = aRepo;
	}

	public CustomerService(CustomerMapper cMapper, CustomerRepository cRepo) {
		this.cMapper = cMapper;
		this.cRepo = cRepo;
	}
	
	public List<Customer> getAllCustomer() {
		return cRepo.findAll();
	}
	
	public void save(Customer customer) {
		
		cRepo.save(customer);
	}

	public CustomerDto getCustomer(Integer id) {
		
		return cMapper.toDto(cRepo.findById(id).get());
	}
	
	public void put(Customer customer) {
		
		cRepo.save(customer);
		
	}

	public void delete(Integer id) {
		cRepo.deleteById(id);
	}

	public AddressDto getAddressByCustomerId(Integer id) {
		return cRepo.findByCustomerId(id);
	}
}
