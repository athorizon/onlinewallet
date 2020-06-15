package com.cg.onlinewallet.util;

import java.util.HashMap;


import com.cg.onlinewallet.dto.*;

public class Repositories {
	private static HashMap<Integer,WalletUser> walletUserTable=new HashMap<Integer,WalletUser>();
	private static HashMap<Integer,WalletTransaction> walletTransactionTable=new HashMap<Integer,WalletTransaction>();
	private static HashMap<Integer,WalletAccount> walletAccountTable=new HashMap<Integer,WalletAccount>();
	private static HashMap<Integer,Integer> userAccountTable=new HashMap<Integer,Integer>();
	
	static
	{   
		WalletUser w1=new WalletUser(11002,"Aarushi","Arushi123","1234567890","B_Arushi");
		WalletAccount a1=new WalletAccount(1002,5000.00,null);
		walletUserTable.put(11002, w1);
		walletAccountTable.put(1002, a1);
		userAccountTable.put(11002, 1002);
	}
	
	public static HashMap<Integer, WalletUser> getWalletUserTable() {
		return walletUserTable;
	}

	public static void setWalletUserTable(HashMap<Integer, WalletUser> walletUserTable) {
		Repositories.walletUserTable = walletUserTable;
	}

	public static HashMap<Integer, WalletTransaction> getWalletTransactionTable() {
		return walletTransactionTable;
	}

	public static void setWalletTransactionTable(HashMap<Integer, WalletTransaction> walletTransactionTable) {
		Repositories.walletTransactionTable = walletTransactionTable;
	}

	public static HashMap<Integer, WalletAccount> getWalletAccountTable() {
		return walletAccountTable;
	}

	public static void setWalletAccountTable(HashMap<Integer, WalletAccount> walletAccountTable) {
		Repositories.walletAccountTable = walletAccountTable;
	}

	public static HashMap<Integer, Integer> getUserAccountTable() {
		return userAccountTable;
	}

	public static void setUserAccountTable(HashMap<Integer, Integer> userAccountTable) {
		Repositories.userAccountTable = userAccountTable;
	}

	public Repositories() {
		
		// TODO Auto-generated constructor stub
	}

}
