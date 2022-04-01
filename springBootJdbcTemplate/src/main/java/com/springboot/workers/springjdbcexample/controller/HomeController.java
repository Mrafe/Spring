package com.springboot.workers.springjdbcexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.workers.springjdbcexample.util.TimeUtil;

@RestController
public class HomeController {
	@GetMapping("/")
	public String showWelcomMessage() {
		return "Hello Visitor!<br>Visiting Time: " + TimeUtil.getTime();
	}
}
