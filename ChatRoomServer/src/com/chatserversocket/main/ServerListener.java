package com.chatserversocket.main;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 这是一个服务端的监听器
 * 创建一个ServerSocket，等待客户端的连接
 * 若客户端连接，则为之创建一个线程，并将线程添加进消息管理器中的线程容器
 * @author HYChan
 *
 */
public class ServerListener extends Thread{
		int port;
		ServerSocket serverSocket;
		
		public void run(){
			
			try{
				port = 12345;
				serverSocket = new ServerSocket(port);	
		
				while(true){
			    
					System.out.println("服务端等待连接");
					Socket socket = serverSocket.accept();
				
					//JOptionPane.showMessageDialog(null, "有客户端连到本机12345端口");
					System.out.println("有客户端连到本机12345端口");
					System.out.println("端口为："+socket.getPort()+" ip为"+socket.getInetAddress());
				
					//每连接一个客户端，为之分配一个服务线程
					ServerThread cs = new ServerThread(socket);
					
					//将线程添加进消息管理器中的线程容器
					MessageManager.getChatManager().add(cs);
					
					//启动线程
					cs.start();	
					
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
