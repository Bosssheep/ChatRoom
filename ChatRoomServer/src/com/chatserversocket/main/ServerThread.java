package com.chatserversocket.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 为每个客户端分配一个线程，并进行消息的传送
 * @author HYChan
 *
 */
class ServerThread extends Thread{
	
	Socket socket ;
	
	public ServerThread(Socket socket){
		this.socket = socket;
	}

	//服务器会不断地从客户端读取内容，把读取到的内容发给集合内所有的客户端。
	public void run(){
		
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try{
			
			//接收数据
			isr = new InputStreamReader(socket.getInputStream());
			br = new BufferedReader(isr);
			String info = null;
			
			//发送数据
			while((info = br.readLine()) != null){
				System.out.println("客户端说："+info);
				MessageManager.getChatManager().sendMessage(this, info);
				
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//将内容发送给客户端
	public void sendMessage(String out){
		try{
			
			socket.getOutputStream().write(out.getBytes("UTF-8"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}