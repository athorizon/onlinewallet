package com.capgemini.onlinewallet.util;

import java.util.HashMap;

import com.capgemini.onlinewallet.dto.WalletTransactions;

public class WalletTransactionsRepository {
    static HashMap<Integer,WalletTransactions> walletTransactionsTable=new HashMap<Integer,WalletTransactions>();
	public static HashMap<Integer, WalletTransactions> getWalletTransactionsTable() {
		return walletTransactionsTable;
	}
	public static void setWalletTransactionsTable(HashMap<Integer, WalletTransactions> walletTransactionsTable) {
		WalletTransactionsRepository.walletTransactionsTable = walletTransactionsTable;
	}
	public WalletTransactionsRepository() {
		// TODO Auto-generated constructor stub
	}
    public void putData(WalletTransactions wt)
    {
    	walletTransactionsTable.put(wt.getTransactionID(), wt);
    }
    
}
