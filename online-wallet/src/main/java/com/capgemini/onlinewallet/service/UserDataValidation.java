package com.capgemini.onlinewallet.service;

import com.capgemini.onlinewallet.dao.SaveRegisterUserData;
import com.capgemini.onlinewallet.dto.WalletUser;
import com.capgemini.onlinewallet.exception.NullValueException;
import com.capgemini.onlinewallet.exception.ValidationException;

public class UserDataValidation {

	public UserDataValidation() {
		// TODO Auto-generated constructor stub
	}
	public boolean checkNull(String check) throws NullValueException
	{
		if(check==null) {throw new NullValueException("Entered Value Cannot be Null");}
		return true;
		
	}
	public boolean checkNumber(String str) throws ValidationException
	{
		if(str.length()!=10) {throw new ValidationException("The Number entered must be of in correct format");}
		return true;
		
	}
	public boolean checkPassword(String password) throws ValidationException
	{
		if(password.length()<6) {throw new ValidationException("The PassWord entered must be greater or equal to 6 chracters");}
		return true;
	
	}
	public boolean checkData(String name,String password,String login,String phone) 
	{   try {
		checkNull(name);
		checkNull(password);
		checkPassword(password);
		checkNull(phone);
		checkNumber(phone);
		if(new SaveRegisterUserData().validateLoginName(login)==false)
		{   throw new ValidationException("The Login id already exist");
			
		}
	}
	catch(Exception e)
	{
		
		System.out.println(e.getMessage());
		return false;
	}
		return true;
	}
	public Integer putData(String name,String password,String login,String phone)
	{
		 return new SaveRegisterUserData().saveUserData(name, password, login, phone);
	}

}
