import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

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
		Myevent perform = new Myevent();
		for (int i = 0 ; i < 16 ; i++) {
			buttons[i] = new JButton(ops[i]);
			buttons[i].addActionListener(perform);
			grid.add(buttons[i]);
		}
		add(grid , BorderLayout.CENTER);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculater tes = new Calculater();
	}

	public class Myevent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String whichButton = e.getActionCommand();
			if (whichButton.charAt(0) == '=') {
				String form = text.getText();
				Calform c = new Calform();
				text.setText(form + "=" + c.calform(form));
			} else {
				text.setText(text.getText() + whichButton);
			}
		}
	}
	public static class Calform {
		public String calform(String form) {
			FormTree t = new FormTree(form);
			String res;
			if (t.isFloat == true) {
				res = "" + t.docal(t.TreeHead).floatValue();
			} else {
				res = "" + t.docal(t.TreeHead).intValue();
			}
			return res;
		}
		class FormTree {
			ArrayList<Token> list = new ArrayList<Token>();
			Node TreeHead = null;
			boolean isFloat = false;
			public FormTree(String s) {
				getTokenList(s);
				TreeHead = makeTree();
			}
			public Number docal (Node n) {
				if (n.val.TypeName != "Operater") {
					if (n.val.TypeName == "Float") {
						return new Float(n.val.value);
					} else {
						return new Integer(n.val.value);
					}
				}
				Number left,right,res;
				left = right = res = null;
					left = docal(n.left);
					right = docal(n.right);
				if (isFloat == true) {
					switch(n.val.value) {
					case "+":res = left.floatValue() + right.floatValue();break;
					case "-":res = left.floatValue() - right.floatValue();break;
					case "*":res = left.floatValue() * right.floatValue();break;
					case "/":res = left.floatValue() / right.floatValue();break;
					}
				} else {
					switch(n.val.value) {
					case "+":res = (left.intValue() + right.intValue());break;
					case "-":res = (left.intValue() - right.intValue());break;
					case "*":res = (left.intValue() * right.intValue());break;
					case "/":res = (left.intValue() / right.intValue());break;
					}
				}
				System.out.println("left = " + left.floatValue() + " rihgt : " + right.floatValue() + " res = " + res.floatValue());
				return res;
			}
			class Token {
				public String TypeName , value;
				Token(String type , String value) {
					TypeName = type;
					this.value = value;
				}
			}
			class Node {
				public Token val;
				public Node left , right;
				public Node(Token val) {
					// TODO Auto-generated constructor stub
					left = right = null;
					this.val = val;
				}
			}
			private Node makeTree() {
				Stack<Node> nums = new Stack<Node>();
				Stack<Node> ops = new Stack<Node>();
				for (int i = 0 ; i < list.size() ; i++) {
					if (list.get(i).TypeName.equals("Operater")) {
						switch (list.get(i).value) {
						case "+":
						case "-":
							while (ops.empty() != true && (ops.peek().val.value.equals("*") || ops.peek().val.value.equals("/"))) {
								Node temp = ops.pop();
								temp.right = nums.pop();
								temp.left = nums.pop();
								nums.push(temp);
							}
							ops.push(new Node(list.get(i)));
							break;
							
						case "*":
						case "/":
							ops.push(new Node(list.get(i)));
							break;
						default:
							break;
						}
					} else {
						if (list.get(i).TypeName.equals("Float")) {
							isFloat = true;
						}
						nums.push(new Node(list.get(i)));
					}
				}
				while (ops.empty() != true) {
					Node temp = ops.pop();
					temp.right = nums.pop();
					temp.left = nums.pop();
					nums.add(temp);
				}
				return nums.peek();
			}
			private void getTokenList(String s) {
				for (int i = 0 ; i < s.length() ; ) {
					if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
						int j = i;
						String type = "Integer";
						while (j < s.length()) {
							 if ((s.charAt(j) >= '0' && s.charAt(j) <= '9') || s.charAt(j) == '.') {
								 if (s.charAt(j) == '.') {
									 if (type.equals("Float")) {
										 System.out.println("Wrong Input");
									 } else {
										 type = "Float";
									 }
								 }
								 j++;
							 } else {
								 break;
							 }
						}
						list.add(new Token(type, s.substring(i, j)));
						i = j;
					} else {
						list.add(new Token("Operater", s.substring(i, i + 1)));
						i++;
					}
				}
			}
		}
	}
}
