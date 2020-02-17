package com.capgemini.onlinewallet.dao;

import com.capgemini.onlinewallet.dto.WalletAccount;
import com.capgemini.onlinewallet.dto.WalletUser;
import com.capgemini.onlinewallet.util.UserAccountRepository;
import com.capgemini.onlinewallet.util.WalletAccountRepository;
import com.capgemini.onlinewallet.util.WalletUserRepository;
import java.util.*;
public class Connection {

	public Connection() {}
		// TODO Auto-generated constructor stub
		public boolean checkLoginEntry(String str)
		{   
			HashMap<Integer,WalletUser> wut=new WalletUserRepository().getWalletUserTable();
			Set<Integer> keyset=wut.keySet();
			Iterator it=keyset.iterator();
			
			while(it.hasNext())
			{   System.out.println("in while loop");
				String check=wut.get(it.next()).getLoginName();
				System.out.println("check: "+check+" login: "+str );
				if(check.equalsIgnoreCase(str))
				{   
					return false;
				}
			}
			return true;
			
		}
		public Double showBalance(Integer UserId)
		{
			HashMap<Integer,Integer> wut=new UserAccountRepository().getUserAccountTable();
			Integer accountId=wut.get(UserId);
			HashMap<Integer,WalletAccount> wat=new WalletAccountRepository().getWalletAccountTable();
			Double balance=wat.get(accountId).getAccountBalance();
			return balance;
		}
        public void addAmount(Integer UserId,Double amount)
        {
        	HashMap<Integer,Integer>wut=new UserAccountRepository().getUserAccountTable();
        	Integer accountId=wut.get(UserId);
        	HashMap<Integer,WalletAccount>wat=new WalletAccountRepository().getWalletAccountTable();
        	Double balance=wat.get(accountId).getAccountBalance();
        	balance=balance+amount;
        	wat.get(accountId).setAccountBalance(balance);
        	System.out.println(wat.get(accountId).getAccountBalance());
        	
        }
}
