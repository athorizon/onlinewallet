package com.capgemini.onlinewallet.dao;

import java.util.*;

import com.capgemini.onlinewallet.dto.WalletAccount;
import com.capgemini.onlinewallet.dto.WalletUser;
import com.capgemini.onlinewallet.util.UserAccountRepository;
import com.capgemini.onlinewallet.util.WalletAccountRepository;
import com.capgemini.onlinewallet.util.WalletUserRepository;

public class SaveRegisterUserData {
	WalletUserRepository wur=new WalletUserRepository();
	WalletAccountRepository war=new WalletAccountRepository();
	UserAccountRepository uar=new UserAccountRepository();
	public SaveRegisterUserData() {
		// TODO Auto-generated constructor stub
	}
    public boolean validateLoginName(String login)
    {   //returns true if the loginName is not present in the WalletUserTable else returns false
    	//System.out.println("validate login name");
    	
    	return new Connection().checkLoginEntry(login);
    }
    Integer getNewUserId()
    {   
    	
    	HashMap<Integer,WalletUser> wut=wur.getWalletUserTable();
    	Set<Integer> keyset=wut.keySet();
    	Iterator it=keyset.iterator();
    	Integer max=Integer.MIN_VALUE;
    	while(it.hasNext())
    	{   
    		WalletUser obj=wut.get(it.next());
    		if(max<obj.getUserID())
    		{
    			max=obj.getUserID();
    		}
    	}
    	return max+1;
    }
    Integer getNewAccountId()
    {   
    	
    	HashMap<Integer,WalletAccount> wat=war.getWalletAccountTable();
    	Set<Integer> keyset=wat.keySet();
    	Iterator it=keyset.iterator();
    	Integer max=Integer.MIN_VALUE;
    	while(it.hasNext())
    	{
    		WalletAccount obj=wat.get(it.next());
    		if(max<obj.getAccountID())
    		{
    			max=obj.getAccountID();
    		}
    	}
    	return max+1;
    }
    public Integer saveUserData(String name,String password,String login,String phone)
    {   
    	WalletUser user=new WalletUser(getNewUserId(),name,password,phone,login);
    	WalletAccount acc=new WalletAccount(getNewAccountId(),0.0,new ArrayList<Integer>());
    	wur.putData(user);
    	war.putData(acc);
    	uar.putData(user, acc);
    	return user.getUserID();
    }
}
