/**
 * 
 */
package com.springboot.workers.crudapi.model;

import java.util.Date;

/**
 * @author Leona
 *
 */
public class Worker {
	int workerId;
    String firstName;
    String lastName;
    int salary;
    Date joiningDate;
    String department;
    String email;
    String password;
    
    public Worker() {
    	this.joiningDate = new Date(new java.util.Date().getTime());
    }

	public Worker(int workerId, String firstName, String email, String password) {
         this.workerId = workerId;
         this.firstName = firstName;
         this.email = email;
         this.password = password;
    }

	public Worker(int workerId, String firstName, String lastName, int salary, Date joiningDate,
            String department,
            String email, String password) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.department = department;
        this.email = email;
        this.password = password;
    }

    public Worker(int workerId, String firstName, String lastName, int salary, String department,
            String email, String password) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.joiningDate = new Date(new java.util.Date().getTime());
        this.department = department;
        this.email = email;
        this.password = password;
    }
    public Worker(int workerId, String email) {
        this.workerId = workerId;
        this.email = email;
        this.joiningDate = new Date(new java.util.Date().getTime());
    }

    public int getWorkerId() {
         return workerId;
    }

    public void setWorkerId(int workerId) {
         this.workerId = workerId;
    }

    public String getFirstName() {
         return firstName;
    }

    public void setFirstName(String firstName) {
         this.firstName = firstName;
    }

    public String getLastName() {
         return lastName;
    }

    public void setLastName(String lastName) {
         this.lastName = lastName;
    }

    public int getSalary() {
         return salary;
    }

    public void setSalary(int salary) {
         this.salary = salary;
    }

    public Date getJoiningDate() {
         return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
         this.joiningDate = joiningDate;
    }

    public String getDepartment() {
         return department;
    }

    public void setDepartment(String department) {
         this.department = department;
    }

    public String getEmail() {
         return email;
    }

    public void setEmail(String email) {
         this.email = email;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Worker [workerId=" + workerId + ", firstName=" + firstName + ", lastName=" + lastName + ", salary="
				+ salary + ", joiningDate=" + joiningDate + ", department=" + department + ", email=" + email
				+"]";
	}

    
}
