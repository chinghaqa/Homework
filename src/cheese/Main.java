package cheese;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
	Socket sock;

	public static void main(String[] args) {
		FiveCheeseWindow f = new FiveCheeseWindow();
		f.setSize(500, 500);
		f.show();
		
		

	

//	private static void run() {
//		// TODO Auto-generated method stub
//		try {
//			sock = new Socket("127.0.0.1", 8888);
//		}
//			if(sock!=null){
//			PrintStream writer = new PrintStream(sock.getOutputStream());	
//			BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
//			
//			  writer.println("現在時間是？");
//                writer.flush();
//                System.out.println("Server:" + reader.readLine());
//			}
//		}
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		
//	}
}
}