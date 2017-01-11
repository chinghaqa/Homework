package cheese;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

class FivePanel extends Panel {
	
	int row, column;

	public FivePanel(int row, int column) {
		this.row = row;
		this.column = column;
		setBackground(Color.gray);
		addMouseListener(new PutCheese());
	}// end FivePanel

	public void paint(Graphics g) {
		g.setColor(Color.white);
		if (row == 0 && column == 0) {
			g.drawLine(getWidth() / 2, getHeight() / 2, getWidth(), getHeight() / 2);
			g.drawLine(getWidth() / 2, getHeight() / 2, getWidth() / 2, getHeight());
		} else if (row == 0 && column == 12) {
			g.drawLine(0, getHeight() / 2, getWidth() / 2, getHeight() / 2);
			g.drawLine(getWidth() / 2, getHeight() / 2, getWidth() / 2, getHeight());
		} else if (row == 12 && column == 0) {
			g.drawLine(getWidth() / 2, getHeight() / 2, getWidth(), getHeight() / 2);
			g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight() / 2);
		} else if (row == 12 && column == 12) {
			g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight() / 2);
			g.drawLine(0, getHeight() / 2, getWidth() / 2, getHeight() / 2);
		} else if (row == 0) {
			g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			g.drawLine(getWidth() / 2, getHeight() / 2, getWidth() / 2, getHeight());
		} else if (row == 12) {
			g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			g.drawLine(getWidth() / 2, getHeight() / 2, getWidth() / 2, 0);
		} else if (column == 0) {
			g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
			g.drawLine(getWidth() / 2, getHeight() / 2, getWidth(), getHeight() / 2);
		} else if (column == 12) {
			g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
			g.drawLine(getWidth() / 2, getHeight() / 2, 0, getHeight() / 2);
		} else {
			g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
		}
		if (FiveCheeseWindow.allCheese[row][column] == 1) {
			g.setColor(Color.black);
			g.fillOval(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
		} else if (FiveCheeseWindow.allCheese[row][column] == 2) {
			g.setColor(Color.white);
			g.fillOval(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
		}

	}// end paint

	public class PutCheese extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			Graphics g = getGraphics();
			FiveCheeseWindow f = new FiveCheeseWindow();
			if(FiveCheeseWindow.cheese==1){
			System.out.println("黑棋");
			}
			else if(FiveCheeseWindow.cheese==2){
				System.out.println("白棋");
			}
			if (FiveCheeseWindow.allCheese[row][column] != 0) {
				JOptionPane.showMessageDialog(f,"此處以下過棋了",
                        "警告", JOptionPane.WARNING_MESSAGE);
				
				return; //
			}
			
			if (FiveCheeseWindow.cheese == 1) {
				g.setColor(Color.black);
				g.fillOval(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
				FiveCheeseWindow.allCheese[row][column] = 1;
			} else if (FiveCheeseWindow.cheese == 2) {
				g.setColor(Color.white);
				g.fillOval(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
				FiveCheeseWindow.allCheese[row][column] = 2;
			}

			if (checkWin(FiveCheeseWindow.cheese, row, column) == 1) {
				// System.out.println("win");
				MessageBox dl = new MessageBox(FiveCheeseWindow.five, "Backgammon", true, "       black win!      ");
			} else if (checkWin(FiveCheeseWindow.cheese, row, column) == 2) {
				MessageBox dl = new MessageBox(FiveCheeseWindow.five, "Backgammon", true, "       white win!      ");
			}

			if (FiveCheeseWindow.cheese == 1) {
				FiveCheeseWindow.cheese = 2;
			} else {
				FiveCheeseWindow.cheese = 1;
			}

			for (int i = 0; i < 13; i++) {
				for (int j = 0; j < 13; j++) {
					System.out.print(FiveCheeseWindow.allCheese[i][j] + " ");
				}
				System.out.println("");
			}

		}// end mouseClicked()

	}// end PutCheese
		// *************************

	public int checkWin(int che, int row, int column) {
		int startRow = 0;
		int startColumn = 0;
		int line = 0;

		System.out.println("Piece for:" + che + ",row=" + row + ",column=" + column);

		startRow = row;
		startColumn = column;
		while (true) {
			if ((startRow == 0) || (startColumn == 0)) {
				break;
			} else {
				startRow--;
				startColumn--;
			}
		}
		while (true) {
			if ((startRow == 12) || (startColumn == 12) || (line >= 5))
				break;//
			if (FiveCheeseWindow.allCheese[startRow][startColumn] == che) {
				line++;
				System.out.print(line);
			} else {
				line = 0;
			}
			startRow++;
			startColumn++;
		}
		System.out.println("Left slash:" + line);
		if (line >= 5)
			return che;
		else
			line = 0;

		startRow = row;
		startColumn = column;
		while (true) {
			if ((startRow == 0) || (startColumn == 12)) {
				break;
			} else {
				startRow--;
				startColumn++;
			}
		}

		while (true) {
			if ((startRow == 12) || (startColumn == 0) || (line >= 5))
				break;//
			if (FiveCheeseWindow.allCheese[startRow][startColumn] == che) {
				line++;
				System.out.print(line);
			} else {
				line = 0;
			}
			startRow++;
			startColumn--;
		}
		System.out.println("Right slash:" + line);
		if (line >= 5)
			return che;
		else
			line = 0;

		startRow = row;
		startColumn = 0;
		while (true) {
			if ((startColumn == 12) || (line >= 5))
				break;
			if (FiveCheeseWindow.allCheese[startRow][startColumn] == che) {
				line++;
				System.out.print(FiveCheeseWindow.allCheese[startRow][startColumn]);
				System.out.println("");
				System.out.print(line);
			} else {
				line = 0;
			}
			startColumn++;
		}
		System.out.println("Horizontal lINE:" + line);
		if (line >= 5)
			return che;
		else
			line = 0;

		startRow = 0;
		startColumn = column;
		while (true) {
			if ((startRow == 12) || (line >= 5))
				break;
			if (FiveCheeseWindow.allCheese[startRow][startColumn] == che) {
				line++;
				System.out.print(line);
			} else {
				line = 0;
			}
			startRow++;
		}
		System.out.println("Vertical line:" + line);
		if (line >= 5)
			return che;
		else
			line = 0;

		return 0;
	}// end checkWin()

	class MessageBox extends Dialog {
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
}// end FivePanel