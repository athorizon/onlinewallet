package com.cg.onlinewallet.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import com.cg.onlinewallet.dao.*;
import com.cg.onlinewallet.exception.*;
import com.cg.onlinewallet.dto.*;

public class OnlineWalletServiceImplementation implements OnlineWalletService {
    OnlineWalletDao onlineWalletDaoObject;
	public OnlineWalletServiceImplementation() {
		// TODO Auto-generated constructor stub
		onlineWalletDaoObject= new OnlineWalletDaoImplementation();
	}

	public Integer registerUser(String userName,String password,String phoneNumber,String loginName,Double accountBalance) throws NullException, InvalidNameException ,ValidationException, InvalidPhoneNumberException,InvalidPasswordException{
		// TODO Auto-generated method stub
		checkName(userName);
		checkPhoneNumber(phoneNumber);
		checkPassword(password);
		Random random = new Random();
		Integer userId=new Integer(random.nextInt(100));
		Integer accountId=new Integer(random.nextInt(1000));
		
		WalletUser walletUser= new WalletUser(userId,userName,password,phoneNumber,loginName);
		WalletAccount walletAccount= new WalletAccount(accountId,accountBalance,null);
		
		onlineWalletDaoObject.addEntry(userId, walletUser);
		onlineWalletDaoObject.addEntry(accountId, walletAccount);
		onlineWalletDaoObject.addEntry(userId, accountId);
        return userId;
	}

	
	public boolean checkName(String userName) throws NullException,InvalidNameException
	{
		if(userName==null) 
			throw new NullException("Entered value cannot be NULL");
		boolean userNamePattern=Pattern.matches("[a-zA-Z]{5,9}",userName);
		 if(userNamePattern==false)
			throw new InvalidNameException("Entered username should contain alphabets only");
		else return true;		
	}
	
	
	public boolean checkPhoneNumber(String phoneNumber) throws ValidationException,NullException,InvalidPhoneNumberException
	{
		if(phoneNumber.length()!=10)
			throw new ValidationException("The phone Number should be of 10 digits");
		else if(phoneNumber==null)
			throw new NullException("Entered value cannot be NULL");
		boolean phoneNumberPattern=Pattern.matches("[0-9]{10}",phoneNumber);
		 if(phoneNumberPattern==false) 
			throw new InvalidPhoneNumberException("The phone number should only contain digits");
		else return true;
	}
	
	
	public boolean checkPassword(String password) throws ValidationException,NullException,InvalidPasswordException
	{
		if(password.length()<6)
			throw new ValidationException("The Password entered must be greater or equal to 6 characters");
		else if(password==null)
			throw new NullException("Entered value cannot be NULL");
		boolean passwordPattern=Pattern.matches("[a-zA-z0-9$&+,:;=?@#|'<>.-^*()%!]{6,12}",password);
		if(passwordPattern==false)
			throw new InvalidPasswordException("Entered password should be alphanumeric and must contain special characters");
		else return true;
	}
	
	
	public Double addMoney(Integer userId,Double amount) throws ValidationException, NegativeBalanceException {
		// TODO Auto-generated method stub
		checkAmount(amount);
		Double balance=onlineWalletDaoObject.fetchAccount(userId).getAccountBalance();
		WalletTransaction transaction=createTransaction("The amount was added succesfully into account",amount,balance);
		onlineWalletDaoObject.addEntry(transaction.getTransactionID(), transaction);
		updateEntry(userId,transaction.getTransactionID());
		return addBalance(userId,amount);

	}

	public Double showBalance(Integer userId) {
		// TODO Auto-generated method stub
        return onlineWalletDaoObject.fetchAccount(userId).getAccountBalance();
	}
    
	
	public boolean checkId(Integer userId) throws NullException
	{
		if(onlineWalletDaoObject.fetchUser(userId)==null||userId.getClass()!=Integer.class)
			throw new NullException("The User dosen't exist. Enter a valid userId");
		else return true;
	}
	public boolean checkAmount(double amount) throws ValidationException, NegativeBalanceException
	{
		if(amount==0)
			throw new ValidationException("the amount cannot be 0");
		else if(amount<0)
			throw new NegativeBalanceException("the entered amount is negative");
		else return true;
	}
	
