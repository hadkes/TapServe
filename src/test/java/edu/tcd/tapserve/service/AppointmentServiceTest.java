package edu.tcd.tapserve.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import edu.tcd.tapserve.bean.Appointment;
import edu.tcd.tapserve.bean.Service;
import edu.tcd.tapserve.bean.ServiceProvider;
import edu.tcd.tapserve.bean.User;
import edu.tcd.tapserve.repository.AppointmentRepository;
import edu.tcd.tapserve.repository.UserRepository;

public class AppointmentServiceTest {

	@Mock
	AppointmentRepository appointmentRegistry;

	@Mock
	UserRepository userRegistry;

	@InjectMocks
	AppointmentService appointmentService = new AppointmentService();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testBookNullAppointment() {
		assertEquals(null, appointmentService.bookAppointment(null));
	}

	@Test
	public void testBookAppointment() {
		User user = new User();
		user.setId("user1");

		ServiceProvider sp = new ServiceProvider();
		sp.setId("sp1");

		Service service = new Service();
		service.setId("serv1");

		Appointment appointment = new Appointment();
		appointment.setName("abc");
		appointment.setUser(user);
		appointment.setServiceProvider(sp);
		appointment.setService(service);

		Mockito.when(appointmentRegistry.save(appointment)).thenReturn(appointment);

		assertEquals(appointment.getName(), appointmentService.bookAppointment(appointment).getName());
		assertEquals(appointment.getService(), appointmentService.bookAppointment(appointment).getService());
		assertEquals(appointment.getUser(), appointmentService.bookAppointment(appointment).getUser());
		assertEquals(appointment.getServiceProvider(),
				appointmentService.bookAppointment(appointment).getServiceProvider());

	}

	@Test
	public void testGetAppointment() {
		User user = new User();
		user.setId("user1");

		ServiceProvider sp = new ServiceProvider();
		sp.setId("sp1");

		Service service = new Service();
		service.setId("serv1");

		Appointment appointment = new Appointment();
		appointment.setId("app1");
		appointment.setName("abc");
		appointment.setUser(user);
		appointment.setServiceProvider(sp);
		appointment.setService(service);

		Mockito.when(appointmentRegistry.findOne(Mockito.anyString())).thenReturn(appointment);

		assertEquals(appointment, appointmentService.getAppointmentDetails("app1"));

	}

	@Test
	public void testGetAppointmentHistory() {
		User user = new User();
		user.setId("user1");

		ServiceProvider sp = new ServiceProvider();
		sp.setId("sp1");

		Service service = new Service();
		service.setId("serv1");

		Appointment appointment1 = new Appointment();
		appointment1.setId("app1");
		appointment1.setName("abc");
		appointment1.setUser(user);
		appointment1.setServiceProvider(sp);
		appointment1.setService(service);

		Appointment appointment2 = new Appointment();
		appointment2.setId("app2");
		appointment2.setName("xyz");
		appointment2.setUser(user);
		appointment2.setServiceProvider(sp);
		appointment2.setService(service);

		List<Appointment> appointments = new ArrayList<Appointment>();
		appointments.add(appointment1);
		appointments.add(appointment2);

		Mockito.when(userRegistry.findOne(Mockito.anyString())).thenReturn(user);

		Mockito.when(appointmentRegistry.findByUser(Mockito.any(User.class))).thenReturn(appointments);

		assertEquals(appointment1, appointmentService.getAppointmentHistory("user1").get(0));
		assertEquals(appointment2, appointmentService.getAppointmentHistory("user1").get(1));

	}

}
