package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	
	@GetMapping("/task")
	public String demon() {
		return "Task demonstration";
	}
	
	@GetMapping("/task/showMyInfo")
	public List<String> personal(){
		return List.of("Name: Rafe", "City: Pune", "State: Maharashtra", "dream_job: SDE");
	}
	
	@GetMapping("/task/showMyHobbies")
	public List<String> hobby(){
		return List.of("CS:GO", "Valorant", "Badminton");
	}
}
