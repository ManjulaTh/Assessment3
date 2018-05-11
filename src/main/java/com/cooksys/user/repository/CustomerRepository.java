package com.cooksys.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.user.dto.AddressDto;
import com.cooksys.user.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
	
	
	

}
