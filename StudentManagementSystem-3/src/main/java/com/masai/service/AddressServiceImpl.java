package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AddressException;
import com.masai.exception.StudentException;
import com.masai.model.Address;
import com.masai.model.Student;
import com.masai.repositry.AddressDao;
import com.masai.repositry.StudentDao;

@Service
public class AddressServiceImpl implements AddressService{

	
	@Autowired
	private AddressDao aDao;
	
	@Autowired
	private StudentDao sDao;
	
	
	@Override
	public String createAddressById(Address add, Integer Id) throws AddressException {

	    Optional<Student> opt = sDao.findById(Id);		   
	    if(opt.isEmpty()) {
	    	throw new StudentException("Address not found with this given ID" + Id);
	    }

	    opt.get().getAdds().add(add);
	    add.setStuds(opt.get());
	    
	    aDao.save(add);
	    
	    return "Address on the Student successfully...";
	}

	@Override
	public List<Address> getAllAddressByStudentId(Integer Id) throws AddressException {
		
		Optional<Student> opt = sDao.findById(Id);
		 
		 if(opt.isEmpty()) {
			 throw new StudentException("Student not found with this given ID " + Id);
		 }	
		 else
		 {
			 return opt.get().getAdds();
		 }
		
		
	}

	@Override
	public Address getAddressByAddressId(Integer stdId, Integer addId) throws AddressException {
		
		Optional<Student> opt =  sDao.findById(stdId);
		
		if(opt.isEmpty()) {
	    	 throw new StudentException("Student not found with this given ID " + stdId);
	     }
		  
		Optional<Address> add =  aDao.findById(addId);
		if(add.isEmpty()) {
			throw new AddressException("Address Not Found with this given ID" + addId);
		}
		
       return add.get();
	}


	@Override
	public String deleteAddressById(Integer stdId, Integer Id) throws AddressException {
		
		
		Optional<Student> opt =  sDao.findById(stdId);
		
	     if(opt.isEmpty()) {
	    	 throw new StudentException("Student not found with this given ID" + stdId);
	     }
		
		Optional<Address> add =   aDao.findById(Id);
		   if(add.isEmpty()) {
			   throw new AddressException("Address not found with this given ID" + Id);
		   }
		   
		   aDao.deleteById(Id);
		   
		   return "Address deleted successfully...";
	}

}
