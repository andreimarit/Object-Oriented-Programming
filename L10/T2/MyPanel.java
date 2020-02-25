import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyPanel extends JPanel {
	
	int cnt = 0;
	JLabel l;
	JTextField tf;
	MyDrawPanel p;

	public static void main(String[] args) {
		
		MyPanel ex = new MyPanel();
		ex.go();
		
   	 }
	
	public void go() {
		
		JFrame frame = new JFrame ("Simple Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		 l = new JLabel ("Label1 ");
		 tf = new JTextField("TextField1");
		panel1.add(l);
		panel1.add(tf);
		panel1.setLayout(new FlowLayout());
		
		JButton b1 = new JButton("Button 1");
		JButton b2 = new JButton("Button 2");
		JButton b3 = new JButton("Button 3");
		
		b1.addActionListener(new Button1Listener());
		b2.addActionListener(new Button2Listener());
		b3.addActionListener(new Button3Listener());
		
		panel2.add(b1);
		panel2.add(b2);
		panel2.add(b3);
		
		p = new MyDrawPanel();
		p.add(panel1);
		p.add(panel2);
		
		frame.setContentPane(p);
		frame.setVisible(true);
	}
	
	class Button1Listener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			cnt++;
			l.setText("" + cnt);
		}
	}
	
	class Button2Listener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String text = tf.getText();
			if(text != null) {
				l.setText(text);
			}
		}
	}
	
	class Button3Listener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			p.repaint();
		}
	}
}
