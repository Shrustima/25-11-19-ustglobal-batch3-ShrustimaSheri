package com.ustglobal.phoneapp.util;

import com.ustglobal.phoneapp.dao.PhoneDAO;
import com.ustglobal.phoneapp.dao.PhoneDAOImpl;

public class PhoneMain {

private PhoneMain() {
		
	}
	public static PhoneDAO getPhoneDAO() {
		return new PhoneDAOImpl();
	}
	
}
