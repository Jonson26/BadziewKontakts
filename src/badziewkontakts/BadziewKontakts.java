package badziewkontakts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author kasa
 */
public class BadziewKontakts {
    ArrayList<kontakt> ak;
    JFrame ramka;
    
    public static void main(String[] args) {
        BadziewKontakts k = new BadziewKontakts();
        k.loadContacts();
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                k.saveContacts();
            }
        });
        k.doDziela();
    }
    
    public void doDziela(){
        UIManager.LookAndFeelInfo looks[] = UIManager.getInstalledLookAndFeels();
        try{
            //0-Swing, 1-Mac, 2-?, 3-Windows, 4-Old Windows
            UIManager.setLookAndFeel(looks[4].getClassName());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        ramka = new JFrame("Badziew Kontakts");
        JPanel panel = new JPanel();
        
        
        JButton z = new JButton("Zobacz");
        JButton d = new JButton("Dodaj");
        JButton u = new JButton("Usuń");
        
        ButtonListener b = new ButtonListener();
        
        z.addActionListener(b);
        z.setAlignmentX(Component.CENTER_ALIGNMENT);
        d.addActionListener(b);
        d.setAlignmentX(Component.CENTER_ALIGNMENT);
        u.addActionListener(b);
        u.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(z);
        panel.add(d);
        panel.add(u);
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.LIGHT_GRAY);
        
        ramka.add(panel);
        ramka.setSize(190,105);
        ramka.setResizable(false);
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setVisible(true);
    }
    
    private void loadContacts(){
        ak = new ArrayList<>();
        String str;
        try {
		BufferedReader br = new BufferedReader(new FileReader("contacts"));
                while((str=br.readLine()) != null){
                    ak.add(new kontakt(str, br.readLine(), br.readLine(), br.readLine()));
                }
                br.close();
	}catch(Exception ex){
		ex.printStackTrace();
	}
    }
    
    private void saveContacts(){
        try {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("contacts")));
                for (int i=0; i<ak.size(); i++){
                    out.println(ak.get(i).name);
                    out.println(ak.get(i).tel);
                    out.println(ak.get(i).adr);
                    out.println(ak.get(i).email);
                    out.flush();
                }
                out.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
    }
    
    public class ButtonListener implements ActionListener { //klasa wewnętrzna odpowiedzialna za obsługiwanie guzika
        @Override
        public void actionPerformed(ActionEvent ev) {
            String cmd = ev.getActionCommand();
            switch(cmd){
                case "Zobacz":
                    new zobaczDlog(ak);
                break;
                case "Dodaj":
                    new dodajDlog(ak);
                break;
                case "Usuń":
                    new usunDlog(ak);
                break;
            }
        }
    }
}
