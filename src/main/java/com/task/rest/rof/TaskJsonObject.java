package com.task.rest.rof;


public class TaskJsonObject {

	private int taskId;
	private String taskName;
	private String priority;
	private String status;
	public int getTaskId() {
		return taskId;
	}
	
	
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
