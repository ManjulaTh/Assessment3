package com.cooksys.user.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.user.dto.AddressDto;
import com.cooksys.user.entity.Address;
import com.cooksys.user.mapper.AddressMapper;
import com.cooksys.user.repository.AddressRepository;

import com.cooksys.user.repository.AddressRepository;
import com.cooksys.user.service.AddressService;

@Service
public class AddressService {
	private AddressMapper aMapper;
	private AddressRepository aRepo;

	public List<Address> getAllAddress() {
		return aRepo.findAll();
		
	}

	public void create(Address address) {
		aRepo.save(address);
	}

	public AddressDto getAddress(Integer id) {
		
		return aMapper.toDto(aRepo.findById(id).get());
	}

	public void delete(Integer id) {
		aRepo.deleteById(id);
	}

}
