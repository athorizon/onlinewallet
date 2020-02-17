package com.capgemini.onlinewallet.service;

import com.capgemini.onlinewallet.dao.SaveRegisterUserData;
import com.capgemini.onlinewallet.dto.WalletUser;

public class UserDataValidation {

	public UserDataValidation() {
		// TODO Auto-generated constructor stub
	}
	boolean checkNull(String check)
	{
		if(check==null) {return false;}
		else {
		return true;}
	}
	boolean checkNumber(String str)
	{
		if(str.length()!=10) {return false;}
		else
		{
		return true;}
	}
	public boolean  checkData(String name,String password,String login,String phone)
	{   
		if(checkNull(name)==false)
	    {
		   System.out.println("check name");
	       return false;
	    }
		else if(checkNull(password)==false)
	    {
	    	System.out.println("check pass");
	        return false;
	    }
		else if(checkNull(login)==false)
	    {
	    	System.out.println("check login null");
	    	return false;
	    }
		else if((checkNull(phone)==false)&&(checkNumber(phone)==false))
	    {
	    	System.out.println("check phone");
	    	return false;
	    }
		else if(new SaveRegisterUserData().validateLoginName(login)==false)
		{   System.out.println("check login");
			return false;
		}
		else {
		return true;}
	}
	public boolean putData(String name,String password,String login,String phone)
	{
		 return new SaveRegisterUserData().saveUserData(name, password, login, phone);
	}

}
