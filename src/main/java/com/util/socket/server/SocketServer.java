package com.util.socket.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer{
	

	
	public ServerSocket doListen(int port){
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			while(true){
				try {
					Socket socket = server.accept();
					new Thread(new SSocket(socket)).start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return server;
	} 
	
	class SSocket implements Runnable {
		Socket socket;
		public SSocket(Socket socket){
			this.socket = socket;
		}
		
		@Override
		public void run() {
			DataInputStream input;
	        DataOutputStream output;
			try {
				input = new DataInputStream(socket.getInputStream());
				output = new DataOutputStream(socket.getOutputStream());
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				while (true) {
					String request = input.readLine();
					output.writeUTF("111");
					//String str = in.readLine();
//					System.out.println(str);
//					out.print("has receive .....");
//					out.flush();
//					out.close();
					output.flush();
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		SocketServer server = new SocketServer();
		server.doListen(8080);
	}
}
