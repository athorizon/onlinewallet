package com.capgemini.onlinewallet.service;

import com.capgemini.onlinewallet.dao.Connection;

public class ShowBalanceValidation {

	public ShowBalanceValidation() {
		// TODO Auto-generated constructor stub
	}
	public Double showBalance(Integer userId)
	{
		return new Connection().showBalance(userId);
	}

}
