import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ShortKeyFrame extends JFrame {
	public ShortKeyFrame(ShortKeysPanel s) {
		setTitle("Rune Republic Short Keys");
		setLocation(400, 300);
		setSize(400, 300);
		setVisible(true);
		add(s);
	}

    private class AreYouSure extends WindowAdapter {  
        public void windowClosing( WindowEvent e ) {  
            int option = JOptionPane.showOptionDialog(  
                    null, 
                    "Are you sure you want to quit?\nThis will not close the Rune Republic client!",  
                    "Exit Dialog", JOptionPane.YES_NO_OPTION,  
                    JOptionPane.WARNING_MESSAGE, null, null,  
                    null );  
            if( option == JOptionPane.YES_OPTION ) {  
               
            }  
        }  
    } 
}
