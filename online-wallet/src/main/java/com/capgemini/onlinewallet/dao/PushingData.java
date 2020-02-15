package com.capgemini.onlinewallet.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.capgemini.onlinewallet.dto.*;
import com.capgemini.onlinewallet.util.*;
public class PushingData {
    public PushingData(){
		// TODO Auto-generated method stub
	UserAccountRepository uar=new UserAccountRepository();
	WalletAccountRepository war=new WalletAccountRepository();
	WalletTransactionsRepository wtr=new WalletTransactionsRepository();
	WalletUserRepository wur=new WalletUserRepository();
	
	//System.out.println("populating user data");
	wur.putData(new WalletUser(111001,"Kunal Maheshwari","kunal123","9897446350","walletkunal"));
	wur.putData(new WalletUser(111002,"Arushi Bhardwaj","arushi123","123456789","walletarushi"));
	wur.putData(new WalletUser(111003,"Avinash Kaur","avi123","987654321","walletavi"));
	
	//System.out.println("populating accounts data");
	war.putData(new WalletAccount(1001,0.0,new ArrayList<Integer>()));
	war.putData(new WalletAccount(1002,0.0,new ArrayList<Integer>()));
	war.putData(new WalletAccount(1003,0.0,new ArrayList<Integer>()));
	
	HashMap<Integer,WalletUser> wu=wur.getWalletUserTable();
	HashMap<Integer,WalletAccount> wa=war.getWalletAccountTable();
	
	Set<Integer> keySet=wu.keySet();
	Set<Integer> keySet1=wa.keySet();
	Iterator<Integer> itwu=keySet.iterator();
	Iterator<Integer> itwa=keySet1.iterator();
	while(itwu.hasNext())
	{
		uar.putData(wu.get(itwu.next()), wa.get(itwa.next()));
		
	}
	
	/*HashMap<Integer,Integer> ua=uar.getUserAccountTable();
	Set<Integer> keyset=ua.keySet();
	Iterator<Integer> it=keyset.iterator();
	while(it.hasNext())
	{   
		System.out.println("account number is is: "+ua.get(it.next()));
	}*/
	System.out.println("data entered");
    }
}
