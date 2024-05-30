package jaunarajsjanvaris_pica;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class picas_aplikacija extends JFrame implements ActionListener{
	 private JTextField vardaLauks, addresesLauks, numuraLauks;
	 private JCheckBox piegadesLauks;
	    private JComboBox<String> izmers, piedevas, merce;
	    private JButton pasutijumaPoga;

	    private static final double mazaPica = 7.50;
	    private static final double videjaPica = 10.00;
	    private static final double lielaPica = 15.99;
	    private static final double piedevasCena = 3.99;
	    private static final double mercesCena = 1.99;
}
 
public class picas_aplikacija() {
	
	setTitle("Picas Pasūtīšana");
    setSize(400, 350);
    setLayout(null);
    
    JLabel nameLabel = new JLabel("Vārds:");
    nameLabel.setBounds(20, 20, 80, 25);
    add(nameLabel);
    nameField = new JTextField();
    nameField.setBounds(100, 20, 200, 25);
    add(nameField);
    
    JLabel addressLabel = new JLabel("Adrese:");
    addressLabel.setBounds(20, 50, 80, 25);
    add(addressLabel);
    addressField = new JTextField();
    addressField.setBounds(100, 50, 200, 25);
    add(addressField);
	
	
	//public static void main(String[] args) {
		//String izvele, vards, uzvards, adresse, picasNos; 

	}

}
