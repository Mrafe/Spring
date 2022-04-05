package com.springboot.workers.crudapi.repository;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.workers.crudapi.dao.WorkerDAO;
import com.springboot.workers.crudapi.mapper.WorkerMapper;
import com.springboot.workers.crudapi.model.Worker;

@Repository("workerMySqlRepo")
public class WorkerRepository implements WorkerDAO {
	@Autowired
	JdbcTemplate jdbcTemplateObject;
	

	@Override
	public int createWorker(Worker worker) throws SQLException {
		 int workerId = worker.getWorkerId();
	        String firstName = worker.getFirstName();
	        String lastName = worker.getLastName();
	        Integer salary = worker.getSalary();
	        Date date = worker.getJoiningDate();
	        String department = worker.getDepartment();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String joiningDate = sdf.format(date);
	        String email = worker.getEmail();
	        String password = worker.getPassword();
	        String query = String.format("INSERT INTO worker VALUES(%d,'%s','%s',%d,'%s','%s','%s', '%s');", workerId,
	                firstName,
	                lastName, salary, joiningDate, department, email, password);
		return jdbcTemplateObject.update(query);
	}

	@Override
	public int deleteWorkerById(Integer workerId) throws SQLException {
		String sql = "DELETE FROM worker WHERE worker_id = ?";
		return jdbcTemplateObject.update(sql, workerId);
		

	}

	@Override
	@SuppressWarnings("deprecation")
	public Worker findWorkerById(Integer workerId) throws SQLException {
		String sql = "SELECT * FROM worker WHERE worker_id = ?";
		return jdbcTemplateObject.queryForObject(
				sql, 
				new Object[] {workerId}, 
				new WorkerMapper()
				);
	}

	@Override
	public List<Worker> findAllWorkers() throws SQLException {
		String sql = "SELECT * FROM worker";
		return jdbcTemplateObject.query(
				sql,
				new WorkerMapper());
	}

	@Override
	public void updateWorker(Worker emp) throws SQLException {
		String sql = """
                UPDATE TABLE Worker SET
                worker_id =?,
                first_name = ?,
                last_name =?,
                salary =?,
                joining_date = ?,
                department = ?,
                password =?,
                WHERE worker_id = ?""";
		
		jdbcTemplateObject.update(sql,emp.getWorkerId(),emp.getFirstName(),emp.getLastName(), emp.getSalary(), emp.getJoiningDate(), emp.getDepartment(), emp.getEmail(), emp.getPassword());

	}

	@Override
	public int updateEmailById(String email, int id) {
		String sql = "UPDATE Worker SET	email = ? WHERE worker_id = ?";
		return jdbcTemplateObject.update(sql, email, id);
	}

}