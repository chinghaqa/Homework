package cheese;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageBox extends Dialog {
	Label message;
	Button confirm = new Button("sure");

	MessageBox(Frame owner, String title, boolean modal, String msg) {
		super(owner, title, modal);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		message = new Label(msg);
		add(message);
		add(confirm);
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		setSize(130, 100);
		setResizable(false);
		setBounds(200, 200, 130, 100);

		show();

	}
}