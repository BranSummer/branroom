package org.bran.branroom.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RobotRequest {
	private int reqType; //输入类型
	private Map perception; //输入信息
	private Map userInfo;//用户信息
	
	public RobotRequest(){
		reqType=0;
		
		//输入信息初始化
		perception=new HashMap<String,Map>();
		Map inputText=new HashMap<String,String>();//文本信息
		perception.put("inputText", inputText);
		inputText.put("text", null);
		
		Map inputImage=new HashMap<String,String>();//图片地址
		perception.put("inputImage", inputImage);
		inputImage.put("url", null);
		
		Map inputMedia=new HashMap<String,String>();//音频信息
		perception.put("inputMedia", inputMedia);
		inputMedia.put("url", null);
		
		
		Map selfInfo=new HashMap<String,Map>();//客户端信息
		perception.put("selfInfo", selfInfo);
		Map location=new HashMap<String,String>();//地理位置信息
		selfInfo.put("location", location);
		location.put("city", null); //城市
		location.put("province", null); //省
		location.put("street", null); //信息路
	
		//用户信息初始化
		userInfo=new HashMap<String,String>();
		userInfo.put("apiKey",null); //
		userInfo.put("userId",null );//
		userInfo.put("groupId", null);//
		userInfo.put("userIdName", null);//
	
	}
	
	public int getReqType() {
		return reqType;
	}
	public void setReqType(int reqType) {
		this.reqType = reqType;
	}
	public Map getPerception() {
		return perception;
	}
	public void setPerception(Map perception) {
		this.perception = perception;
	}
	public Map getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(Map userInfo) {
		this.userInfo = userInfo;
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
