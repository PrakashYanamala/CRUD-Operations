package com.example.BankFetchAndOperations.ServiceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.BankFetchAndOperations.Model.Bank;
import com.example.BankFetchAndOperations.Repository.BankRepository;
import com.example.BankFetchAndOperations.Service.BankService;


@Service
public class BankServiceImpl implements BankService {

	@Autowired
	BankRepository rb;

	/*
	 * @Autowired Bank bb;
	 */

	@Override
	public void dosave(Bank bank) {
		rb.save(bank);

	}

	public boolean dologin(Bank bankdo) {

		/*
		 * Optional<Bank> bankDB = rb.findByAccountNumAndPinNum(bankdo.getAccountNum(),
		 * bankdo.getPinNum()); rb.findAll(); // If a match is found, return the Bank
		 * object, else return null return bankDB.orElse(null);
		 */

		List<Bank> bankk = rb.findAll(); // To check ac num and pin are correct or not

		for (Iterator<Bank> itr = bankk.iterator(); itr.hasNext();) {
			Bank bkDB = itr.next();

			if (bankdo.getAccountNum() != 0 && bankdo.getPinNum() != 0 && bkDB.getAccountNum() != 0
					&& bkDB.getPinNum() != 0) {
				if (bankdo.getAccountNum() == bkDB.getAccountNum() && bankdo.getPinNum() == bkDB.getPinNum()) {
					return true;
				}
			}

		}

		return false;
	}

	

	public Bank fetchUsersData(Bank bk) {

		
		System.out.println("Entered Ac num: " + bk.getAccountNum());
	    System.out.println("Entered Pin num: " + bk.getPinNum());

	    Optional<Bank> optionalBank = rb.findByAccountNumAndPinNum(bk.getAccountNum(), bk.getPinNum());

	    if (optionalBank.isPresent()) {
	        Bank bkDB = optionalBank.get();
	        
	        

	        //  Debug print
	        System.out.println("-----Your Account Details are---------");
	        System.out.println("Customer name = " + bkDB.getCustomerName());
	        System.out.println("Account num   = " + bkDB.getAccountNum());
	        System.out.println("Bank Balance  = " + bkDB.getBalance());
	        System.out.println("Pin num       = " + bkDB.getPinNum());
	        System.out.println("Bank name     = " + bkDB.getBankName());

	        //  Return only this one matched account
	        return bkDB;
	    }

	    return null; // No match found
			// return false;
	}

	
	
	

	// WITHDRAWAL PROCESS
	@Override
	public boolean WithdrawAmount(Bank bankw) {
		System.out.println("Entered Ac num: " + bankw.getAccountNum());
		System.out.println("Entered PIn num: " + bankw.getPinNum());

		List<Bank> bankk = rb.findAll(); // To check ac num and pin are correct or not

		for (Iterator<Bank> itr = bankk.iterator(); itr.hasNext();) {
			Bank bkDB = itr.next();

			if (bankw.getAccountNum() != 0 && bankw.getPinNum() != 0 && bkDB.getAccountNum() != 0
					&& bkDB.getPinNum() != 0) {
				if (bankw.getAccountNum() == bkDB.getAccountNum() && bankw.getPinNum() == bkDB.getPinNum()) {
					return true;
				}
			}

		}

		return false;
	}

	@Override
//	@GetMapping
	public boolean CheckAmount(Bank bankb) {

		List<Bank> bankc = rb.findAll();

		System.out.println("Entered Ac num: " + bankb.getAccountNum());
		System.out.println("Entered PIn num: " + bankb.getPinNum());

		for (Iterator<Bank> itr = bankc.iterator(); itr.hasNext();) {
			Bank bankDB = itr.next();

			if (bankb.getAccountNum() == bankDB.getAccountNum() && bankb.getPinNum() == bankDB.getPinNum()
					&& bankb.getBalance() != 0 && bankDB.getBalance() != 0) {

				System.out.println("Balance from DB = " + bankDB.getBalance());

				if (bankb.getBalance() <= bankDB.getBalance()) {
					return true;
				}
			}
		}
		// }
		return false;
	}

