package com.capgemini.onlinewallet.service;

import com.capgemini.onlinewallet.dao.Connection;
import com.capgemini.onlinewallet.exception.NegativeValueException;

public class AddAmountValidation {

	public AddAmountValidation() {
		// TODO Auto-generated constructor stub
	}
    public void addAmount(Integer userId,Double amount)
    {
    	try
    	
    	{
    		if(amount>0)
    		{
    			new Connection().addAmount(userId, amount);
    		}
    		else {throw new NegativeValueException("Please enter Valid amount");}
    	}
    	catch(NegativeValueException e)
    	{
    		System.out.println(e.getMessage());
    	}
    }
}
