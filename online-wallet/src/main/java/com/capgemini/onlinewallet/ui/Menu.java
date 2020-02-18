package com.capgemini.onlinewallet.ui;

import com.capgemini.onlinewallet.service.*;
import com.capgemini.onlinewallet.service.Transaction;

public class Menu {
    Integer userId;
    java.util.Scanner sc=new java.util.Scanner(System.in);
	public Menu(Integer uid) {
		// TODO Auto-generated constructor stub
    	userId=uid;
    	askInput();
    	
    	
	}
        void askInput()
        {   while(true) 
           {
        	System.out.println("The Tasks which you can perform. enter respective number");
        	System.out.println("1:  Show Current Balance");
        	System.out.println("2:  Add Money to Account");
        	System.out.println("3:  Transfer Money to another Account");
        	int input=sc.nextInt();
        	switch(input)
        	{
        	case 1: new ShowBalanceValidation().showBalance(userId);
        		    break;
        	case 2: askAmountDetails();
        		    break;
        	case 3: askTransactionDetails();
        	        break;
        	default:System.out.println("wrong choice");
        	        return;
        	}
           }
        }
        void askAmountDetails()
        {
        	System.out.println("enter Amount to tranfer in your account");
        	Double amount=sc.nextDouble();
        	new AddAmountValidation().addAmount(userId, amount);
        	
        }
        void askTransactionDetails()
        {
        	System.out.println("Enter Amount");
        	Double amount=sc.nextDouble();
        	System.out.println("enter the accountid of benefeciary");
        	Integer tid=sc.nextInt();
        	new Transaction().transactMoney(userId, amount, tid);
        }

}
