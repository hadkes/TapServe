package edu.tcd.tapserve.repository;

import org.springframework.data.repository.CrudRepository;

import edu.tcd.tapserve.bean.Payment;

public interface PaymentRepository extends CrudRepository<Payment, String> {

}
