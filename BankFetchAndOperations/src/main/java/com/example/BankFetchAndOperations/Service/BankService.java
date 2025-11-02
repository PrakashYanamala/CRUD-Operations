package com.example.BankFetchAndOperations.Service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import com.example.BankFetchAndOperations.Model.Bank;
import com.example.BankFetchAndOperations.Repository.BankRepository;

public interface BankService {
 
	
	public void dosave(Bank bank);  // save the account details

	
	
	public  boolean dologin(Bank bankdo) ; // Checking ac num and pin num are correct or not for details shows
		

		
		
	public    Bank fetchUsersData(Bank bk) ; // for details display



	public boolean WithdrawAmount(Bank bankw); // Checking ac num and pin num are correct or not for Withdraw


	boolean CheckAmount(Bank bankb);  // check the amount is sufficient or not


	public double FetchingAmount(Bank bankr); // return the remaining amount


	public String dosaveAc(Bank bankdb) ;



	public boolean DepoAmount(Bank bankdeposite);



	public boolean CheckAmounttodepo(Bank bankamount);


	public double Addamount(Bank banksave);

	public String dosaveAmount(Bank bank);



	public boolean transferA1account(Bank bankA);



	public boolean checkAmount(Bank bankca);



	public double DeductAmount(Bank bankr);



	public boolean DepotransferAmount(Bank bankdepositetrasfer);



	public double AddamountA2(Bank banksave);



	//public Bank getAccountDetails(String accountNum, String pinNum) throws AccountNotFoundException;



	



	


	



	
		
		
	
		
}
