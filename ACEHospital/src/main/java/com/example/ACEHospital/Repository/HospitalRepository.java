package com.example.ACEHospital.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ACEHospital.Model.Appointment;


@Repository
public interface HospitalRepository extends JpaRepository<Appointment, Long>{

	
	

}
