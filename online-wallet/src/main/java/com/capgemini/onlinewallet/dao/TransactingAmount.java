package com.capgemini.onlinewallet.dao;
import java.util.HashMap;
import java.util.Random;
import java.time.LocalDateTime;
import com.capgemini.onlinewallet.util.*;
public class TransactingAmount {

	public TransactingAmount() {}
		// TODO Auto-generated constructor stub
		public void takeValues(Integer uid, Double amount,Integer tid)
		{
			//fetch the balance od uid and decrese it with amount
			//fetch the balance of tid and increment it with the amount
			//create transactions for deduction and addition with fetched balance for both
			UserAccountRepository uar=new UserAccountRepository();
			HashMap<Integer,Integer> uat=uar.getUserAccountTable();
			Integer accId=uat.get(uid);
			Integer tranId=uat.get(tid);
			WalletAccountRepository war=new WalletAccountRepository();
			Double uBalance=war.addBalance(uid,amount);
			Double tBalance=war.deductbalance(tid, amount);
			new CreatingTransaction(uid,new Random().nextInt(5000),"Money Dedcuted for Trandfering into another Account",LocalDateTime.now(),amount,uBalance);
			new CreatingTransaction(tid,new Random().nextInt(5000),"Money Recieved and added to the account",LocalDateTime.now(),amount,tBalance);
		}
	}


