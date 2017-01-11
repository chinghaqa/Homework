package cheese;

//package cheese;

import java.awt.GridLayout;
import java.awt.Panel;

public class Bowl extends Panel {

	FivePanel fp[][] = new FivePanel[13][13];

	Bowl()

	{
		setLayout(new GridLayout(13, 13));
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 13; j++) {
				fp[i][j] = new FivePanel(i, j);
				add(fp[i][j]);
			}
		}
	}// end Bowl()

	public static void clear() {
		// TODO Auto-generated method stub
		System.out.println("clear");
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 13; j++) {
				FiveCheeseWindow.allCheese[i][j] = 0;
			}
		}
		// Platform.runLater(() -> {
		// try {
		// //do something...
		// } catch (Exception ex) {
		// ex.printStackTrace();
		// }
		// });
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 13; j++) {
				System.out.print(FiveCheeseWindow.allCheese[i][j] + " ");
			}
			System.out.println("");
		}

	}

}// end Bowl;