package org.bran.branroom.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Result {
	
	/**
	 *  "1" response with success
	 */
	public static final String SUCCESS = "1";
	
	/**
	 * "0" response with failure
	 */
	public static final String FAILURE = "0";
	
	private String status;
	
	private String message;

	private Object umessage;
	
	public Result() {
		super();
	}

	public Result(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	public Object getUmessage() {
		return umessage;
	}

	public void setUmessage(Object umessage) {
		this.umessage = umessage;
	}

	public String toJson(){
		String json=null;
		ObjectMapper mapper=new ObjectMapper();
		try {
			json=mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	public static Result buildSuccessResult(String message,Object umessage){
		Result result = new Result();
		result.setStatus(Result.SUCCESS);
		result.setMessage(message);
		result.setUmessage(umessage);
		return result;
	}
	public static Result buildErrorResult(String message,Object umessage){
		Result result = new Result();
		result.setStatus(Result.FAILURE);
		result.setMessage(message);
		result.setUmessage(umessage);
		return result;
	}
}
