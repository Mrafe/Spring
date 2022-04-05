package com.springboot.workers.crudapi.model;

import java.util.Date;

public class Bonus {
	int workerRefId;
	int bonusAmount;
	Date bonusDate;
	
	public Bonus(int workerRefId, int bonusAmount, Date bonusDate) {
		this.workerRefId = workerRefId;
		this.bonusAmount = bonusAmount;
		this.bonusDate = bonusDate;
	}

	public int getWorkerRefId() {
		return workerRefId;
	}

	public void setWorkerRefId(int workerRefId) {
		this.workerRefId = workerRefId;
	}

	public int getBonusAmount() {
		return bonusAmount;
	}

	public void setBonusAmount(int bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	public Date getBonusDate() {
		return bonusDate;
	}

	public void setBonusDate(Date bonusDate) {
		this.bonusDate = bonusDate;
	}

	@Override
	public String toString() {
		return "Title [workerRefId=" + workerRefId + ", bonusAmount=" + bonusAmount + ", bonusDate=" + bonusDate + "]";
	}
	
	
	
}
