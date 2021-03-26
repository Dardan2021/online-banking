package com.onlineBankingSystem1.service;

import java.util.List;

import com.onlineBankingSystem1.domain.Appointment;

public interface AppointmentService {
	Appointment createAppointment(Appointment appointment);

    List<Appointment> findAll();

    Appointment findAppointment(Long id);

    void confirmAppointment(Long id);
}