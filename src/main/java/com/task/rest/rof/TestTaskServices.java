package com.task.rest.rof;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;

public class TestTaskServices {


	public  static int taskId = -1;
	
	@Test 
	public void testListTasks(){
		RestAssured.baseURI = "http://localhost";
        RestAssured.port = 9090;
        RestAssured.basePath = "/RESTfulExample/rest/task";
        Response resp = given().get("/list/all");
        Assert.assertEquals(200, resp.getStatusCode());
	}
	
	@Test 
	public void testAddTasks(){
		RestAssured.baseURI = "http://localhost";
        RestAssured.port = 9090;
        RestAssured.basePath = "/RESTfulExample/rest/task";
        Gson gson = new Gson();
        Task task = new Task("testTask", "high");
        String jsonStr = gson.toJson(task);
        Header header = new Header("Content-Type", "application/json");
		Response resp = given().header(header).body(jsonStr).post("/addTask");
        Assert.assertEquals(200, resp.getStatusCode());
        String jsonrespStr = resp.getBody().asString();
        TaskJsonObject taskObject = gson.fromJson(jsonrespStr, TaskJsonObject.class);
        taskId = taskObject.getTaskId();
	}
	
	@Test 
	public void testUpdateTasks(){
		RestAssured.baseURI = "http://localhost";
        RestAssured.port = 9090;
        RestAssured.basePath = "/RESTfulExample/rest/task";
        System.out.println("Update taskId :"+ taskId);
        Header header = new Header("Content-Type", "application/json");
		String jsonStr = "{'taskid':"+taskId+"}";
		Response resp = given().header(header ).body(jsonStr ).post("/update");
        Assert.assertEquals(200, resp.getStatusCode());
	}
	
	@Test 
	public void testdeleteTasks(){
		RestAssured.baseURI = "http://localhost";
        RestAssured.port = 9090;
        RestAssured.basePath = "/RESTfulExample/rest/task";
        System.out.println("Delete taskId :"+ taskId);
        Header header = new Header("Content-Type", "application/json");
		String jsonStr = "{'taskid':"+taskId+"}";
		Response resp = given().header(header ).body(jsonStr ).post("/delete");
        Assert.assertEquals(200, resp.getStatusCode());
	}
}
