package com.capgemini.onlinewallet.ui;

import java.util.Scanner;

import com.capgemini.onlinewallet.dao.DisplayData;
import com.capgemini.onlinewallet.dao.PushingData;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PushingData();
		System.out.println("If you want to register press 1, else press 2 and continue to login ");
		int choice=new java.util.Scanner(System.in).nextInt();
		Integer userId=new Integer(0);
		switch(choice)
		{
		case 1: 
			    userId=new RegisterUser().pushData();
			    break;
		case 2: //call to login class
		}
		new Menu(userId);
		//new DisplayData();

	}

}
