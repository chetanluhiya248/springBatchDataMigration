package com.selfLearn.springBatchDataMigration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MF_Entity {
	
	private int Id;
	private int Mf_id;
	private String type;
	private String risk_ratio;
	private int ratings;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getMf_id() {
		return Mf_id;
	}
	public void setMf_id(int mf_id) {
		Mf_id = mf_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRisk_ratio() {
		return risk_ratio;
	}
	public void setRisk_ratio(String risk_ratio) {
		this.risk_ratio = risk_ratio;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
	

}
