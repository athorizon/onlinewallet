package com.capgemini.onlinewallet.service;

import com.capgemini.onlinewallet.dao.Connection;
import com.capgemini.onlinewallet.exception.NegativeValueException;

public class AddAmountValidation {
	void addAmount(Integer UserId,Double amount)
	{
		try
		{
		if(amount>0)
		{
			new Connection().addAmount(UserId,amount);
		}
		else
		{
			throw new NegativeValueException("Please enter valid amount");
		}
		}
		catch(NegativeValueException e)
		{
			System.out.println(e.getMessage());
		}
	}

}
