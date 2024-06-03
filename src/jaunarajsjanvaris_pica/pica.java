package jaunarajsjanvaris_pica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class PicasAplikacija extends JFrame implements ActionListener {
    
	private static final long serialVersionUID = 1L;
	private JTextField vardaLauks, addresesLauks, numuraLauks;
    private JCheckBox piegadesLauks;
    private JComboBox<String> izmers, piedevas, merce;
    private JButton pasutijumaPoga;
    private JLabel imageLabel;

    private static final double mazaPica = 7.50;
    private static final double videjaPica = 10.00;
    private static final double lielaPica = 15.99;
    private static final double piedevasCena = 3.99;
    private static final double mercesCena = 1.99;

    public PicasAplikacija() {
        setTitle("Picas Pasūtīšana");
        setSize(700, 380);
        setLayout(null);
        
        getContentPane().setBackground(new Color(255, 140, 80));

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
        izmers.addActionListener(this);
        add(izmers);

        JLabel piedevasLabel = new JLabel("Piedevas:");
        piedevasLabel.setBounds(20, 170, 80, 25);
        add(piedevasLabel);
        piedevas = new JComboBox<>(new String[]{"Šampinjoni - 3.99€", "Olivas - 3.99€", "Nav"});
        piedevas.setBounds(100, 170, 200, 25);
        piedevas.addActionListener(this);
        add(piedevas);

        JLabel merceLabel = new JLabel("Mērce:");
        merceLabel.setBounds(20, 200, 80, 25);
        add(merceLabel);
        merce = new JComboBox<>(new String[]{"Tomātu - 1.99€", "Majonēze - 1.99€", 
        		"Siera mērce - 1.99€", "Nav"});
        merce.setBounds(100, 200, 200, 25);
        merce.addActionListener(this);
        add(merce);
        
        imageLabel = new JLabel();
        imageLabel.setBounds(280, 5, 400, 400);
        imageLabel.setIcon(new ImageIcon("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\images\\mazaPica.png"));
        add(imageLabel);

        pasutijumaPoga = new JButton("Pasūtīt");
        pasutijumaPoga.setBounds(150, 240, 100, 25);
        pasutijumaPoga.addActionListener(this);
        add(pasutijumaPoga);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == izmers) {
                String selectedSize = (String) izmers.getSelectedItem();
                switch (selectedSize) {
                    case "Mazā - 7.50€":
                        imageLabel.setIcon(new ImageIcon("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\images\\mazaPica.png"));
                        break;
                    case "Vidējā - 10.00€":
                        imageLabel.setIcon(new ImageIcon("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\images\\videjaPica.png"));
                        break;
                    case "Lielā - 15.99€":
                        imageLabel.setIcon(new ImageIcon("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\images\\LielaPica.png"));
                        break;
                }
                
            } else if (e.getSource() == piedevas) {
                String selectedPiedevas = (String) piedevas.getSelectedItem();
                switch (selectedPiedevas) {
                    case "Šampinjoni - 3.99€":
                        imageLabel.setIcon(new ImageIcon("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\images\\senes1.png"));
                        break;
                    case "Olivas - 3.99€":
                        imageLabel.setIcon(new ImageIcon("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\images\\olive1.png"));
                        break;
                    case "Nav":
                        imageLabel.setIcon(null);
                        break;
                }
                
            } else if (e.getSource() == merce) {
                String selectedMerce = (String) merce.getSelectedItem();
                switch (selectedMerce) {
                    case "Tomātu - 1.99€":
                        imageLabel.setIcon(new ImageIcon("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\images\\tomato1.png"));
                        break;
                    case "Majonēze - 1.99€":
                        imageLabel.setIcon(new ImageIcon("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\images\\mayo1.png"));
                        break;
                    case "Siera mērce - 1.99€":
                        imageLabel.setIcon(new ImageIcon("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\images\\siera1.png"));
                        break;
                    case "Nav":
                        imageLabel.setIcon(null);
                        break;
                }
                
            } else if (e.getSource() == pasutijumaPoga) {
                String vards = vardaLauks.getText();
                String addrese = addresesLauks.getText();
                String numurs = numuraLauks.getText();
                boolean piegade = piegadesLauks.isSelected();
                String izmeri = (String) izmers.getSelectedItem();
                String piedeva = (String) piedevas.getSelectedItem();
                String merces = (String) merce.getSelectedItem();

            double kopejasIzmaksas = kopIzmaksas(izmeri, piedeva, merces, piegade);

            ierakstitFaila(vards, addrese, numurs, piegade, izmeri, piedeva, merces, kopejasIzmaksas);

            JOptionPane.showMessageDialog(this, "Jūsu pasūtījums ir noformēts.\nKopējā cena: €"
                    + String.format("%.2f", kopejasIzmaksas));

            vardaLauks.setText("");
            addresesLauks.setText("");
            numuraLauks.setText("");
            piegadesLauks.setSelected(false);
            izmers.setSelectedIndex(0);
            piedevas.setSelectedIndex(0);
            merce.setSelectedIndex(0);
            imageLabel.setIcon(new ImageIcon("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\images\\mazaPica.png"));
        }
    }

    private double kopIzmaksas(String lielums, String piedevas, String merce, boolean piegade) {
        double izmeraCena = lielumaCena(lielums);
        double piedevuCena = piedevuCena(piedevas);
        double mercesCena = mercesCena(merce);

        double kopejasIzmaksas = izmeraCena + piedevuCena + mercesCena;

        if (piegade)
            kopejasIzmaksas += 3.15;
        return kopejasIzmaksas;
    }

    private double lielumaCena(String lielums) {
        switch (lielums) {
            case "Mazā - 7.50€":
                return mazaPica;
            case "Vidējā - 10.00€":
                return videjaPica;
            case "Lielā - 15.99€":
                return lielaPica;
            default:
                return 0.0;
        }
    }

    private double piedevuCena(String piedevas) {
        switch (piedevas) {
            case "Šampinjoni - 3.99€":
            case "Olivas - 3.99€":
                return piedevasCena;
            default:
                return 0.0;
        }
    }

    private double mercesCena(String merce) {
        switch (merce) {
            case "Tomātu - 1.99€":
            case "Majonēze - 1.99€":
            case "Siera mērce - 1.99€":
                return mercesCena;
            default:
                return 0.0;
        }
    }

    private void ierakstitFaila(String vards, String addrese, String numurs, boolean piegade,
                                String izmeri, String piedeva, String merce, double kopejasIzmaksas) {
        try (FileWriter w = new FileWriter("pasutijums.txt", true)) {
            w.write(vards+", "+addrese+", "+numurs+", "+piegade+", "+izmeri+
                    ", "+piedeva+", "+merce+", "+kopejasIzmaksas+"\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

public class pica {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PicasAplikacija aplikacija = new PicasAplikacija();
            aplikacija.setVisible(true);
        });
    }
}