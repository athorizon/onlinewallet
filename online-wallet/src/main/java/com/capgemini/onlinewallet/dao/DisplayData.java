package com.capgemini.onlinewallet.dao;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import com.capgemini.onlinewallet.dto.WalletUser;
import com.capgemini.onlinewallet.util.WalletUserRepository;

public class DisplayData {

	public DisplayData() {
		HashMap<Integer, WalletUser> wut=new WalletUserRepository().getWalletUserTable();
		Set<Integer> keyset=wut.keySet();
		Iterator<Integer> it=keyset.iterator();
		while(it.hasNext())
		{   WalletUser o=wut.get(it.next());
			System.out.println("User Name: "+o.getUserName()+" UserId: "+o.getUserID()+" Phone Number: "+o.getPhoneNumber()+" Login Name: "+o.getLoginName());
		}
		// TODO Auto-generated constructor stub
	}
    
}
