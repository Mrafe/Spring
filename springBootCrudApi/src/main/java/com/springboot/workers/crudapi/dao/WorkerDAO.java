/**
 * 
 */
package com.springboot.workers.crudapi.dao;

import java.sql.SQLException;
import java.util.List;
import com.springboot.workers.crudapi.model.Worker;
/**
 * @author Leona
 *
 */
public interface WorkerDAO {
	public int createWorker(Worker worker)
            throws SQLException;

    public int deleteWorkerById(Integer workerId)
            throws SQLException;

    public Worker findWorkerById(Integer workerId)
            throws SQLException;

    public List<Worker> findAllWorkers()
            throws SQLException;

    public void updateWorker(Worker emp)
            throws SQLException;

	int updateEmailById(String email, int id);
}