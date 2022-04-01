/**
 * 
 */
package com.springboot.workers.crudapi.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.repository.WorkerRepository;

/**
 * @author Leona
 *
 */

@RestController
@RequestMapping("/worker")
public class WorkerController {
	@Resource(name="workerMySqlRepo")
	private WorkerRepository workerRepository;

	@GetMapping("/worker/{id}")
	public Worker showWorker(@PathVariable int id) {
		try {
			return this.workerRepository.getWorker(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@GetMapping("/all")
	public List<Worker> showAllWorker() {
		try {
			return this.workerRepository.getWorkers();
		} catch (SQLException e) {
			e.printStackTrace();
			return List.of();
		}

	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Boolean createWorker(@RequestBody Worker worker) {
		int rowsAffected;
		try {
			rowsAffected = this.workerRepository.add(worker);
			if(rowsAffected == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@PatchMapping("/update/{id}")
	public Boolean updateWorker(@RequestBody Map<String, String> params, @PathVariable int id) {
		int rowsAffected = this.workerRepository.changeEmail(params.get("email"), id);
		System.out.println("rows affected " + rowsAffected);
		if(rowsAffected == 1) {
			return true;
		}
		return false;
	}

	@DeleteMapping("/delete/{id}")
	public Boolean deleteWorker(@PathVariable int id) 
	{
		try {
			int rowsAffected = this.workerRepository.delete(id);
			if(rowsAffected == 1) {
			return true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
