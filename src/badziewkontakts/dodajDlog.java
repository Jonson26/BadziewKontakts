package badziewkontakts;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author kasa
 */
public class dodajDlog {
    JTextField name, tel, adr, email;
    JFrame ramka;
    ArrayList<kontakt> ak;
    
    public dodajDlog(ArrayList<kontakt> aK){
        ak = aK;
        
        ramka = new JFrame("Dodaj");
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.PAGE_AXIS));
        JPanel bottom = new JPanel();
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.LINE_AXIS));
        bottom.add(Box.createHorizontalGlue());
        
        JLabel n = new JLabel("Imie:");
        JLabel t = new JLabel("Telefon:");
        JLabel a = new JLabel("Adres:");
        JLabel e = new JLabel("Email:");
        
        name = new JTextField(20);
        tel = new JTextField(20);
        adr = new JTextField(20);
        email = new JTextField(20);
        
        JPanel np = new JPanel();
        JPanel tp = new JPanel();
        JPanel ap = new JPanel();
        JPanel ep = new JPanel();
        
        JButton dodaj = new JButton("Dodaj");
        dodaj.addActionListener(new ButtonListener());
        
        np.add(n);
        tp.add(t);
        ap.add(a);
        ep.add(e);
        np.add(name);
        tp.add(tel);
        ap.add(adr);
        ep.add(email);
        
        form.add(np);
        form.add(tp);
        form.add(ap);
        form.add(ep);
        bottom.add(dodaj);
        
        ramka.add(form,BorderLayout.CENTER);
        ramka.add(bottom,BorderLayout.SOUTH);
        ramka.setSize(300, 200);
        ramka.setVisible(true);
    }
    
    public class ButtonListener implements ActionListener { //klasa wewnętrzna odpowiedzialna za obsługiwanie guzika
        @Override
        public void actionPerformed(ActionEvent ev) {
            ak.add(new kontakt(name.getText(),tel.getText(),adr.getText(),email.getText()));
            ramka.dispose();
        }
    }
}
