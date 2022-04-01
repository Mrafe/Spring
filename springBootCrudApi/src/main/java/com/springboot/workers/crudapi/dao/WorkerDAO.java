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
	public int add(Worker worker)
            throws SQLException;

    public int delete(Integer workerId)
            throws SQLException;

    public Worker getWorker(Integer workerId)
            throws SQLException;

    public List<Worker> getWorkers()
            throws SQLException;

    public void update(Worker emp)
            throws SQLException;

	int changeEmail(String email, int id);
}