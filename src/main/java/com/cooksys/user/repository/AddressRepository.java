package com.cooksys.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.user.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
