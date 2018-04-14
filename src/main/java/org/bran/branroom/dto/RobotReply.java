package org.bran.branroom.dto;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;


public class RobotReply {
	
	private List<Map> results;
	
	private Map emotion;
	
	private Map intent;
	
	public static RobotReply getReply(String json){
		ObjectMapper mapper=new ObjectMapper();
		RobotReply reply=null;
		try {
			 reply=mapper.readValue(json, RobotReply.class);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return reply;
	}

	public List<Map> getResults() {
		return results;
	}

	public void setResults(List<Map> results) {
		this.results = results;
	}

	public Map getEmotion() {
		return emotion;
	}

	public void setEmotion(Map emotion) {
		this.emotion = emotion;
	}

	public Map getIntent() {
		return intent;
	}

	public void setIntent(Map intent) {
		this.intent = intent;
	}

	
	
	
}

