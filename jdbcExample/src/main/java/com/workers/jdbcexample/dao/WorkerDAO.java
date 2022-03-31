package com.workers.jdbcexample.dao;

import java.sql.*;
import java.util.List;

import com.workers.jdbcexample.model.Worker;

public interface WorkerDAO {
    public int add(Worker worker)
            throws SQLException;

    public void delete(int workerId)
            throws SQLException;

    public Worker getWorker(int workerId)
            throws SQLException;

    public List<Worker> getWorkers()
            throws SQLException;

    public int update(Worker emp)
            throws SQLException;
}
