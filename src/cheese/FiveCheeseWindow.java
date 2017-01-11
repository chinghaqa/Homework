package cheese;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FiveCheeseWindow extends Frame {
	public static FiveCheeseWindow five;
	private Bowl bowl = new Bowl();
	private ControlPanel cp;
	public static int cheese = 0;
	//static boolean cheese = true;
	//boolean cheese;
	public static int allCheese[][] = new int[13][13];

	public FiveCheeseWindow() {
		initComp();
	}

	private void initComp() {
		five = this;
		cp = new ControlPanel(five, bowl);
		setLayout(new BorderLayout());
		add(bowl, BorderLayout.CENTER);
		add(cp, BorderLayout.EAST);
		addWindowListener(new FiveWindowLinstener());
		setTitle("Backgammon");

		this.setResizable(false);
	}

	public class FiveWindowLinstener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			dispose();
			System.exit(0);
		}
	}
}
