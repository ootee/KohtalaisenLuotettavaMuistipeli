
package muistipeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class Kayttoliittyma implements Runnable {
    private JFrame frame;

    public Kayttoliittyma() {
    }
    
    @Override
    public void run() {
        frame = new JFrame("Kohtalaisen luotettava muistipeli");
        frame.setPreferredSize(new Dimension(600, 700));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        JLabel viestikentta = new JLabel("Tähän tulee ohjelman antamat viestit.");
        container.add(viestikentta, BorderLayout.NORTH);
        JTextField tekstikentta = new JTextField();
        container.add(tekstikentta, BorderLayout.SOUTH);
        container.add(luoNapit(), BorderLayout.CENTER);
    }
    
    private JPanel luoNapit() {
        JPanel panel = new JPanel(new GridLayout(8, 8));
        List<JButton> napit = new ArrayList<>();
        for (int i = 0; i < 64; i++) {
            JButton nappi = new JButton();
            napit.add(nappi);
            panel.add(nappi);
        }
        return panel;
    }
    
    public JFrame getfFrame() {
        return frame;
    }
}
