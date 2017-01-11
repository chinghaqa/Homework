package cheese;

import java.io.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

import cheese.FivePanel.PutCheese;

import java.text.*;

public class Server {
	static ServerSocket serverSock;
	static Socket acceptSocket;
	static boolean count = true;

	public static void main(String[] args) {
		java.io.BufferedInputStream in;
		try {
			System.out.println("Server in on....");
			serverSock = new ServerSocket(8888);
			FiveCheeseWindow f = new FiveCheeseWindow();
			f.setSize(500,500);
			f.show();
			while (count) {
				acceptSocket = serverSock.accept();
				if (acceptSocket != null) {
					System.out.println("Client is connect");
					//serverSock.close();
					//in = new BufferedInputStream(FivePanel.paint());
					PrintStream writer;
					BufferedReader reader;
					
					writer = new PrintStream(acceptSocket.getOutputStream());
					
					reader = new BufferedReader(new InputStreamReader(acceptSocket.getInputStream()));
					
					
					System.out.println( reader.readLine());
					
					SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");//設定時間格式
			        String nowDate = sdFormat.format(new Date());
					writer.println("現在時間是:" + nowDate);
		            writer.flush();
		            
//		            DataInputStream in = new DataInputStream(acceptSocket.getInputStream());
//	                String msg = in.readUTF();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
