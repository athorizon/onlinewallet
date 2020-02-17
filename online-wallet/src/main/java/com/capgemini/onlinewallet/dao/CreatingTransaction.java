package com.capgemini.onlinewallet.dao;

import java.time.LocalDateTime;

import com.capgemini.onlinewallet.dto.WalletAccount;
import com.capgemini.onlinewallet.dto.WalletTransactions;
import com.capgemini.onlinewallet.util.WalletTransactionsRepository;
import com.capgemini.onlinewallet.util.*;
import java.util.*;
public class CreatingTransaction {

	public CreatingTransaction(Integer ID,Integer tid,String des,LocalDateTime time,Double amt,Double bal)
	{   WalletTransactions wt=new WalletTransactions(tid,des,time,amt,bal);
		// TODO Auto-generated constructor stub
	    new WalletTransactionsRepository().putData(wt);//putting newly created transaction into table
	    HashMap<Integer,Integer> uat=new UserAccountRepository().getUserAccountTable();
	    Integer accountId=uat.get(ID);
	    HashMap<Integer,WalletAccount> wat=new WalletAccountRepository().getWalletAccountTable();
	    WalletAccount wa=wat.get(accountId);
	    List<Integer> list=wa.getTransactionHistory();
	    list.add(tid);
	    wa.setTransactionHistory(list);
	}
	

}
