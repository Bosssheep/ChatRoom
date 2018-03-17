package com.chatclient.main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 从这里启动一个客户端
 * @author HYChan
 *
 */
public class StartClent {

	public static void main(String[] args) {
		
		 
		 String ip = "localhost";
		 int port = 12345;

		 try {
			Socket socket = new Socket(ip,port);
			new ClientThread(socket).start();
			
			//从服务端中输入到客户端
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg = null;
			while((msg = br.readLine())!=null){
				System.out.println(msg);
			}
/*			//输出流
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.write("我是一个客户端1。我想进行聊天");
			pw.flush();
			//socket.shutdownOutput();
			
			//输入流
			InputStreamReader is = new InputStreamReader(socket.getInputStream());
			BufferedReader bf = new BufferedReader(is);
			
			String line = null;
			while((line = bf.readLine())!=null){
				System.out.println(line);
			}
			
			is.close();
			pw.close();*/
			//socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
