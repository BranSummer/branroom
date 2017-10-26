package org.bran.branroom.websocket;

import java.io.IOException;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bran.branroom.dto.ChatMessage;
import org.bran.branroom.entity.User;


/**
 * 
 * @ClassName: WebSocketServer
 * @Description: TODO
 * @author: BranSummer
 * @date: 2017/10/07 11:50:43
 */
@ServerEndpoint(value="/server/{userParam}")
public class WebSocketServer {
	
	private static int onlineCount=0;
	
	private static CopyOnWriteArraySet<WebSocketServer> webSocketSet=new CopyOnWriteArraySet<WebSocketServer>();
	
	private Session wsSession;
	
	private User user;
	
	private static ConcurrentHashMap<User,Session> map=new ConcurrentHashMap<User,Session>();
	
	private static Vector<User> onlineList=new Vector<User>();
	
	private static final Logger LOGGER=LogManager.getLogger(WebSocketServer.class.getName());
	
	private static synchronized void addOnlineCount(){
		onlineCount++;
	}
	
	private static synchronized void subOnlineCount(){
		onlineCount--;
	}
	
	private static synchronized int getOnlineCount(){
		return onlineCount++;
	}
	
	
	//get the user through userId
	private User getUserById(String userId){
		User user=new User();
		//TODO
		return user;
	}
	
	//send message to client
	private void sendMessage(String message){
		try {
			this.wsSession.getBasicRemote().sendText(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//broadcast message
	private void broadcast(String message){
		for(WebSocketServer item:webSocketSet){
			item.sendMessage(message);
		}
	}
	
	/**
	 * 
	 * @Title: onOpen
	 * @Description: TODO
	 * @param userParam
	 * @param wsSession
	 * @return: void
	 */
	@OnOpen
	public void onOpen(@PathParam("userParam")String userParam,Session wsSession){
		this.wsSession=wsSession;
		user=getUserById(userParam);
		webSocketSet.add(this);
		addOnlineCount();
		map.put(user, wsSession);
		onlineList.add(user);
		String message=new ChatMessage("add",user,ChatMessage.TYPE_SYS,onlineList).toJson();
		broadcast(message);
		LOGGER.info("New connection added ["+userParam+"], Number of Online users:"+getOnlineCount());

	}
	
	/**
	 * 
	 * @Title: onClose
	 * @Description: TODO
	 * @return: void
	 */
	@OnClose
	public void onClose(){
		map.remove(user);
		onlineList.remove(user);
		webSocketSet.remove(this);
		subOnlineCount();
		String message=new ChatMessage("remove",user,ChatMessage.TYPE_SYS,onlineList).toJson();
		broadcast(message);
		LOGGER.info("One connection removed"+user.getUserId()+", Number of Online users:"+getOnlineCount());
	}
	
	/**
	 * 
	 * @Title: OnMessage
	 * @Description: TODO
	 * @param message
	 * @param session
	 * @return: void
	 */
	@OnMessage
	public void OnMessage(String message,Session session){
		broadcast(message);
	}
	
	/**
	 * 
	 * @Title: onError
	 * @Description: TODO
	 * @param session
	 * @param error
	 * @return: void
	 */
	@OnError
	public void onError(Session session,Throwable error){
		error.printStackTrace();
	}
}
