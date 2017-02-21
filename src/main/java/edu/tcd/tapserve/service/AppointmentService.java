package edu.tcd.tapserve.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tcd.tapserve.bean.Appointment;
import edu.tcd.tapserve.bean.ServiceProvider;
import edu.tcd.tapserve.constants.Constants.AppointmentStatus;
import edu.tcd.tapserve.repository.AppointmentRepository;
import edu.tcd.tapserve.repository.ServiceProviderRepository;
import edu.tcd.tapserve.repository.UserRepository;

@Service
public class AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ServiceProviderRepository serviceproviderRepository;

	public Appointment bookAppointment(Appointment appointment) {
		if (appointment == null)
			return null;

		appointment.setId(UUID.randomUUID().toString());
		appointmentRepository.save(appointment);
		return appointment;
	}

	public Appointment getAppointmentDetails(String appointmentId) {
		return appointmentRepository.findOne(appointmentId);
	}

	public List<Appointment> getAppointmentHistoryForUser(String userId) {
		return appointmentRepository.findByUser(userRepository.findOne(userId));
	}

	public List<Appointment> getAppointmentsOfServiceProvider(String serviceProviderId) {
		ServiceProvider serviceProvider = serviceproviderRepository.findOne(serviceProviderId);
		return appointmentRepository.findByServiceProvider(serviceProvider);
	}

	public List<Appointment> getOpenAppointmentsOfServiceProvider(String serviceProviderId) {
		List<Appointment> openAppointments = new ArrayList<Appointment>();
		ServiceProvider serviceProvider = serviceproviderRepository.findOne(serviceProviderId);

		List<Appointment> serviceProviderAppointments = appointmentRepository.findByServiceProvider(serviceProvider);

		for (Appointment appointment : serviceProviderAppointments) {
			if (appointment.getStatus() == AppointmentStatus.OPEN.getVal()) {
				openAppointments.add(appointment);
			}
		}
		return openAppointments;

	}
}
