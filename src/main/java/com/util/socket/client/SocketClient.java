package com.util.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
	
	public static void main(String[] args) {
		OutputStream out = null;
		InputStream in = null;
		BufferedReader br = null;
		String postBody = "nihao";
		String encode = "utf-8";
		String result = null;
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 8080);
			socket.setKeepAlive(true);
			socket.setSoTimeout(20000);
			out = socket.getOutputStream();
			out.write(postBody.getBytes(encode));
			out.flush();
			int BUFFER_SIZE = 1024 * 1024;
			char[] data = new char[BUFFER_SIZE];
			in = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(in, encode));
			int len = br.read(data);
			if (len > 0){
				result = String.valueOf(data, 0, len);
			}
			
			System.out.println(result);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (in !=  null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
 