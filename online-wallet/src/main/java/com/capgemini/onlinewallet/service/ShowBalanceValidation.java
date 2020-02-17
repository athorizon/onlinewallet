package com.capgemini.onlinewallet.service;

import com.capgemini.onlinewallet.dao.Connection;

public class ShowBalanceValidation {

	public ShowBalanceValidation() {
		super();
		// TODO Auto-generated constructor stub
	}
	void showBalance(Integer UserId)
	{
		System.out.println(new Connection().showBalance(UserId));
	}
}
