package com.capgemini.onlinewallet.util;

import java.util.HashMap;

import com.capgemini.onlinewallet.dto.WalletAccount;
import com.capgemini.onlinewallet.dto.WalletUser;

public class UserAccountRepository {
    static HashMap<Integer,Integer> userAccountTable=new HashMap<Integer,Integer>();
	public UserAccountRepository() {
		// TODO Auto-generated constructor stub
	}
	public static HashMap<Integer, Integer> getUserAccountTable() {
		return userAccountTable;
	}
	public static void setUserAccountTable(HashMap<Integer, Integer> userAccountTable) {
		UserAccountRepository.userAccountTable = userAccountTable;
	}
    public void putData(WalletUser wu,WalletAccount wa)
    {
    	userAccountTable.put(wu.getUserID(), wa.getAccountID());
    }
}
