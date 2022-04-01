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
		Worker worker1 = new Worker(18, "Mai", "mai@anime.org");
		try {
			workerRepository.add(worker1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Created worker "+ worker1.getFirstName();
	}
	@GetMapping("/updateWorker")
	public String updateWorker() {
		Worker worker1 = new Worker(18, "mai", "mai@anime.org");
		try {
			workerRepository.update(worker1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Updated worker "+ worker1.getFirstName();
	}
	
	@GetMapping("/deleteWorker")
	public String deleteWorker() {
		try {
			workerRepository.delete(18);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Deleted worker " + 18;
	}
}
