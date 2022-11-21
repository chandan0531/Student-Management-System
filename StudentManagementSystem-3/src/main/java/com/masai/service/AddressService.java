package com.masai.service;

import java.util.List;

import com.masai.exception.AddressException;
import com.masai.model.Address;

public interface AddressService {

	
	
	public String createAddressById(Address add,Integer Id) throws AddressException;
	
	public List<Address> getAllAddressByStudentId(Integer Id) throws AddressException;
	
	public Address getAddressByAddressId(Integer stdId ,Integer addId) throws AddressException;
	
    public String deleteAddressById(Integer stdId ,Integer Id) throws AddressException;
}
