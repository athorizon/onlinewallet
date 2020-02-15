package com.capgemini.onlinewallet.service;

import com.capgemini.onlinewallet.dao.SaveRegisterUserData;
import com.capgemini.onlinewallet.dto.WalletUser;

public class UserDataValidation {

	public UserDataValidation() {
		// TODO Auto-generated constructor stub
	}
	public void takeDate(String name,String password,String login,String phone)
	{
		if(new SaveRegisterUserData().validateLoginName(login));
		{
			new SaveRegisterUserData().saveUserData(name, password, login, phone);
		}
	}

}
