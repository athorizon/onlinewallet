package com.cg.onlinewallet.dto;

import java.util.List;

public class WalletAccount {
	Integer accountId;
	Double accountBalance;
	enum status{active,non_active}
	List<Integer> transactionHistory;
	public Integer getAccountID() {
		return accountId;
	}
	public void setAccountID(Integer accountId) {
		this.accountId = accountId;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public List<Integer> getTransactionHistory() {
		return transactionHistory;
	}
	public void setTransactionHistory(List<Integer> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
	public WalletAccount(Integer accountId, Double accountBalance, List<Integer> transactionHistory) {
		super();
		this.accountId = accountId;
		this.accountBalance = accountBalance;
		this.transactionHistory = transactionHistory;
	}
	public WalletAccount() {
		// TODO Auto-generated constructor stub
	}

}
