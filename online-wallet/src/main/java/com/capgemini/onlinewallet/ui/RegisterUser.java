package com.capgemini.onlinewallet.ui;

import com.capgemini.onlinewallet.dto.WalletUser;
import com.capgemini.onlinewallet.exception.NullValueException;
import com.capgemini.onlinewallet.service.UserDataValidation;

public class RegisterUser {
	private String phone,password,login,name;
	public RegisterUser() {
		WalletUser obj=new WalletUser();
		System.out.println("enter user deatils: ");
		System.out.println("Enter Name");
		java.util.Scanner sc=new java.util.Scanner(System.in);
		name=sc.nextLine();
		System.out.println("Enter the Login name");
		login=sc.next();
		System.out.println("Enter Password ");
		password=sc.next();
		System.out.println("Enter Phone Number");
		phone=sc.next();
		// TODO Auto-generated constructor stub
	}
	
    public Integer pushData()
    {
    	//tranfer data to userdatavalidation class
    	try {
    	boolean result=new UserDataValidation().checkData(name, password, login, phone);
    	//System.out.println("check pushData");
    	//System.out.println("result: "+result);
    	if(result==false)
    	{
    		throw new NullValueException("A value entered is not in acceptable format, please enter again");
    	}
    	}
    	catch(NullValueException e)
    	{
    		System.out.println(e.getMessage());
    		new RegisterUser().pushData();
    	}
    	return new UserDataValidation().putData(name, password, login, phone);
    }
}
