package com.example.BankFetchAndOperations.Controller;

import java.util.List;

import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.BankFetchAndOperations.BankFetchAndOperationsApplication;
import com.example.BankFetchAndOperations.Model.Bank;
import com.example.BankFetchAndOperations.Repository.BankRepository;
import com.example.BankFetchAndOperations.Service.BankService;

@RestController
public class MyController {

	@Autowired
	BankService bs;

	@Autowired
	BankRepository rb;

	// private long accountNum;

	/*
	 * @Autowired Bank bb;
	 */

	// Welcome page 
	@RequestMapping("/")
	public ModelAndView FirstPage() {

		ModelAndView mvc = new ModelAndView();
		mvc.setViewName("WelcomePage");
		return mvc;

	}

	// Account create Page
	@RequestMapping("/createacc")
	public ModelAndView Account() {

		ModelAndView mvc = new ModelAndView();
		mvc.addObject("bankdata", new Bank());
		mvc.setViewName("NewAccount");
		return mvc;

	}

	// save the account details in DB
	@RequestMapping("/save") // account create and save in DB
	public ModelAndView AccountSave(@ModelAttribute("bankdata") Bank bank, HttpSession ss) {

		ModelAndView mvc = new ModelAndView();

		System.out.println(bank.toString());

		ss.setAttribute("Accnum", bank.getAccountNum());
		ss.setAttribute("pinnum", bank.getPinNum());

		bs.dosave(bank);
		mvc.setViewName("WelcomePage");
		return mvc;

	}

	// To enter A/C num and Pin num for checking deatails
	@RequestMapping("/Accdetails")
	public ModelAndView Accountt() {

		ModelAndView mvc = new ModelAndView();
		mvc.addObject("bankdata", new Bank());
		mvc.setViewName("CheckAccount");
		return mvc;

	}

	// To check the entered details are same as in DB or not
	@RequestMapping("/login")
	public ModelAndView doLogin(@ModelAttribute("bankdata") Bank bank, HttpSession hs) {
		ModelAndView mvc = new ModelAndView();

		System.out.println(bank.toString());

		hs.setAttribute("Accnum", bank.getAccountNum());
		hs.setAttribute("pinnum", bank.getPinNum());

		Long acnum = (long) hs.getAttribute("Accnum");
		int pin = (int) hs.getAttribute("pinnum");

		bank.setAccountNum(acnum);
		bank.setPinNum(pin);

		boolean userdetails = bs.dologin(bank);
		if (userdetails) {
			bank.setAccountNum(acnum);
			bank.setPinNum(pin);

			mvc.setViewName("Success");

		} else {
			mvc.setViewName("Error");
		}

		return mvc;
	}

	// Fetching the account details

	@RequestMapping("/usersData")
	public ModelAndView fetchUsersData(Bank bk, HttpSession hs) {
		ModelAndView mvc = new ModelAndView();

		Long acnum = (long) hs.getAttribute("Accnum");
		int pin = (int) hs.getAttribute("pinnum");

		
		bk.setAccountNum(acnum);
		bk.setPinNum(pin);

		Bank bankk = bs.fetchUsersData(bk);
		if (bankk!=null) {
			mvc.setViewName("Users");
			  mvc.addObject("bankdata", bankk);
			bk.setAccountNum(acnum);
			bk.setPinNum(pin);

		//	System.out.println("User found: " + bankk.toString());
		//	mvc.setViewName("Users");
		//	mvc.addObject("bankdata", bankk.get());
			// System.out.println("User found: " + bankk.get()); 
			}
			else {
			System.out.println("No matching user found.");
		} // mvc.setViewName("Users");

		return mvc;
	}

	

	// for withdrawal process

	// Enter A/C and pin num for withdraw
	@RequestMapping("/withdraw") // a/c and pin for withdraw
	public ModelAndView Withdraw() {

		ModelAndView mvc = new ModelAndView();
		mvc.addObject("bankdata", new Bank());
		mvc.setViewName("Withdraw");
		return mvc;

	}

	// Check entered ac and pin num details correct or not as in DB
	@RequestMapping("/withdrawmoney") // Details check and draw operation
	// @GetMapping
	public ModelAndView Withdraw(@ModelAttribute("bankdata") Bank bankw, HttpSession ss) {
		ModelAndView mvc = new ModelAndView();

		ss.setAttribute("Accnum", bankw.getAccountNum());
		ss.setAttribute("pinnum", bankw.getPinNum());

		System.out.println("Ac num & pin from withdraw" + bankw.toString());
		boolean CheckWithdraw = bs.WithdrawAmount(bankw);
		if (CheckWithdraw) {
			mvc.setViewName("SuccessForWithdraw");
		} else {
			mvc.setViewName("ErrorForWithdraw");
		}

		return mvc;
	}

