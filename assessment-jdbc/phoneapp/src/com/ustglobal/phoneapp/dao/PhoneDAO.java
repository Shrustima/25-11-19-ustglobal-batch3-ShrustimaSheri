package com.ustglobal.phoneapp.dao;

import java.util.List;

import com.ustglobal.phoneapp.dto.PhoneDB;

public interface PhoneDAO {

	public List<PhoneDB> getAllPhoneDb() ;
	public PhoneDB searchPhonedb(String name);
	public PhoneDB deletePhoneData(String name);	
	public PhoneDB updatePhoneData(String name);
}
