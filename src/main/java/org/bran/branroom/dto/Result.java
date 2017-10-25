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
	
}
