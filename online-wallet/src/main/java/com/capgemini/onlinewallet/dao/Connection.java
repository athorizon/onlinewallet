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
			{   
				String check=wut.get(it.next()).getLoginName();
				
				if(check.equalsIgnoreCase(str))
				{   
					return false;
				}
			}
			return true;
			
		}
		public boolean checkIDEntry(Integer userID)
		{   
			HashMap<Integer,WalletUser> wut=new WalletUserRepository().getWalletUserTable();
			Set<Integer> keyset=wut.keySet();
			Iterator<Integer>it=keyset.iterator();
			while(it.hasNext())
			{   Integer uid=wut.get(it.next()).getUserID();
			    
				if(uid.equals(userID))
				{   
					return true;
				}
			}
			return false;
		}
		public Double showBalance(Integer userId)
		{
			HashMap<Integer,Integer> wut=new UserAccountRepository().getUserAccountTable();
			Integer accountId=wut.get(userId);
			HashMap<Integer,WalletAccount> wat=new WalletAccountRepository().getWalletAccountTable();
			return wat.get(accountId).getAccountBalance();
			
		}
        public Double addAmount(Integer userId,Double amount)
        {
        	HashMap<Integer,Integer>wut=new UserAccountRepository().getUserAccountTable();
        	Integer accountId=wut.get(userId);
        	HashMap<Integer,WalletAccount>wat=new WalletAccountRepository().getWalletAccountTable();
        	Double balance=wat.get(accountId).getAccountBalance();
        	balance=balance+amount;
        	wat.get(accountId).setAccountBalance(balance);
        	System.out.println(wat.get(accountId).getAccountBalance());
        	return wat.get(accountId).getAccountBalance();
        }
        public Double deductAmount(Integer userId,Double amount)
        {
        	HashMap<Integer,Integer>wut=new UserAccountRepository().getUserAccountTable();
        	Integer accountId=wut.get(userId);
        	HashMap<Integer,WalletAccount>wat=new WalletAccountRepository().getWalletAccountTable();
        	Double balance=wat.get(accountId).getAccountBalance();
        	balance=balance-amount;
        	wat.get(accountId).setAccountBalance(balance);
        	System.out.println(wat.get(accountId).getAccountBalance());
        	return wat.get(accountId).getAccountBalance();
        }
        public boolean checkBalance(Integer userid,Double amount)
        {
        	Double balance=showBalance(userid);
        	if(amount>=balance)
        	{
        		return false;
        	}
        	return true;
        }
}
