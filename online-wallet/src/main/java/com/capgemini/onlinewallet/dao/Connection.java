package com.capgemini.onlinewallet.dao;

import com.capgemini.onlinewallet.dto.WalletUser;
import com.capgemini.onlinewallet.util.UserAccountRepository;
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
				if(check==str)
				{   System.out.println("check: "+check+" login: "+str );
					return false;
				}
			}
			return true;
			
		}

}
