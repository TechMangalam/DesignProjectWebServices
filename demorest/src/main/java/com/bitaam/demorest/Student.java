package com.bitaam.demorest;

public class Student {
	
	private String name,id,branch,batch;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", branch=" + branch + ", batch=" + batch + "]";
	}

	
	
	
	
	

}
