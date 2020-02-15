package com.capgemini.onlinewallet.ui;

import java.util.Scanner;

import com.capgemini.onlinewallet.dao.CheckData;
import com.capgemini.onlinewallet.dao.PushingData;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PushingData();
		System.out.println("If you want to register press 1, else press 2 and contibue to login ");
		int choice=new java.util.Scanner(System.in).nextInt();
		switch(choice)
		{
		case 1: //call registeruser class
			    new RegisterUser().pushData();
			    break;
			    
		case 2: //call menu class
		}
		
		new CheckData();

	}

}
