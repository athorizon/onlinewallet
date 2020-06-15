package com.cg.onlinewallet.dao;

import com.cg.onlinewallet.dto.WalletAccount;
import com.cg.onlinewallet.dto.WalletTransaction;
import com.cg.onlinewallet.dto.WalletUser;
import com.cg.onlinewallet.util.Repositories;
import java.util.HashMap;
public class OnlineWalletDaoImplementation implements OnlineWalletDao {
	Repositories repository;
	private static HashMap<Integer,WalletAccount> walletAccount;
	private static HashMap<Integer,WalletUser> walletUser;
	private static HashMap<Integer,WalletTransaction> walletTransaction;
	private static HashMap<Integer,Integer> userAccount;
	public OnlineWalletDaoImplementation() {
		super();
		repository = new Repositories();
	    walletAccount = Repositories.getWalletAccountTable();
	    walletUser = repository.getWalletUserTable();
	    walletTransaction = repository.getWalletTransactionTable();
	    userAccount = repository.getUserAccountTable();
		
	}

	public void addEntry(Integer userId, WalletUser user) {
		
		walletUser.put(userId, user);
		repository.setWalletUserTable(walletUser);
	}

	public void addEntry(Integer accountId, WalletAccount account) {
		// TODO Auto-generated method stub
		
		walletAccount.put(accountId, account);
		repository.setWalletAccountTable(walletAccount);
	}

	public void addEntry(Integer transactionId, WalletTransaction transaction) {
		// TODO Auto-generated method stub
		
		walletTransaction.put(transactionId, transaction);
		repository.setWalletTransactionTable(walletTransaction);
	}

	public void addEntry(Integer userId, Integer accountId) {
		// TODO Auto-generated method stub
		
		userAccount.put(userId, accountId);
		repository.setUserAccountTable(userAccount);
	}

	public WalletUser fetchUser(Integer userId) {
		// TODO Auto-generated method stub
		return walletUser.get(userId);
		
	}

	public WalletAccount fetchAccount(Integer userId) {
		// TODO Auto-generated method stub
		Integer accountId=userAccount.get(userId);
		return walletAccount.get(accountId);
	}

	public WalletTransaction fetchTransaction(Integer transactionId) {
		// TODO Auto-generated method stub
		return walletTransaction.get(transactionId); 
	}

	public void updateEntry(Integer userId, WalletUser user) {
		// TODO Auto-generated method stub
		walletUser.replace(userId, user);
	}

	public void updateEntry(Integer accountId, WalletAccount account) {
		// TODO Auto-generated method stub
		walletAccount.replace(accountId, account);
	}

	public void updateEntry(Integer transactionId, WalletTransaction transaction) {
		// TODO Auto-generated method stub
		walletTransaction.replace(transactionId, transaction);
	}

	public void updateEntry(Integer userId, Integer accountId) {
		// TODO Auto-generated method stub
		userAccount.replace(userId, accountId);
	}


}