	// to enter the money to draw
	@RequestMapping("/withdrawprocess")
	public ModelAndView FetchingAmount(@ModelAttribute("bankdata") Bank banka, HttpSession hs) {
		ModelAndView mvc = new ModelAndView();

		Long acnum = (long) hs.getAttribute("Accnum");
		int pin = (int) hs.getAttribute("pinnum");

		// hs.setAttribute("enteramu", banka.getBalance());

		System.out.println("Acc num from session = " + acnum);
		System.out.println("pin num from session = " + pin);
		// List<Bank> bankk = bs.FetchingAmount();
		mvc.addObject("bankdata", new Bank());
		mvc.setViewName("UserAmount");

		return mvc;
	}

	// to check the balance is sufficient or not
	@RequestMapping("/process") // Details check and draw operation
	public ModelAndView CheckBal(@ModelAttribute("bankdata") Bank bankb, HttpSession hs) {
		ModelAndView mvc = new ModelAndView();

		Long acnum = (long) hs.getAttribute("Accnum");
		int pin = (int) hs.getAttribute("pinnum");
		// String customerName = ((Bank) rb).getCustomerName();
		// String BankName = ((Bank) rb).getBankName();

		bankb.setAccountNum(acnum);
		bankb.setPinNum(pin);
		// bankb.setCustomerName(customerName);
		// bankb.setBankName(BankName);

		// System.out.println(bankw.toString());
		System.out.println("ac and pin from checkbal" + bankb.toString());

		// System.out.println("Account Num = "+bb.getAccountNum());

		Boolean balance = bs.CheckAmount(bankb);
		if (balance) {
			mvc.setViewName("OperationToWithdraw");
			bankb.setAccountNum(acnum);
			bankb.setPinNum(pin);
			// bankb.setCustomerName(customerName);
			// bankb.setBankName(BankName);

			hs.setAttribute("enteramu", bankb.getBalance());
		} else {
			mvc.setViewName("ReenterAmount");
		}

		return mvc;
	}

	// Continue to withdraw operation after enter the amount
	@RequestMapping("/continue")
	public double AmountRem(@ModelAttribute("bankdata") Bank bankr, HttpSession hs) {
		ModelAndView mvc = new ModelAndView();
		double entamu = (double) hs.getAttribute("enteramu");

		Long acnum = (long) hs.getAttribute("Accnum");
		int pin = (int) hs.getAttribute("pinnum");

		// String customerName = ((Bank) rb).getCustomerName();
		// String BankName = ((Bank) rb).getBankName();

		bankr.setAccountNum(acnum);
		bankr.setPinNum(pin);
		bankr.setBalance(entamu);

		// bankr.setCustomerName(customerName);
		// bankr.setBankName(BankName);

		double rembalance = bs.FetchingAmount(bankr);
		bankr.setBalance(rembalance);

		// bs.dosaveAc(bankr);

		System.out.println("amount remaining = " + rembalance);

		if (rembalance != -1) {
			return rembalance; // Return the updated balance display the amount on screen
		} else {
			throw new RuntimeException("Insufficient funds or invalid account/pin.");
		}

	}

	// mvc.setViewName("FinalStep");

	@PostMapping("/saveAccount")
	public String saveAccount(@RequestBody Bank bank) {

		// System.out.println("Balance saved successfully for the account :: " +
		// bank.getAccountNum());
		return bs.dosaveAc(bank);

	}

	/// for deposit process

	@RequestMapping("/deposit") // a/c and pin for withdraw
	public ModelAndView Deposit() {

		ModelAndView mvc = new ModelAndView();
		mvc.addObject("bankdatadepo", new Bank());
		mvc.setViewName("DepositPage");
		return mvc;

	}

	@RequestMapping("/depomoney") // Details check and deposit operation
	// @GetMapping
	public ModelAndView Depocheck(@ModelAttribute("bankdatadepo") Bank bankdeposite, HttpSession ss) {
		ModelAndView mvc = new ModelAndView();

		ss.setAttribute("Accnum", bankdeposite.getAccountNum());
		ss.setAttribute("pinnum", bankdeposite.getPinNum());

		// System.out.println("Ac num & pin from withdraw" + bankw.toString());
		boolean Checkdepo = bs.DepoAmount(bankdeposite);
		if (Checkdepo) {
			mvc.setViewName("SuccessForDeposit");
		} else {
			mvc.setViewName("ErrorForDeposit");
		}

		return mvc;
	}

