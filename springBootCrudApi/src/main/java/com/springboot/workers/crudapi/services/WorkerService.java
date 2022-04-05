package com.springboot.workers.crudapi.services;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.repository.WorkerRepository;

@Service
public class WorkerService {
	@Resource(name="workerMySqlRepo")
	private WorkerRepository workerRepository;

	public Worker getWorker(Integer id) {
		try {
			return this.workerRepository.findWorkerById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<Worker> getWorkers() {
		try {
			return this.workerRepository.findAllWorkers();
		} catch (SQLException e) {
			e.printStackTrace();
			return List.of();
		}

	}
	
	public String createWorker(Worker worker) {
		try {
			int rowsAffected = this.workerRepository.createWorker(worker);
			return rowsAffected+ " Workers Created Successfully";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error creating the worker";
		}
		
		
	}

	public boolean updateWorker(Integer id,String email) {
		int rowsAffected = this.workerRepository.updateEmailById(email,id);
		return rowsAffected==1;
	}

	public boolean deleteWorkerById(Integer id) 
	{
		try {
			int rowsAffected = this.workerRepository.deleteWorkerById(id);
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