	public boolean checkBalance(Integer userId, double amount) throws NegativeBalanceException
	{
		double balance=onlineWalletDaoObject.fetchAccount(userId).getAccountBalance();
		if(amount>balance)
			throw new NegativeBalanceException("Insufficient funds in account balance. please enter valid amount");
		else if(amount==balance)
			throw new NegativeBalanceException("The Balance cannot become 0 after transaction");
		else return true;
	}
	
	
	public Double addBalance(Integer userId,Double amount)
	{   //takes the userid and increments the amount passed as argument from the balance of the user's account
		
		double accountBalance=onlineWalletDaoObject.fetchAccount(userId).getAccountBalance();
		accountBalance+=amount;
		onlineWalletDaoObject.fetchAccount(userId).setAccountBalance(accountBalance);
		Integer accountId = onlineWalletDaoObject.fetchAccount(userId).getAccountID(); //fetching the accountId of the User's Account
		onlineWalletDaoObject.updateEntry(accountId, onlineWalletDaoObject.fetchAccount(userId));
		return onlineWalletDaoObject.fetchAccount(userId).getAccountBalance();
	}
	
	
	public Double deductBalance(Integer userId,Double amount)
	{   //takes the userid and deducts the amount passed as argument from the balance of the user's account
		double accountBalance=onlineWalletDaoObject.fetchAccount(userId).getAccountBalance();
		accountBalance-=amount;
		onlineWalletDaoObject.fetchAccount(userId).setAccountBalance(accountBalance);
		Integer accountId = onlineWalletDaoObject.fetchAccount(userId).getAccountID(); //fetching the accountId of the User's Account
		onlineWalletDaoObject.updateEntry(accountId, onlineWalletDaoObject.fetchAccount(userId));
		return onlineWalletDaoObject.fetchAccount(userId).getAccountBalance();
	}
	
	
	public WalletTransaction createTransaction(String description,Double amount,Double accountBalance)
	{   Random random= new Random();
	    Integer transactionId=new Integer(random.nextInt(10000));
	    WalletTransaction transaction= new WalletTransaction(transactionId,description,LocalDateTime.now(),amount,accountBalance);
	    
		return transaction;
	}
	
	public void updateEntry(Integer userId, Integer userTransactionId)
	{
		WalletAccount userAccount=onlineWalletDaoObject.fetchAccount(userId);
        List<Integer> transactionList=userAccount.getTransactionHistory();
        
        if(transactionList==null)
        {
        	transactionList=new ArrayList();
        }
        transactionList.add(userTransactionId);
        userAccount.setTransactionHistory(transactionList);
        onlineWalletDaoObject.updateEntry(userAccount.getAccountID(),userAccount);
	}
	
	
	public boolean transactMoney(Integer userId,Integer transferUserId,double amount) throws NullException,NegativeBalanceException, ValidationException{
		// TODO Auto-generated method stub

        checkId(transferUserId);
        checkAmount(amount);
        checkBalance(userId,amount);
        Double userBalance=addBalance(transferUserId,amount);
        Double transactBalance=deductBalance(userId,amount);

        WalletTransaction userTransaction=createTransaction("the Amount was tranfered to another account successfully",amount,userBalance);
        WalletTransaction transactTransaction=createTransaction("the Amount was recived from another account successfully",amount,transactBalance);

        Integer userTransactionId=userTransaction.getTransactionID();
        Integer transactTransactionId=transactTransaction.getTransactionID();
        
        updateEntry(userId,userTransactionId);
        updateEntry(transferUserId,transactTransactionId);

        onlineWalletDaoObject.addEntry(userTransactionId, userTransaction);
        onlineWalletDaoObject.addEntry(transactTransactionId, transactTransaction);
        return true;
	}

}
