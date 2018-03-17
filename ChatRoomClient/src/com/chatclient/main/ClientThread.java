package com.chatclient.main;
/**
 * 这是客户端线程
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class ClientThread extends Thread{
	Socket socket;
	
	public ClientThread(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		
		try{
			//从键盘读取输入流转化为打印流
			BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
			String msg;
			String  username = "帅气的陈";
			
			//持续检测键盘输入，一旦有输入就传递给服务端
			while(true){
				msg = re.readLine();
				Date  msgtime= new Date();
				msg = username+":"+msg+"     发送时间："+msgtime.getTime();
				pw.println(msg);
			}
			
		}catch(Exception e){
			
		}
	}
}
