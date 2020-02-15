package com.capgemini.onlinewallet.ui;

import com.capgemini.onlinewallet.dto.WalletUser;
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
	
    public void pushData()
    {
    	//tranfer data to userdatavalidation class
    	new UserDataValidation().takeDate(name, password, login, phone);
    }
}
