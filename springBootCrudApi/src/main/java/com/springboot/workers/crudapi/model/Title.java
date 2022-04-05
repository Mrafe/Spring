package com.springboot.workers.crudapi.model;

import java.util.Date;

public class Title {
	int workerRefId;
	String workerTitle;
	Date affectedFrom;
	
	public Title(int workerRefId, String workerTitle, Date affectedFrom) {
		this.workerRefId = workerRefId;
		this.workerTitle = workerTitle;
		this.affectedFrom = affectedFrom;
	}
	
	public int getWorkerRefId() {
		return workerRefId;
	}
	public void setWorkerRefId(int workerRefId) {
		this.workerRefId = workerRefId;
	}
	public String getWorkerTitle() {
		return workerTitle;
	}
	public void setWorkerTitle(String workerTitle) {
		this.workerTitle = workerTitle;
	}
	public Date getAffectedFrom() {
		return affectedFrom;
	}
	public void setAffectedFrom(Date affectedFrom) {
		this.affectedFrom = affectedFrom;
	}

	@Override
	public String toString() {
		return "Title [workerRefId=" + workerRefId + ", workerTitle=" + workerTitle + ", affectedFrom=" + affectedFrom
				+ "]";
	}
	
	
	
}
