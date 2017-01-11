package cheese;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControlPanel extends Panel {
	protected static final String Five = null;
	Socket sock;
	CheckboxGroup cbg = new CheckboxGroup();

	Checkbox cb1 = new Checkbox("black first", cbg, true);
	Checkbox cb2 = new Checkbox("white first", cbg, false);
	Button b1 = new Button("start");
	Button b2 = new Button("restart");
	Button b3 = new Button("help");
	Button b4 = new Button("exit");
	Button connect = new Button("Connect");
	Label display = new Label("");
	// TextArea ta1 = new TextArea();
	TextField client = new TextField();

	ControlPanel(final FiveCheeseWindow five, final Bowl bowl) {

		setLayout(new GridLayout(10, 1, 10, 10));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (cb1.getState()) {
					FiveCheeseWindow.cheese = 1;
					display.setText("現在黑棋先");
				} else {
					FiveCheeseWindow.cheese = 2;
					display.setText("現在白棋先");
				}
				cb1.setEnabled(false);
				cb2.setEnabled(false);
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				cb1.setEnabled(true);
				cb2.setEnabled(true);
				bowl.clear();
				five.add(bowl, BorderLayout.CENTER);
				// client.send2client("@#comsgDialog");
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				JOptionPane.showMessageDialog(b3, "直線斜線五個連成線即獲勝", "help", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				System.exit(0);
			}
		});
		connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				try {
					sock = new Socket("127.0.0.1", 8888);
//					while (true) {
//						checkSock(sock);
//					}
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		add(cb1);
		add(cb2);
		add(display);
		add(new Label("ip:"));
		add(client);
		add(connect);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		setBounds(0, 0, 200, 500);

	}

//	public void checkSock(Socket sock) {
//		try {
//			if (sock != null) {
//				PrintStream writer;
//				writer = new PrintStream(sock.getOutputStream());
//				BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
//				writer.println();
//				writer.flush();
//				
//				
//				
//				System.out.println("Server:" + reader.readLine());
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

}