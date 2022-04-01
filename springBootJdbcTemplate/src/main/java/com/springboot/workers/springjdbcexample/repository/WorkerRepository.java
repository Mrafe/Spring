package com.springboot.workers.springjdbcexample.repository;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.workers.springjdbcexample.dao.WorkerDAO;
import com.springboot.workers.springjdbcexample.mapper.WorkerMapper;
import com.springboot.workers.springjdbcexample.model.Worker;


@Repository("workerMySqlRepo")
public class WorkerRepository implements WorkerDAO {
	@Autowired
	JdbcTemplate jdbcTemplateObject;
	

	@Override
	public int add(Worker worker) throws SQLException {
		 int workerId = worker.getWorkerId();
	        String firstName = worker.getFirstName();
	        String lastName = worker.getLastName();
	        Integer salary = worker.getSalary();
	        Date date = worker.getJoiningDate();
	        String department = worker.getDepartment();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String joiningDate = sdf.format(date);
	        String email = worker.getEmail();
	        String query = String.format("INSERT INTO worker VALUES(%d,'%s','%s',%d,'%s','%s','%s');", workerId,
	                firstName,
	                lastName, salary, joiningDate, department, email);
		return jdbcTemplateObject.update(query);
	}

	@Override
	public void delete(Integer workerId) throws SQLException {
		String sql = "DELETE FROM worker WHERE worker_id = ?";
		jdbcTemplateObject.update(sql, workerId);
		System.out.println("Record #" + workerId + " deleted");
		return;

	}

	@Override
	@SuppressWarnings("deprecation")
	public Worker getWorker(Integer workerId) throws SQLException {
		String sql = "SELECT * FROM worker WHERE worker_id = ?";
		Worker worker = jdbcTemplateObject.queryForObject(
				sql, 
				new Object[] {workerId}, 
				new WorkerMapper()
				);
		
		return worker;
	}

	@Override
	public List<Worker> getWorkers() throws SQLException {
		String sql = "SELECT * FROM worker";
		List<Worker> workers = jdbcTemplateObject.query(
				sql,
				new WorkerMapper());

		return workers;
	}

	@Override
	public void update(Worker emp) throws SQLException {
		String sql = """
                UPDATE TABLE Worker SET
                worker_id =?,
                first_name = ?,
                last_name =?,
                salary =?,
                joining_date = ?,
                department = ?,
                WHERE worker_id = ?""";
		
		jdbcTemplateObject.update(sql,emp.getWorkerId(),emp.getFirstName(),emp.getLastName(), emp.getSalary(), emp.getJoiningDate(), emp.getDepartment(), emp.getEmail());

	}
	
	public static void printAllWorkers(List<Worker> workers) {
		for(Worker worker: workers) {
			System.out.println("ID: " + worker.getWorkerId());
			System.out.println("FIRST NAME: " + worker.getFirstName());
			System.out.println("LAST NAME: " + worker.getLastName());
			System.out.println("SALARY: " + worker.getSalary());
			System.out.println("JOINING DATE: " + worker.getJoiningDate());
			System.out.println("DEPARTMENT: " + worker.getDepartment());
			System.out.println("EMAIL: " + worker.getEmail());
			System.out.println();
		}
	}

}

