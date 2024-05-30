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
 
	public picas_aplikacija() {
	
	setTitle("Picas Pasūtīšana");
    setSize(400, 350);
    setLayout(null);
    
    JLabel vardaLabel = new JLabel("Vārds:");
    vardaLabel.setBounds(20, 20, 80, 25);
    add(vardaLabel);
    vardaLauks = new JTextField();
    vardaLauks.setBounds(100, 20, 200, 25);
    add(vardaLauks);
    
    JLabel addresesLabel = new JLabel("Adrese:");
    addresesLabel.setBounds(20, 50, 80, 25);
    add(addresesLabel);
    addresesLauks = new JTextField();
    addresesLauks.setBounds(100, 50, 200, 25);
    add(addresesLauks);
    
    JLabel telNrLabel = new JLabel("Tālrunis:");
    telNrLabel.setBounds(20, 80, 80, 25);
    add(telNrLabel);
    numuraLauks = new JTextField();
    numuraLauks.setBounds(100, 80, 200, 25);
    add(numuraLauks);
    
    piegadesLauks = new JCheckBox("Piegāde");
    piegadesLauks.setBounds(20, 110, 100, 25);
    add(piegadesLauks);
    
    JLabel izmersLabel = new JLabel("Izmērs:");
    izmersLabel.setBounds(20, 140, 80, 25);
    add(izmersLabel);
    izmers = new JComboBox<>(new String[]{"Mazā - 7.50€", "Vidējā - 10.00€", "Lielā - 15.99€"});
    izmers.setBounds(100, 140, 200, 25);
    add(izmers);
    
    JLabel piedevasLabel = new JLabel ("Piedevas:");
    piedevasLabel.setBounds(20, 170, 80, 25);
    add(piedevasLabel);
    piedevas = new JComboBox<>(new String[] {"Šampinjoni - 3.99€", "Olivas - 3.99€",
    		"Siera mērce - $1.50", "Nav"});
    
    JLabel merceLabel = new JLabel ("Mērce: ");
    merceLabel.setBounds(20, 200, 80, 25);
    add(merceLabel);
    merce = new JComboBox<>(new String[]{"Tomātu - 1.99€", "Baltā - 1.99€", "Siera mērce - 1.99€", "Nav"});
    merce.setBounds(100, 200, 200, 25);
    add(merce);
    
	
	
	//public static void main(String[] args) {
		//String izvele, vards, uzvards, adresse, picasNos; 

	}

}
