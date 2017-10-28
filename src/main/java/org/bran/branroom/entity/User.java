package org.bran.branroom.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @ClassName: User
 * @Description: TODO
 * @author: BranSummer
 * @date: 2017/10/07 13:28:58
 */
public class User {
	
	@JsonIgnore
	public static final boolean GENDER_MALE=true;
	
	@JsonIgnore
	public static final boolean GENDER_FEMALE=false;
	
	/**
	 * default avatar img="/branroom/static/img/default.png"
	 */
	@JsonIgnore
	public static final String DEFAULT_AVATAR="/branroom/static/img/default.png";
	
	/**
	 * default introduction ""
	 */
	@JsonIgnore
	public static final String DEFAULT_INTRRO="";
	
	@JsonIgnore
	public static final String PERMI_ADMIN="10";
	
	@JsonIgnore
	public static final String PERMI_USER_C="0";
	
	@JsonIgnore
	public static final String PERMI_USER_B="1";
	
	private String userId;
	
	@JsonIgnore
	private String password;
	
	private boolean gender;
	
	private String avatar;
	
	@JsonIgnore
	private String permission;
	
	@JsonIgnore
	private String email;
	
	@JsonIgnore
	private String introduction;

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	
}
