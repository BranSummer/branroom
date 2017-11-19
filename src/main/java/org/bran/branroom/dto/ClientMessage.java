package org.bran.branroom.dto;

import java.io.IOException;

import org.bran.branroom.enums.MessageType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientMessage {
	
	private MessageType type;
	
	private String userid;
	
	private String avatar;
	
	private String content;

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public  String toJson(){
		String json=null;
		ObjectMapper map=new ObjectMapper();
		try {
			json=map.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public static ClientMessage praseMessage(String json){
		ObjectMapper map=new ObjectMapper();
		try {
			return map.readValue(json, ClientMessage.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}
