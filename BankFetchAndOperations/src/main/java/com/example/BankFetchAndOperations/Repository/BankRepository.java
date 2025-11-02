package com.example.BankFetchAndOperations.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankFetchAndOperations.Model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, String>{

	Optional<Bank> findByAccountNumAndPinNum(long accountNum, int pinNum);
	
	// Optional<Bank> findByAccountNumAndPinNum(String accountNum, String pinNum);

	

}