	@RequestMapping("/continuedepo") // a/c and pin for withdraw
	public ModelAndView EnterDpAmount(@ModelAttribute("bankdatadepo") Bank bankaddm, HttpSession ss) { // to enterfor
																										// deposit

		ModelAndView mvc = new ModelAndView();
		// mvc.addObject("bankdatadepo", new Bank());
		mvc.setViewName("EnterAmountForDepo");
		return mvc;

	}

	@RequestMapping("/processtodepo") // Details check and draw operation
	public ModelAndView EnterAmount(@ModelAttribute("bankdatadepo") Bank bankamount, HttpSession hs) {
		ModelAndView mvc = new ModelAndView();

		Long acnum = (long) hs.getAttribute("Accnum");
		int pin = (int) hs.getAttribute("pinnum");
		// String customerName = ((Bank) rb).getCustomerName();
		// String BankName = ((Bank) rb).getBankName();

		bankamount.setAccountNum(acnum);
		bankamount.setPinNum(pin);

		// mvc.setViewName("EnterAmountForDepo");
		boolean checkamounttodepo = bs.CheckAmounttodepo(bankamount);
		if (checkamounttodepo) {
			mvc.setViewName("OperationToDeposit");

			hs.setAttribute("enteramu", bankamount.getBalance());

		} else {
			mvc.setViewName("ReEnterAmountToDepo");
		}

		return mvc;
	}

	@RequestMapping("/continuedp")
	public double AmountAdd(@ModelAttribute("bankdatadepo") Bank banksave, HttpSession hs) {
		ModelAndView mvc = new ModelAndView();
		double entamu = (double) hs.getAttribute("enteramu");

		Long acnum = (long) hs.getAttribute("Accnum");
		int pin = (int) hs.getAttribute("pinnum");

		banksave.setAccountNum(acnum);
		banksave.setPinNum(pin);
		banksave.setBalance(entamu);

		double totalbalance = bs.Addamount(banksave);
		if (totalbalance > 0) {
			mvc.setViewName("FinalStepForDeposit");
		}

		// return mvc;

		if (totalbalance != -1) {
			return totalbalance; // Return the updated balance display the amount on screen
		} else {
			throw new RuntimeException("Insufficient funds or invalid account/pin.");
		}

	}

	@PostMapping("/saveAmount")
	public String saveAccountdepo(@RequestBody Bank bank) {

		// System.out.println("Balance saved successfully for the account :: " +
		// bank.getAccountNum());
		return bs.dosaveAmount(bank);

	}
	

	
	// For transfer the amount from one account to another
	
	// To enter A/C num and Pin num for checking deatails
		@RequestMapping("/transfer")
		public ModelAndView Transfer() {

			ModelAndView mvc = new ModelAndView();
			mvc.addObject("bankdata", new Bank());
			mvc.setViewName("A1AccForTransfer");
			return mvc;

		}
		
