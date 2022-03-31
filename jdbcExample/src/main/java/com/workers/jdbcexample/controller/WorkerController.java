package com.workers.jdbcexample.controller;

import java.util.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workers.jdbcexample.model.Worker;
import com.workers.jdbcexample.repository.WorkerRepository;

@RestController
@RequestMapping("/worker")
public class WorkerController {

	@Autowired
	private WorkerRepository workerRepository;

	@GetMapping("/showWorker")
	public Worker showWorker() {
		try {
			return this.workerRepository.getWorker(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/all/showWorker")
	public List<Worker> showAllWorker() {
		try {
			return this.workerRepository.getWorkers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return List.of();

	}

	@GetMapping("/create")
	public String createWorker() {
		int rowsAffected;
		try {
			rowsAffected = this.workerRepository.add(new Worker(9, "Mai", "Sakurajama", 48412,
					new java.sql.Date(new Date().getTime()), "Admin", "mai@gmail.com"));
			return rowsAffected + " rows Affected";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

	@GetMapping("/update")
	public String updateWorker() {
		int rowsAffected;
		try {
			rowsAffected = this.workerRepository.update(new Worker(9, "Mai", "Sakurajama", 48412,
					new java.sql.Date(new Date().getTime()), "IT", "mfs.akash@gmail.com"));
			return rowsAffected + " rows Affected";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Worker not found";
	}

	@GetMapping("/delete")
	public String deleteWorker() {
		try {
			this.workerRepository.delete(9);
			return "Record deleted";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Record not found";
	}
}
