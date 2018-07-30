package org.bran.branroom.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @ClassName: User
 * @Description: TODO
 * @author: BranSummer
 * @date: 2017/10/07 13:28:58
 */
public class User implements Comparable<User> {

	public static final boolean GENDER_MALE=true;

	public static final boolean GENDER_FEMALE=false;
	
	/**
	 * default avatar img="/branroom/static/img/default.png"
	 */
	public static final String DEFAULT_AVATAR="/branroom/static/img/default.png";
	
	/**
	 * default introduction ""
	 */
	public static final String DEFAULT_INTRRO="";

	public static final String PERMI_ADMIN="10";

	public static final String PERMI_USER_C="0";

	public static final String PERMI_USER_B="1";
	
	private String userId;
	
	@JsonIgnore
	private String password;

	@JsonIgnore
	private String salt;
	
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public int compareTo(User o) {
		
		return this.userId.compareTo(o.userId);
	}
	
	
}
