package com.cg.onlinewallet.ui;
import java.util.Scanner;

import com.cg.onlinewallet.service.*;
public class OnlineWallet {
    static OnlineWalletService onlineWalletServiceObject;
    static Scanner scanner;
    static Integer userId;
	public OnlineWallet() {
		// TODO Auto-generated constructor stub
		onlineWalletServiceObject=new OnlineWalletServiceImplementation();
		scanner=new Scanner(System.in);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new OnlineWallet();
		System.out.println("enter choice to continue");
		System.out.println("1: to register as a new user");
		System.out.println("2: Login if already registered");
		try {
			int choice=scanner.nextInt();
		switch(choice)
		{
		case 1: userId=onlineWalletServiceObject.registerUser("Kunal123","kunal123","9897446350","athorizon",10000.00);
				System.out.println("Your User ID is: " + userId + " \nkeep a record of this");
				break;
		case 2: break;
		default :return;
		}}
		catch(Exception exception)
		{
			System.out.println(exception.getMessage());
		}
        while(true)
        {   try {
        	System.out.println("Enter the choice");
        	System.out.println("1: addmoney");
        	System.out.println("2: show balance");
        	System.out.println("3: transact");
        	Double balance;
        	int choice=scanner.nextInt();
        	switch(choice)
        	{
        	case 1: balance=onlineWalletServiceObject.addMoney(userId, 5000.00);
        	        System.out.println("the money was added succesfully \nthe balance is: " + balance);
        	        break;
        	case 2: balance=onlineWalletServiceObject.showBalance(userId);
        	        System.out.println("the balance is: " + balance);
        			break;
        	case 3: onlineWalletServiceObject.transactMoney(userId, 101, 5000.00);
        			break;
        	default: System.out.println("wrong choice DUMBASS!!");
        	         return;
        	}}
        catch(Exception ex)
        {
        	System.out.println(ex.getMessage());
        }
        }
		
	}

}
