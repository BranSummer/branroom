package org.bran.branroom.dto;

import java.io.Serializable;
import java.util.Vector;

import org.bran.branroom.entity.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ChatMessage implements Serializable {
	@JsonIgnore
	private static final long serialVersionUID = 1L;
	
	/**
	 *   "-1"
	 * system message 系统消息 
	 */
	@JsonIgnore
	public static final String TYPE_SYS="-1";
	
	/**
	 *     "0"
	 * user chatting message 用户聊天消息 
	 */
	@JsonIgnore
	public static final String TYPE_USER="0";
	
	private String type;
	
	private User user;
	
	private String content;
	
	private Vector<User> onlineList;

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
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

	public ChatMessage(String type, User user, String content, Vector<User> onlineList) {
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
