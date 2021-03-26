package com.onlineBankingSystem1.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.onlineBankingSystem1.domain.Appointment;

public interface AppointmentDao extends CrudRepository<Appointment, Long> {

    List<Appointment> findAll();

	
    


	
}
