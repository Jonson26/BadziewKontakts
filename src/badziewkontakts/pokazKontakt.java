package badziewkontakts;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author kasa
 */
public class pokazKontakt {
    
    public pokazKontakt(kontakt k){
        JFrame ramka = new JFrame(k.name);
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.PAGE_AXIS));
        
        JLabel n = new JLabel("Imie: "+k.name);
        JLabel t = new JLabel("Telefon: "+k.tel);
        JLabel a = new JLabel("Adres: "+k.adr);
        JLabel e = new JLabel("Email: "+k.email);
        
        form.add(n);
        form.add(t);
        form.add(a);
        form.add(e);
        
        ramka.add(form,BorderLayout.CENTER);
        ramka.setSize(200, 100);
        ramka.setVisible(true);
    }
}
