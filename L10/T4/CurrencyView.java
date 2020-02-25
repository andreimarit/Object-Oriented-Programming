import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class CurrencyView extends JFrame{
	
	private JLabel l_currencyLabel = new JLabel("1 EUR = 4.4694 RON");
    private JLabel l_from          = new JLabel("EUR - Euro");
    private JLabel l_to            = new JLabel("RON - Leul Romanesc");
    private JButton b_convert      = new JButton(">>");
    private JTextField	t_suma	   = new JTextField(6);
    private JTextField	t_rez	   = new JTextField(6);
    private JLabel	l_suma         = new JLabel("Suma:");
    private JLabel	l_rezultat     = new JLabel("Rezultat:");
    private JLabel	l_moneyFrom	   = new JLabel("EUR");
    private JLabel	l_moneyTo      = new JLabel("RON");
    
    private String[] titleString = {"1 RON = 1 RON", "1 RON = 0.2152 EUR", "1 RON = 0.2458 USD", "1 EUR = 4.4694 RON", "1 EUR = 1 EUR", "1 EUR = 1.1418 USD", "1 USD = 4.0688 RON", "1 USD = 0.8758 EUR", "1 USD = 1 USD"};

    
    CurrencyView(){
    	
    	String[] currString = {"RON - Leul Romanesc", "EUR - Euro", "USD - Dolarul SUA"};
    	
    	JComboBox currListFrom = new JComboBox(currString);
    	currListFrom.setSelectedIndex(1);
    	currListFrom.addActionListener(new ComboBoxFromListener());
    	
    	JComboBox currListTo = new JComboBox(currString);
    	currListTo.setSelectedIndex(0);
    	currListTo.addActionListener(new ComboBoxToListener());
    	
    	Font bigFont = new Font("Arial", Font.ITALIC, 24);
    	l_currencyLabel.setFont(bigFont);
    	l_currencyLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	
    	JPanel southPanel = new JPanel();
    	southPanel.setLayout(new GridLayout(2, 3));
    	southPanel.add(l_suma);
    	southPanel.add(t_suma);
    	southPanel.add(l_moneyFrom);
    	southPanel.add(l_rezultat);
    	southPanel.add(t_rez);
    	southPanel.add(l_moneyTo);
        
        JPanel centerPanel = new JPanel();
        b_convert.setHorizontalAlignment(SwingConstants.CENTER);
        b_convert.setVerticalAlignment(SwingConstants.CENTER);
        centerPanel.add(b_convert);
        
        JPanel westPanel = new JPanel();
        westPanel.add(currListFrom);
        
        JPanel eastPanel = new JPanel();
        eastPanel.add(currListTo);
    	
    	JPanel content = new JPanel();
    	content.setLayout(new BorderLayout());
    	content.add(BorderLayout.NORTH,l_currencyLabel);
    	content.add(BorderLayout.WEST,westPanel);
    	content.add(BorderLayout.CENTER,centerPanel);
    	content.add(BorderLayout.EAST,eastPanel);
    	content.add(BorderLayout.SOUTH,southPanel);
    
    	
    	this.setContentPane(content);
        this.pack();
        this.setSize(new Dimension(500, 210));
        
        this.setTitle("Simple Currency Converter - MVC");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    }
    
	public class ComboBoxFromListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        JComboBox cb = (JComboBox)e.getSource();
	        String currName = (String)cb.getSelectedItem();
	        l_from.setText(currName);
	    }
	}

	public class ComboBoxToListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        JComboBox cb = (JComboBox)e.getSource();
	        String currName = (String)cb.getSelectedItem();
	        l_to.setText(currName);
	    }
	}
	
	public JLabel getL_from() {
		return l_from;
	}

	public JLabel getL_to() {
		return l_to;
	}

	public JTextField getT_suma() {
		return t_suma;
	}

	public void setT_rez(String t_rez) {
		this.t_rez.setText(t_rez);
	}
    
	public void setl_moneyFrom(String text) {
		this.l_moneyFrom.setText(text);
	}
	
	public void setl_moneyTo(String text) {
		this.l_moneyTo.setText(text);
	}
    
	public void setl_currencyLabel(int x) {
		this.l_currencyLabel.setText(this.titleString[x]);
	}
	
	 void showError(String errMessage) {
	        JOptionPane.showMessageDialog(this, errMessage);
	   }
	 
	 void addConvertListener(ActionListener conv) {
	        b_convert.addActionListener(conv);
	    }
}
