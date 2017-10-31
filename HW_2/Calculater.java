import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Calculater extends JFrame{

	JPanel grid = new JPanel(new GridLayout(4, 4));
	JTextField text = new JTextField();
	BorderLayout layout = new BorderLayout();
	static String[] ops = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+",};
	JButton[] buttons = new JButton[16];
	public Calculater() {
		super("Calculator");
		setSize(1920, 1080);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		text.setPreferredSize(new Dimension(1920, 100));
		setLayout(layout);
		add(text , BorderLayout.NORTH);
		for (int i = 0 ; i < 16 ; i++) {
			buttons[i] = new JButton(ops[i]);
			grid.add(buttons[i]);
		}
		add(grid , BorderLayout.CENTER);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculater tes = new Calculater();
	}

}
