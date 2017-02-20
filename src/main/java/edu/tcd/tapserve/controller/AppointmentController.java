package edu.tcd.tapserve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.tcd.tapserve.bean.Appointment;
import edu.tcd.tapserve.service.AppointmentService;

@RestController
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;

	@RequestMapping(method = RequestMethod.POST, value = "/{userId}/bookAppointment/{serviceProviderId}/{serviceId}")
	@CrossOrigin(origins = "http://localhost:8080")
	public Appointment bookAppointment(@RequestBody Appointment appointment) {
		return appointmentService.bookAppointment(appointment);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{userId}/appointments/{appointmentId}")
	public Appointment getAppointmentDetails(@PathVariable String appointmentId) {
		return appointmentService.getAppointmentDetails(appointmentId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{userId}/appointments")
	public List<Appointment> getAppointmentHistory(@PathVariable String userId) {
		return appointmentService.getAppointmentHistory(userId);
	}
}
