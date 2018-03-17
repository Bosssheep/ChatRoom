package com.chatserversocket.main;

import java.util.Vector;

/**
 * 这是一个消息管理器，负责客户端之间消息的传送
 * @author HYChan
 *
 */
public class MessageManager {

	private static final MessageManager CM = new MessageManager();
	
	//线程容器
	Vector<ServerThread> vector = new Vector<ServerThread>();
	
	private MessageManager(){}
	
	public static MessageManager getChatManager(){
		return CM;
	}
	
	public void add(ServerThread cs){
		vector.add(cs);
	}
	
	//将消息发送给除了发送源的所有客户端
	public void sendMessage(Thread cs,String msg){
		System.out.println("message Manager 要发消息给小伙伴们啦");
		for(int i = 0;i < vector.size();i++){
			ServerThread csTemp = vector.get(i);
			csTemp.sendMessage(msg+"\n");
			
		}
	}
	
}
