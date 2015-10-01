package bcoan.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bcoan.rest.domain.Hello;

@RestController
public class HelloController {
	@Autowired
	private Hello hello;
	
	@RequestMapping("/")
	public String hello() {
		return hello.getMessage();
	}
}
