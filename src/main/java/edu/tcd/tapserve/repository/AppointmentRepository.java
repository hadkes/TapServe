package edu.tcd.tapserve.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.tcd.tapserve.bean.Appointment;
import edu.tcd.tapserve.bean.User;

public interface AppointmentRepository extends CrudRepository<Appointment, String> {

	public List<Appointment> findByUser(User user);
}
