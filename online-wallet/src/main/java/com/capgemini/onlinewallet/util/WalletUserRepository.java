package com.capgemini.onlinewallet.util;

import java.util.HashMap;

import com.capgemini.onlinewallet.dto.WalletUser;

public class WalletUserRepository {
    static HashMap<Integer,WalletUser> walletUserTable=new HashMap<Integer,WalletUser>();
	public WalletUserRepository() {
		// TODO Auto-generated constructor stub
	}
	public static HashMap<Integer, WalletUser> getWalletUserTable() {
		return walletUserTable;
	}
	public static void setWalletUserTable(HashMap<Integer, WalletUser> walletUserTable) {
		WalletUserRepository.walletUserTable = walletUserTable;
	}
    public void putData(WalletUser wu)
    {
    	walletUserTable.put(wu.getUserID(), wu);
    }
}
