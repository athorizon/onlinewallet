package com.capgemini.onlinewallet.dao;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import com.capgemini.onlinewallet.dto.*;
import com.capgemini.onlinewallet.util.*;

public class DisplayData {

	public DisplayData() {
		System.out.println("Displaying wallet user data");
		HashMap<Integer, WalletUser> wut=new WalletUserRepository().getWalletUserTable();
		Set<Integer> keyset=wut.keySet();
		Iterator<Integer> it=keyset.iterator();
		while(it.hasNext())
		{   WalletUser o=wut.get(it.next());
			System.out.println("User Name: "+o.getUserName()+" UserId: "+o.getUserID()+" Phone Number: "+o.getPhoneNumber()+" Login Name: "+o.getLoginName());
		}
		// TODO Auto-generated constructor stub
		
		
		System.out.println("Displaying wallet account data");
		HashMap<Integer,WalletAccount> wat=new WalletAccountRepository().getWalletAccountTable();
		Set<Integer> keyset1=wat.keySet();
		Iterator<Integer> it1=keyset1.iterator();
		while(it1.hasNext())
		{   //System.out.println("here in while loop");
			WalletAccount ob=wat.get(it1.next());
			System.out.println("account id: "+ob.getAccountID()+" balance: "+ob.getAccountBalance()+" transactions "+ob.getTransactionHistory());
		}
		
		System.out.println("displaying user account data");
		HashMap<Integer,Integer> uat=new UserAccountRepository().getUserAccountTable();
		Set<Integer> keyset2=uat.keySet();
		Iterator<Integer> it3=keyset2.iterator();
		while(it3.hasNext())
		{
			System.out.println(uat.get(it3.next()));
		}
		
	}
    
}
