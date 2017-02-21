package edu.tcd.tapserve.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import edu.tcd.tapserve.bean.Appointment;
import edu.tcd.tapserve.bean.Payment;
import edu.tcd.tapserve.constants.Constants.PaymentStatus;
import edu.tcd.tapserve.repository.AppointmentRepository;
import edu.tcd.tapserve.repository.PaymentRepository;

public class PaymentServiceTest {

	@InjectMocks
	PaymentService paymentService = new PaymentService();

	@Mock
	AppointmentRepository mockedAppointmentRepository;

	@Mock
	PaymentRepository paymentRepository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testPayForService() {
		Appointment appointment = new Appointment();
		appointment.setId("app1");

		Payment payment = new Payment();
		payment.setId("p1");
		payment.setAppointment(appointment);

		Mockito.when(mockedAppointmentRepository.findOne(Mockito.anyString())).thenReturn(appointment);

		Mockito.when(paymentRepository.save(Mockito.any(Payment.class))).thenReturn(payment);

		assertEquals(appointment, paymentService.payForService("app1", payment).getAppointment());

		assertEquals(PaymentStatus.DONE.getVal(), paymentService.payForService("app1", payment).getStatus());
	}

}