	@Override
	public double FetchingAmount(Bank bankr) {
		List<Bank> bankd = rb.findAll(); // Fetch all bank records

		double amount = bankr.getBalance(); // Get the entered withdrawal amount
		System.out.println("Entered amount = " + amount);

		for (Bank bankDB : bankd) {
			// Match account number, pin number, and check both balances are non-zero
			if (bankr.getAccountNum() == bankDB.getAccountNum() && bankr.getPinNum() == bankDB.getPinNum()
					&& bankr.getBalance() != 0 && bankDB.getBalance() != 0) {

				System.out.println("Balance from DB = " + bankDB.getBalance());
				System.out.println("Customer Name from DB = " + bankDB.getCustomerName());
				System.out.println("Bank Name from DB = " + bankDB.getBankName());

				// String CusName = bankDB.getCustomerName();
				// String BankName = bankDB.getBankName();

				double balanceDB = bankDB.getBalance(); // Get balance from DB

				if (bankDB.getCustomerName() != null && bankDB.getBankName() != null) {
					// check entered amount is valid and not greater than balance
					if (amount != 0 && amount <= balanceDB) {
						double rembalance = balanceDB - amount; // Calculate remaining balance
						System.out.println("Remaining balance after withdrawal = " + rembalance);

						// Only update the balance, do not change customer name or bank name
						bankDB.setBalance(rembalance); // Update balance only
						// bankDB.setCustomerName(CusName);
						// bankDB.setBankName(BankName);
						// System.out.println("Customer name = "+CusName);

						// Save the updated record back to the database
						rb.save(bankDB);

						return rembalance; // Return the remaining balance after withdrawal
					}
				}
			}
		}

		return -1; // If no valid transaction happened, return -1
	}

	@Override
	public String dosaveAc(Bank bankdb) {
		// rb.save(bankdb);

		System.out.println("Balance  saved successfully for the account :: " + bankdb.getAccountNum());
		rb.save(bankdb);

		return "Account saved successfully: ";

	}

	// DEPOSIT PROCESS

	@Override
	public boolean DepoAmount(Bank bankdeposite) {

		List<Bank> bankk = rb.findAll(); // To check ac num and pin are correct or not

		for (Iterator<Bank> itr = bankk.iterator(); itr.hasNext();) {
			Bank bkDB = itr.next();

			if (bankdeposite.getAccountNum() != 0 && bankdeposite.getPinNum() != 0 && bkDB.getAccountNum() != 0
					&& bkDB.getPinNum() != 0) {
				if (bankdeposite.getAccountNum() == bkDB.getAccountNum()
						&& bankdeposite.getPinNum() == bkDB.getPinNum()) {
					return true;
				}
			}

		}

		return false;

	}

	@Override
	public boolean CheckAmounttodepo(Bank bankamount) {
		List<Bank> bankc = rb.findAll();

		// System.out.println("Entered Ac num: " + bankb.getAccountNum());
		// System.out.println("Entered PIn num: " + bankb.getPinNum());

		for (Iterator<Bank> itr = bankc.iterator(); itr.hasNext();) {
			Bank bankDB = itr.next();

			double entamount = bankamount.getBalance();

			if (bankamount.getAccountNum() == bankDB.getAccountNum() && bankamount.getPinNum() == bankDB.getPinNum()
					&& bankamount.getBalance() != 0 && bankDB.getBalance() != 0) {

				double balanceDB = bankDB.getBalance();
				System.out.println("DB Balance for deposit  = " + balanceDB);
				if (entamount > 0) {

					return true;
				}
			}
		}
		// }
		return false;
	}

	@Override
	public double Addamount(Bank banksave) {

		List<Bank> bankd = rb.findAll(); // Fetch all bank records

		double amount = banksave.getBalance(); // Get the entered withdrawal amount
		System.out.println("Entered amount = " + amount);

		for (Bank bankDB : bankd) {
			// Match account number, pin number, and check both balances are non-zero
			if (banksave.getAccountNum() == bankDB.getAccountNum() && banksave.getPinNum() == bankDB.getPinNum()
					&& banksave.getBalance() != 0 && bankDB.getBalance() != 0) {

				System.out.println("Balance from DB from deposite section = " + bankDB.getBalance());
				System.out.println("Customer Name from DB from deposite section = " + bankDB.getCustomerName());
				System.out.println("Bank Name from DB  from deposite section= " + bankDB.getBankName());

				double balanceDB = bankDB.getBalance(); // Get balance from DB

				if (bankDB.getCustomerName() != null && bankDB.getBankName() != null) {
					// check entered amount is valid and not greater than balance
					if (amount != 0) {
						double totalbal = balanceDB + amount; // Calculate remaining balance

						// Only update the balance, do not change customer name or bank name
						bankDB.setBalance(totalbal); // Update balance only

						// Save the updated record back to the database
						rb.save(bankDB);

						return totalbal; // Return the remaining balance after withdrawal
					}
				}
			}
		}
		return amount;

	}

	@Override
	public String dosaveAmount(Bank bank) {
		rb.save(bank);

		return "Amount added to account successfully";
	}

	
	
	//transfer operations
	@Override
	public boolean transferA1account(Bank bankt) {
		
		List<Bank> bankk = rb.findAll(); // To check ac num and pin are correct or not

		for (Iterator<Bank> itr = bankk.iterator(); itr.hasNext();) {
			Bank bkDB = itr.next();

			if (bankt.getAccountNum() != 0 && bankt.getPinNum() != 0 && bkDB.getAccountNum() != 0
					&& bkDB.getPinNum() != 0) {
				if (bankt.getAccountNum() == bkDB.getAccountNum() && bankt.getPinNum() == bkDB.getPinNum()) {
					return true;
				}
			}

		}

		
		return false;
	}

	
	
