package edu.tcd.tapserve.controller.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.tcd.tapserve.bean.ServiceProvider;

@RestController
public class HelloController {

	@Autowired
	private TestService testService;

	@RequestMapping("/hello")
	public ServiceProvider sayHi() {
		return testService.findByRoleId("1234");

	}
}
