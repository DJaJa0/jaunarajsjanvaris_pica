package jaunarajsjanvaris_pica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class PicasAplikacija extends JFrame implements ActionListener{
    
	private static final long serialVersionUID = 1L;
	private JTextField vardaLauks, addresesLauks, numuraLauks, picasDaudzumaLauks;
    private JCheckBox piegadesLauks;
    private JComboBox<String> izmers, piedevas, merce;
    private JButton pasutijumaPoga;
    private JLabel imageLabel;
    private JLabel cenaLabel;

    private static final double mazaPica = 7.50;
    private static final double videjaPica = 10.00;
    private static final double lielaPica = 15.99;
    private static final double piedevasCena = 3.99;
    private static final double mercesCena = 1.99;

    public PicasAplikacija(){
        setTitle("Picas Pasūtīšana");
        setSize(700, 380);
        setLayout(null);
        
        getContentPane().setBackground(new Color(255, 140, 80));

        JLabel vardaLabel = new JLabel("Vārds:");
        vardaLabel.setBounds(20, 20, 80, 25);
        add(vardaLabel);
        vardaLauks = new JTextField();
        vardaLauks.setBounds(84, 20, 200, 25);
        add(vardaLauks);
        
        vardaLauks.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                skana("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\audio\\click2.wav");
            }
            public void focusLost(FocusEvent e){
                
            }
        });

        JLabel addresesLabel = new JLabel("Adrese:");
        addresesLabel.setBounds(20, 50, 80, 25);
        add(addresesLabel);
        addresesLauks = new JTextField();
        addresesLauks.setBounds(84, 50, 200, 25);
        add(addresesLauks);
        
        addresesLauks.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e) {
                skana("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\audio\\click2.wav");
            }
            public void focusLost(FocusEvent e){
                
            }
        });

        JLabel telNrLabel = new JLabel("Tālrunis:");
        telNrLabel.setBounds(20, 80, 80, 25);
        add(telNrLabel);
        numuraLauks = new JTextField();
        numuraLauks.setBounds(84, 80, 200, 25);
        add(numuraLauks);
        
        numuraLauks.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e) {
                skana("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\audio\\click2.wav");
            }
            public void focusLost(FocusEvent e){
                
            }
        });
        

        piegadesLauks = new JCheckBox("Piegāde 3.15 €");
        piegadesLauks.setBounds(20, 110, 110, 25);
        piegadesLauks.setOpaque(true); 
        piegadesLauks.setBackground(new Color(255, 140, 80));
        add(piegadesLauks);
        
        piegadesLauks.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                if (e.getStateChange() == ItemEvent.SELECTED){
                    skana("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\audio\\click2.wav");
                }else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    skana("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\audio\\click2.wav");
                }
            }
        });

        JLabel izmersLabel = new JLabel("Izmērs:");
        izmersLabel.setBounds(20, 140, 80, 25);
        add(izmersLabel);
        izmers = new JComboBox<>(new String[]{"Mazā - 7.50€", "Vidējā - 10.00€", "Lielā - 15.99€"});
        izmers.setBounds(84, 140, 200, 25);
        izmers.addActionListener(this);
        add(izmers);

        JLabel piedevasLabel = new JLabel("Piedevas:");
        piedevasLabel.setBounds(20, 170, 80, 25);
        add(piedevasLabel);
        piedevas = new JComboBox<>(new String[]{"Šampinjoni - 3.99€", "Olivas - 3.99€", "Nav"});
        piedevas.setBounds(84, 170, 200, 25);
        piedevas.addActionListener(this);
        add(piedevas);

        JLabel merceLabel = new JLabel("Mērce:");
        merceLabel.setBounds(20, 200, 80, 25);
        add(merceLabel);
        merce = new JComboBox<>(new String[]{"Tomātu - 1.99€", "Majonēze - 1.99€", 
        		"Siera mērce - 1.99€", "Nav"});
        merce.setBounds(84, 200, 200, 25);
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
        
        JLabel picasDaudzumaLabel = new JLabel("Picas daudzums:");
        picasDaudzumaLabel.setBounds(20, 270, 120, 25);
        add(picasDaudzumaLabel);
        
        picasDaudzumaLauks = new JTextField();
        picasDaudzumaLauks.setBounds(150, 270, 100, 25);
        picasDaudzumaLauks.setText("1");
        add(picasDaudzumaLauks);
        
        
        cenaLabel = new JLabel("Kopējā cena: 0.00€");
        cenaLabel.setBounds(20, 300, 150, 25);
        add(cenaLabel);


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void skana(String audioFails){
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Paths.get(audioFails).toFile());
            Clip audio = AudioSystem.getClip();
            audio.open(audioInputStream);
            audio.start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e){
    
    	if (e.getSource() == izmers || e.getSource() == piedevas || e.getSource() == merce || e.getSource() == piegadesLauks || e.getSource() == pasutijumaPoga) {
            int picasDaudzums = Integer.parseInt(picasDaudzumaLauks.getText());
            double kopejasIzmaksas = kopIzmaksas((String) izmers.getSelectedItem(), 
                (String) piedevas.getSelectedItem(), (String) merce.getSelectedItem(),
                piegadesLauks.isSelected(), picasDaudzums);
            
            
            cenaLabel.setText("Kopējā cena: €" + String.format("%.2f", kopejasIzmaksas));
        
    	}else  if (e.getSource() == izmers){
            	skana("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\audio\\click.wav");
                String izveletaisLielums = (String) izmers.getSelectedItem();
                switch (izveletaisLielums){
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
                
            } else if (e.getSource() == piedevas){
            	skana("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\audio\\click.wav");
                String izveletasPiedevas = (String) piedevas.getSelectedItem();
                switch (izveletasPiedevas){
                    case "Šampinjoni - 3.99€":
                        imageLabel.setIcon(new ImageIcon("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\images\\senes1.png"));
                        break;
                    case "Olivas - 3.99€":
                        imageLabel.setIcon(new ImageIcon("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\images\\olive1.png"));
                        break;
                    case "Nav":
                        imageLabel.setIcon(new ImageIcon("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\images\\nav1.png"));
                        break;
                }
                
            } else if (e.getSource() == merce){
            	skana("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\audio\\click.wav");
                String izveletaMerce = (String) merce.getSelectedItem();
                switch (izveletaMerce){
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
                        imageLabel.setIcon(new ImageIcon("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\images\\nav1.png"));
                        break;
                }
                
            } else if (e.getSource() == pasutijumaPoga){
            	skana("C:\\Users\\meguc\\eclipse-workspace\\jaunarajsjanvaris_pica\\src\\audio\\click.wav");
                String vards = vardaLauks.getText();
                String addrese = addresesLauks.getText();
                String numurs = numuraLauks.getText();
                boolean piegade = piegadesLauks.isSelected();
                String izmeri = (String) izmers.getSelectedItem();
                String piedeva = (String) piedevas.getSelectedItem();
                String merces = (String) merce.getSelectedItem();
                
                if (vards.isEmpty()||addrese.isEmpty()||numurs.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Lūdzu, aizpildiet lauciņus!",
                    		"Kļūda", JOptionPane.ERROR_MESSAGE);
                    return; 
                    
                }
                
                     if (!telNrNeatbilst(numurs)){
                    JOptionPane.showMessageDialog(this, "Ievadītais numurs neatbilst Latvijas standartiem!",
                    		"Kļūda", JOptionPane.ERROR_MESSAGE);
                   return; 
                }
                     
            int picasDaudzums = Integer.parseInt(picasDaudzumaLauks.getText());
            double kopejasIzmaksas = kopIzmaksas(izmeri, piedeva, merces, piegade, picasDaudzums);

            ierakstitFaila(vards, addrese, numurs, piegade, izmeri, piedeva, merces, 
            		picasDaudzums, kopejasIzmaksas);

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
            cenaLabel.setText("Kopējā cena: €0.00");
       }
    }
    
    private boolean telNrNeatbilst(String numurs){
        
        if (numurs.length() == 8 || numurs.length() == 11){
            if (numurs.startsWith("2")){
                
                return numurs.matches("[0-9]{8}");
            }else if (numurs.startsWith("+371")) {
                
                return numurs.matches("\\+371[0-9]{8}");
            }
        }
        return false; 
    }

    private double kopIzmaksas(String lielums, String piedevas, String merce, boolean piegade, 
    		int picasDaudzums){
        double izmeraCena = lielumaCena(lielums);
        double piedevuCena = piedevuCena(piedevas);
        double mercesCena = mercesCena(merce);

        double kopejasIzmaksas = (izmeraCena + piedevuCena + mercesCena)*picasDaudzums;

        if (piegade)
            kopejasIzmaksas += 3.15;
        return kopejasIzmaksas;
    }

    private double lielumaCena(String lielums){
        switch (lielums){
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

    private double piedevuCena(String piedevas){
        switch (piedevas){
            case "Šampinjoni - 3.99€":
            case "Olivas - 3.99€":
                return piedevasCena;
            default:
                return 0.0;
        }
    }

    private double mercesCena(String merce){
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
                                String izmeri, String piedeva, String merce, 
                                int picasDaudzums, double kopejasIzmaksas){
    	try (FileWriter w = new FileWriter("pasutijums.txt", true)){
            w.write("Vārds: "+vards+"\n");
            w.write("Adresse: "+addrese+"\n");
            w.write("TelNr.: "+numurs+"\n");
            w.write("Piegāde: "+(piegade?"ir":"nav")+"\n");
            w.write("Picas izmērs: "+izmeri+"\n");
            w.write("Piedevas: "+piedeva+"\n");
            w.write("Mērce: "+merce+"\n");
            w.write("Picas daudzums: "+picasDaudzums+"\n");
            w.write("Kopā: "+String.format("%.2f", kopejasIzmaksas)+"€\n\n");
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 }

public class pica{
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            PicasAplikacija aplikacija = new PicasAplikacija();
            aplikacija.setVisible(true);
        });
    }
 }