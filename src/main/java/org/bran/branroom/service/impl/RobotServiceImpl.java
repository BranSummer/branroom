package org.bran.branroom.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bran.branroom.dto.RobotReply;
import org.bran.branroom.dto.RobotRequest;
import org.bran.branroom.service.RobotService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class RobotServiceImpl implements RobotService {

	@Override
	public boolean isEnable() {
		// TODO Auto-generated method stub
		return false;
	}

	public String reply(String message) {
		String key="0961f0d3333649ceb10a43f55747f7ac";
		String url="http://www.tuling123.com/openapi/api";

		Document doc=null;
		Connection con=Jsoup.connect(url);
		Map map=new HashMap<String,String>();
		map.put("key", key);
		map.put("info", message);
		con.data(map);
		
		try {
			doc=con.post();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc.body().text();
	}
	
	@Override
	public String reply(String message,String userId){
		String url="http://openapi.tuling123.com/openapi/api/v2";
		String apiKey="0961f0d3333649ceb10a43f55747f7ac";
		RobotRequest rq=new RobotRequest();
		Map userInfo=rq.getUserInfo();
		userInfo.put("apiKey", apiKey);
		userInfo.put("userId", userId);
		
		Map perception=rq.getPerception();
		Map inputText=(Map)perception.get("inputText");
		inputText.put("text", message);
		Document doc=null;
		Connection con=Jsoup.connect(url);
		con.header("Content-Type", "application/json;charset=UTF-8");
		con.requestBody(rq.toJson());
		try {
			doc=con.post();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String text=doc.body().text();
		StringBuilder sb=new StringBuilder();
		RobotReply reply=RobotReply.getReply(text);
		List<Map> result=reply.getResults();
		for(Map m:result){
			Map values=(Map)m.get("values");
			String out=(String)values.get("text");
			sb.append(out);
		}
		return sb.toString();
	}
	
	
	
	public static void main(String[] args) {
		
		String r=new RobotServiceImpl().reply("毛泽东","bran");
		
		System.out.println(r);
		
		RobotReply reply=RobotReply.getReply(r);
		List<Map> result=reply.getResults();
		for(Map m:result){
			Map values=(Map)m.get("values");
			String text=(String)values.get("text");
			System.out.println(text);
		}
	}
}
