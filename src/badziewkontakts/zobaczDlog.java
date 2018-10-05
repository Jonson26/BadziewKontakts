package badziewkontakts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author kasa
 */
public class zobaczDlog {
    ArrayList<kontakt> ak;
    JComboBox menu;
    JFrame ramka;
    
    public zobaczDlog(ArrayList<kontakt> AK){
        ak = AK;
        String[] lista = new String[ak.size()];
        
        ramka = new JFrame("Pokaż");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(Box.createHorizontalGlue());
        
        for(int i=0;i<ak.size();i++){
            lista[i] = ak.get(i).name;
        }
        
        menu = new JComboBox(lista);
        JButton ok = new JButton("OK");
        ok.addActionListener(new ButtonListener());
        
        panel.add(menu);
        panel.add(ok);
        
        ramka.add(panel);
        ramka.setSize(200,100);
        ramka.setVisible(true);
    }
    
    public class ButtonListener implements ActionListener { //klasa wewnętrzna odpowiedzialna za obsługiwanie guzika
        @Override
        public void actionPerformed(ActionEvent ev) {
            new pokazKontakt(ak.get(menu.getSelectedIndex()));
            ramka.dispose();
        }
    }
}
