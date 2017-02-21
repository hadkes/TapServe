package edu.tcd.tapserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.tcd.tapserve.bean.Payment;
import edu.tcd.tapserve.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@RequestMapping(method = RequestMethod.POST, value = "/{userId}/payment/{appointmentId}")
	@CrossOrigin(origins = "http://localhost:8080")
	public Payment payForService(@PathVariable String appointmentId, @RequestBody Payment payment) {
		return paymentService.payForService(appointmentId, payment);
	}
}