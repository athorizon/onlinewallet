package com.cg.onlinewallet.service;

import com.cg.onlinewallet.exception.*;

public interface OnlineWalletService {
	Integer registerUser(String userName,String password,String phoneNumber,String loginName,Double accountBalance)throws NullException, InvalidNameException ,ValidationException, InvalidPhoneNumberException,InvalidPasswordException;
	Double addMoney(Integer userId,Double amount) throws ValidationException, NegativeBalanceException;
	Double showBalance(Integer userId);
	boolean transactMoney(Integer userId,Integer tranferUserId,double amount) throws NullException,NegativeBalanceException,ValidationException;
	

}
