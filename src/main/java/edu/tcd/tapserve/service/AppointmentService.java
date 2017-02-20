package edu.tcd.tapserve.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tcd.tapserve.bean.Appointment;
import edu.tcd.tapserve.repository.AppointmentRepository;
import edu.tcd.tapserve.repository.UserRepository;

@Service
public class AppointmentService {

	@Autowired
	AppointmentRepository appointmentRegistry;
	
	@Autowired
	UserRepository userRepository;

	public Appointment bookAppointment(Appointment appointment) {
		if (appointment == null)
			return null;

		appointment.setId(UUID.randomUUID().toString());
		appointmentRegistry.save(appointment);
		return appointment;
	}

	public Appointment getAppointmentDetails(String appointmentId) {
		return appointmentRegistry.findOne(appointmentId);
	}

	public List<Appointment> getAppointmentHistory(String userId) {
		return appointmentRegistry.findByUser(userRepository.findOne(userId));
		
	}
}
