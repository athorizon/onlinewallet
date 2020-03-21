package com.cg.onlinewallet.service;

import com.cg.onlinewallet.exception.*;

public interface OnlineWalletService {
	Integer registerUser(String userName,String password,String phoneNumber,String loginName,Double accountBalance);
	Double addMoney(Integer userId,Double amount);
	Double showBalance(Integer userId);
	void transactMoney(Integer userId,Integer tranferUserId,double amount) throws NullException,NegativeBalanceException;
	

}