		@RequestMapping("/transferacc") // Details check and draw operation
		// @GetMapping
		public ModelAndView AmuTransfer(@ModelAttribute("bankdata") Bank banktransfer, HttpSession ss) {
			ModelAndView mvc = new ModelAndView();

			ss.setAttribute("Accnum", banktransfer.getAccountNum());
			ss.setAttribute("pinnum", banktransfer.getPinNum());

			System.out.println("Ac num & pin from transfer" + banktransfer.toString());
			boolean Checktrans = bs.transferA1account(banktransfer);
			if (Checktrans) {
				mvc.setViewName("SuccessPageForTransfer");
			} 
			
			else {
				mvc.setViewName("ErrorPageForTranser");
			}

			return mvc;
	
		}
		
		
		// to enter the money to draw
		@RequestMapping("/Amounttrs")
		public ModelAndView EnterAmounttrans(@ModelAttribute("bankdata") Bank banka, HttpSession hs) {
			ModelAndView mvc = new ModelAndView();

			Long acnum = (long) hs.getAttribute("Accnum");
			int pin = (int) hs.getAttribute("pinnum");
			
			banka.setAccountNum(acnum);
			banka.setPinNum(pin);
			
			System.out.println("Acc num from session = " + acnum);
			System.out.println("pin num from session = " + pin);
			// List<Bank> bankk = bs.FetchingAmount();
			mvc.addObject("bankdata", new Bank());
			mvc.setViewName("EnterAmountForTransfer");

			return mvc;
		}
		
		
		// Amount to transfer
		@RequestMapping("/processtotransfer") // Details check and transfer operation
		// @GetMapping
		public ModelAndView AmountTransfer(@ModelAttribute("bankdata") Bank bankt, HttpSession ss) {
			ModelAndView mvc = new ModelAndView();

			Long acnum = (long) ss.getAttribute("Accnum");
			int pin = (int) ss.getAttribute("pinnum");
			
			
			bankt.setAccountNum(acnum);
			bankt.setPinNum(pin);
			
			
			System.out.println("Ac num & pin from transfer" + bankt.toString());
			boolean ChecktransAmount = bs.checkAmount(bankt);
			if (ChecktransAmount) {
				mvc.setViewName("ConfirmToTransfer");
				bankt.setAccountNum(acnum);
				bankt.setPinNum(pin);
				
				ss.setAttribute("enteramu", bankt.getBalance());
				//mvc.setViewName("ConfirmToTransfer");
			} 
			
			else {
				mvc.setViewName("Re-EnterAmountTransfer");
			}

			return mvc;
	
		}
		
		
		// Continue to withdraw operation after enter the amount(In Transfer operation)
		@RequestMapping("/amountdeduct")
		public ModelAndView continuetoA1(@ModelAttribute("bankdata") Bank bankr, HttpSession hs) {
			ModelAndView mvc = new ModelAndView();
			double entamu = (double) hs.getAttribute("enteramu");

			Long acnum = (long) hs.getAttribute("Accnum");
			int pin = (int) hs.getAttribute("pinnum");

			// String customerName = ((Bank) rb).getCustomerName();
			// String BankName = ((Bank) rb).getBankName();

			bankr.setAccountNum(acnum);
			bankr.setPinNum(pin);
			bankr.setBalance(entamu);

			double deductamount = bs.DeductAmount(bankr);
			bankr.setBalance(deductamount);

			

			System.out.println("amount remaining = " + deductamount);

			if (deductamount != -1) {
			//	  return deductamount; // Return the updated balance display the amount on screen
				 mvc.setViewName("A2AccountPage"); 
				//mvc.addObject("balance", deductamount);

		        return mvc; 
			  
			} else {
				throw new RuntimeException("Insufficient funds or invalid account/pin.");
			}
			
			

		}
		
		
		@RequestMapping("/A2account") // a/c and pin for withdraw
		public ModelAndView Depositt() {

			ModelAndView mvc = new ModelAndView();
			mvc.addObject("bankdata", new Bank());
			mvc.setViewName("A2AccountPage");
			return mvc;

		}
	// Continueation for transfer amount by deposite (In transfer operation)	
		
		@RequestMapping("/transferA2Acc") // a/c and pin for withdraw
		
		public ModelAndView checkA2account(@ModelAttribute("bankdata") Bank bankdepositetrasfer, HttpSession ss) {
			ModelAndView mvc = new ModelAndView();

			ss.setAttribute("Accnum", bankdepositetrasfer.getAccountNum());
			ss.setAttribute("pinnum", bankdepositetrasfer.getPinNum());

			// System.out.println("Ac num & pin from withdraw" + bankw.toString());
			boolean Checkdepo = bs.DepotransferAmount(bankdepositetrasfer);
			if (Checkdepo) {
				mvc.setViewName("SuccessPagetransferbyDepo");
			} else {
				mvc.setViewName("ErrorPagefortransferByDepo");
			}

			return mvc;
		}
	 	
	//save amount in A2 account
		
		@RequestMapping("/saveinA2")
		public ModelAndView AmountAddA2(@ModelAttribute("bankdatadepo") Bank banksave, HttpSession hs) {
			ModelAndView mvc = new ModelAndView();
			double entamu = (double) hs.getAttribute("enteramu");

			Long acnum = (long) hs.getAttribute("Accnum");
			int pin = (int) hs.getAttribute("pinnum");

			banksave.setAccountNum(acnum);
			banksave.setPinNum(pin);
			banksave.setBalance(entamu);

			double totalbalance = bs.AddamountA2(banksave);
		/*
		 * if (totalbalance > 0) { mvc.setViewName("FinalStepFortransfer"); }
		 */

			// return mvc;

			if (totalbalance != -1) {
				//return totalbalance; // Return the updated balance display the amount on screen
				mvc.setViewName("FinalSteptotransfer"); 
				//mvc.addObject("balance", deductamount);

		        return mvc; 
			} else {
				throw new RuntimeException("Insufficient funds or invalid account/pin.");
			}
	
		
		}
		
		
}
