package org.bran.branroom.entity;

public class Watch {
	
	private String userId;
	
	private String wUser;
	
	

	public Watch(String userId, String wUser) {
		super();
		this.userId = userId;
		this.wUser = wUser;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getwUser() {
		return wUser;
	}

	public void setwUser(String wUser) {
		this.wUser = wUser;
	}
	
	
}
