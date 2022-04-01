package com.springboot.workers.springjdbcexample.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.springjdbcexample.model.Worker;
import com.springboot.workers.springjdbcexample.repository.WorkerRepository;

@RestController
@RequestMapping("/worker")
public class WorkerController {
	@Resource(name="workerMySqlRepo")
	private WorkerRepository workerRepository;

	
	@GetMapping({"/showWorker"})
	public Worker showInfo() {
		try {
			return workerRepository.getWorker(5);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/all/showWorkers")
	public List<Worker> showAllWorkers() {
		try {
			return workerRepository.getWorkers();
		} catch (SQLException e) {
			e.printStackTrace();
			return List.of();
		}
	}
	
	@GetMapping("/createWorker")
	public String createWorker() {
		Worker worker1 = new Worker(21, "Ashwesh", "a.a@my_org.in");
		try {
			workerRepository.add(worker1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Created worker "+ worker1.getFirstName() + "'s record.";
	}
	@GetMapping("/updateWorker")
	public String updateWorker() {
		Worker worker1 = new Worker(21, "Saitama", "s.s@my_org.in");
		try {
			workerRepository.update(worker1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Updated worker "+ worker1.getFirstName() + "'s record.";
	}
	
	@GetMapping("/deleteWorker")
	public String deleteWorker() {
		try {
			workerRepository.delete(21);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Deleted worker " + 21 + "'s record.";
	}
}
