package com.capgemini.onlinewallet.service;

import com.capgemini.onlinewallet.dao.Connection;

public class ShowBalanceValidation {

	public ShowBalanceValidation() {
		// TODO Auto-generated constructor stub
	}
	public void showBalance(Integer userId)
	{
		System.out.println(new Connection().showBalance(userId));
	}

}
