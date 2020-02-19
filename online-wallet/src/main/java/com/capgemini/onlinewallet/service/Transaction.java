package com.capgemini.onlinewallet.service;

import com.capgemini.onlinewallet.dao.Connection;
import com.capgemini.onlinewallet.dao.TransactingAmount;
import com.capgemini.onlinewallet.exception.NegativeValueException;
import com.capgemini.onlinewallet.exception.NullValueException;

public class Transaction {
    
	
	boolean checkTID(Integer tID)
	{
		return new Connection().checkIDEntry(tID);
	}
	public boolean checkAmount(Double amount)
	{
		if(amount<=0)
		{
			return false;
		}
		return true;
	}
	public Transaction() {}
		public void transactMoney(Integer userid, Double amount, Integer transactid)
		{   try {
			if(checkTID(transactid)&&checkAmount(amount))
			{
				//call for dao
				if(new Connection().checkBalance(userid, amount)) {
				new TransactingAmount().takeValues(userid, amount, transactid);}
				else
				{
					throw new NegativeValueException("the Amount entered cannot be transfered due to low balance");
				}
			}
			else
			{
				throw new NullValueException("the User does not exist");
			}
			}
		catch(NullValueException e)
		{   e.printStackTrace();System.out.println(e.getMessage());
			}
		
		catch(NegativeValueException e)
		{   e.printStackTrace();
			System.out.println(e.getMessage());
		}
}
		// TODO Auto-generated constructor stub
	

}