	// check amount to transfer
	@Override
	public boolean checkAmount(Bank bankca) {
		
		List<Bank> bankc = rb.findAll();

		System.out.println("Entered Ac num: " + bankca.getAccountNum());
		System.out.println("Entered PIn num: " + bankca.getPinNum());

		for (Iterator<Bank> itr = bankc.iterator(); itr.hasNext();) {
			Bank bankDB = itr.next();

			if (bankca.getAccountNum() == bankDB.getAccountNum() && bankca.getPinNum() == bankDB.getPinNum()
					&& bankca.getBalance() != 0 && bankDB.getBalance() != 0) {

				System.out.println("Balance from DB = " + bankDB.getBalance());

				if (bankca.getBalance() <= bankDB.getBalance()) {
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public double DeductAmount(Bank bankr) {
		
		List<Bank> bankd = rb.findAll(); // Fetch all bank records

		double amount = bankr.getBalance(); // Get the entered withdrawal amount
		System.out.println("Entered amount = " + amount);

		for (Bank bankDB : bankd) {
			// Match account number, pin number, and check both balances are non-zero
			if (bankr.getAccountNum() == bankDB.getAccountNum() && bankr.getPinNum() == bankDB.getPinNum()
					&& bankr.getBalance() != 0 && bankDB.getBalance() != 0) {

				System.out.println("Balance from DB = " + bankDB.getBalance());
				System.out.println("Customer Name from DB = " + bankDB.getCustomerName());
				System.out.println("Bank Name from DB = " + bankDB.getBankName());

				// String CusName = bankDB.getCustomerName();
				// String BankName = bankDB.getBankName();

				double balanceDB = bankDB.getBalance(); // Get balance from DB

				if (bankDB.getCustomerName() != null && bankDB.getBankName() != null) {
					// check entered amount is valid and not greater than balance
					if (amount != 0 && amount <= balanceDB) {
						double rembalance = balanceDB - amount; // Calculate remaining balance
						System.out.println("Remaining balance after withdrawal = " + rembalance);

						// Only update the balance, do not change customer name or bank name
						bankDB.setBalance(rembalance); // Update balance only
						
						rb.save(bankDB);

						return rembalance; // Return the remaining balance after withdrawal
					}
				}
			}
		}

		return -1; // If no valid transaction happened, return -1
	
	}

	@Override
	public boolean DepotransferAmount(Bank bankdepositetrasfer) {
		
		List<Bank> bankk = rb.findAll(); // To check ac num and pin are correct or not

		for (Iterator<Bank> itr = bankk.iterator(); itr.hasNext();) {
			Bank bkDB = itr.next();

			if (bankdepositetrasfer.getAccountNum() != 0 && bankdepositetrasfer.getPinNum() != 0 && bkDB.getAccountNum() != 0
					&& bkDB.getPinNum() != 0) {
				if (bankdepositetrasfer.getAccountNum() == bkDB.getAccountNum()
						&& bankdepositetrasfer.getPinNum() == bkDB.getPinNum()) {
					return true;
				}
			}

		}

		return false;

		
	}

	@Override
	public double AddamountA2(Bank banksave) {
		
		List<Bank> bankd = rb.findAll(); // Fetch all bank records

		double amount = banksave.getBalance(); // Get the entered withdrawal amount
		System.out.println("Entered amount = " + amount);

		for (Bank bankDB : bankd) {
			// Match account number, pin number, and check both balances are non-zero
			if (banksave.getAccountNum() == bankDB.getAccountNum() && banksave.getPinNum() == bankDB.getPinNum()
					&& banksave.getBalance() != 0 && bankDB.getBalance() != 0) {

				System.out.println("Balance from DB from deposite section = " + bankDB.getBalance());
				System.out.println("Customer Name from DB from deposite section = " + bankDB.getCustomerName());
				System.out.println("Bank Name from DB  from deposite section= " + bankDB.getBankName());

				double balanceDB = bankDB.getBalance(); // Get balance from DB

				if (bankDB.getCustomerName() != null && bankDB.getBankName() != null) {
					// check entered amount is valid and not greater than balance
					if (amount != 0) {
						double totalbal = balanceDB + amount; // Calculate remaining balance

						// Only update the balance, do not change customer name or bank name
						bankDB.setBalance(totalbal); // Update balance only

						// Save the updated record back to the database
						rb.save(bankDB);

						return totalbal; // Return the remaining balance after withdrawal
					}
				}
			}
		}
		return amount;

	
	}

	/*
	 * @Override public List<Bank> fetchUsersData(Bank bk) { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 */
	
	// Amount transfer a1 account details check
	
	

}
