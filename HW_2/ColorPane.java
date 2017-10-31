import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ColorPane extends JFrame {

	static String[] colors = { "blue", "cyan", "green", "magenta", "orange", "pink", "red", "white", "yellow" };
	final int COLOR_AMOUNT = 9;
	static Map<String,Color> hash = new HashMap<String , Color>(9){
		{
			put("blue" , Color.blue);
			put("cyan" , Color.cyan);
			put("green" , Color.green);
			put("magenta" , Color.magenta);
			put("orange" , Color.orange);
			put("pink" , Color.pink);
			put("red" , Color.red);
			put("white" , Color.white);
			put("yellow" , Color.yellow);
		}
	};
	
	JButton[] buttons = new JButton[COLOR_AMOUNT];

	public ColorPane() {
		super("ColorPane");
		setSize(1920, 1080);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 3));
		for (int i = 0; i < COLOR_AMOUNT; i++) {
			buttons[i] = new JButton(colors[i]);
			buttons[i].addActionListener(l -> {
				JButton jb = (JButton) l.getSource();
				jb.setBackground(hash.get(l.getActionCommand()));
			});
			add(buttons[i]);
		}
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ColorPane tes = new ColorPane();
	}

}
