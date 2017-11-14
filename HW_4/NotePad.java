
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class NotePad  extends JFrame{

	JPanel text = new JPanel(new FlowLayout());
	JPanel buttons = new JPanel(new FlowLayout());
	JTextArea content = new JTextArea(1920 , 100);
	JButton OpenText = new JButton("Open Text");
	JButton WriteText = new JButton("Write Text");
	File TextFile = null;
	String buffer = null;
	public NotePad() {
		// TODO Auto-generated constructor stub
		super("NotePad");
		this.setSize(1920, 1080);
		this.setLayout(new GridLayout(2,1));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		content.setEditable(true);
		content.setText("Hello Welcome to my experimental NotePad , click \"OpenText\" Button to open a file , and \"WriteText\" to save.");
		text.add(content);
		OpenText.addActionListener(new Read());
		WriteText.addActionListener(new Write());
		buttons.add(OpenText);
		buttons.add(WriteText);
		this.add(text);
		this.add(buttons);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NotePad tes = new NotePad();
	}

	class Read implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JFileChooser j = new JFileChooser();
			j.showOpenDialog(null);
			File temp = null;
			if ((temp = j.getSelectedFile()) == null) {
				JOptionPane.showMessageDialog(null, "Didn't select File");
				return;
			}
			if (temp.isFile() == false) {
				JOptionPane.showMessageDialog(null, "What you select isn't a file.");
				return;
			}
			TextFile = temp;
			buffer = new String();
			BufferedReader buffRead = null;
			String t = null;
			try {
				buffRead = new BufferedReader(new FileReader(TextFile));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (true) {
				try {
					t =  buffRead.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.exit(-1);
				}
				if (t == null) {
					break;
				}
				buffer = buffer + t + '\n';
			}
			content.setText(buffer);
			buffer = null;
		}
	}
	class Write implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (TextFile == null) {
				JOptionPane.showMessageDialog(null, "Didn't Open a file");
				return;
			}
			buffer = content.getText();
			try {
				FileWriter w = new FileWriter(TextFile);
				w.write(buffer);
				w.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(-1);
			}
			buffer = null;
		}
	}
}
