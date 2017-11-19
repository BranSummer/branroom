package org.bran.branroom.dto;

import java.io.Serializable;
import java.util.Vector;

import org.bran.branroom.entity.User;
import org.bran.branroom.enums.MessageType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ServerMessage implements Serializable {
	@JsonIgnore
	private static final long serialVersionUID = 1L;
	
	
	
	
	
	private MessageType type;
	
	private User user;
	
	private String content;
	
	private Vector<User> onlineList;
	

	

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Vector<User> getOnlineList() {
		return onlineList;
	}

	public void setOnlineList(Vector<User> onlineList) {
		this.onlineList = onlineList;
	}

	public ServerMessage(MessageType type, User user, String content, Vector<User> onlineList) {
		super();
		this.type = type;
		this.user = user;
		this.content = content;
		this.onlineList = onlineList;
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
