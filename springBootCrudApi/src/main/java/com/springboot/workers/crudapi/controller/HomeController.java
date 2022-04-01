/**
 * 
 */
package com.springboot.workers.crudapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.crudapi.util.TimeUtil;

/**
 * @author Leona
 *
 */
@RestController
public class HomeController {
	@GetMapping("/")
	public String message() {
		return "Hello Visitor! <br>Visiting Time:"+TimeUtil.getTime();
	}
}
