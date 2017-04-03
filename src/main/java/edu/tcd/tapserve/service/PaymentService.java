package edu.tcd.tapserve.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tcd.tapserve.bean.Appointment;
import edu.tcd.tapserve.bean.Payment;
import edu.tcd.tapserve.constants.Constants.AppointmentStatus;
import edu.tcd.tapserve.constants.Constants.PaymentStatus;
import edu.tcd.tapserve.repository.AppointmentRepository;
import edu.tcd.tapserve.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;

	public Payment payForService(String appointmentId, Payment payment) {
		Appointment appointment = appointmentRepository.findOne(appointmentId);

		payment.setId(UUID.randomUUID().toString());
		appointment.setStatus(AppointmentStatus.CLOSED.getVal());
		payment.setAppointment(appointment);
		payment.setStatus(PaymentStatus.DONE.getVal());

		paymentRepository.save(payment);
		
		return payment;
	}
}
