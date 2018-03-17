package com.chatserversocket.main;
/**
 * 这里是服务端启动的地方
 * @author HYChan
 *
 */
public class MyServerSocket {

	public static void main(String[] args){
		ServerListener listener = new ServerListener();
		System.out.println("打开监听器");
		listener.start();
	}
}
