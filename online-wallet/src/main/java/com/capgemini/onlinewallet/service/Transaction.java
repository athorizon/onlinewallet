package com.capgemini.onlinewallet.service;

import com.capgemini.onlinewallet.dao.Connection;
import com.capgemini.onlinewallet.dao.TransactingAmount;

public class Transaction {
    
	
	boolean checkTID(Integer tID)
	{
		return new Connection().checkIDEntry(tID);
	}
	boolean checkAmount(Double amount)
	{
		if(amount<=0)
		{
			return false;
		}
		return true;
	}
	public Transaction() {}
		public void transactMoney(Integer userid, Double amount, Integer transactid)
		{
			if(checkTID(transactid)&&checkAmount(amount))
			{
				//call for dao
				new TransactingAmount().takeValues(userid, amount, transactid);
			}
		}
		// TODO Auto-generated constructor stub
	

}
