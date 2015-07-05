package com.task.rest.rof;

public class Task {
	
	
	private String taskname;
	private String taskpriority;
	
	public Task(String name, String priority) {
		this.taskname = name;
		this.taskpriority = priority;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getTaskpriority() {
		return taskpriority;
	}

	public void setTaskpriority(String taskpriority) {
		this.taskpriority = taskpriority;
	}
	
	

}
