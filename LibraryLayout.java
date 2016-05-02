import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Container;
import java.awt.Color;

/**
 * @author Arianna Osar, Justin Orr 
 * @version (8.1)
 */

public class GameGUI extends JFrame{
  /**
  *gonna change this later to call methods within other classes
  */
    private JTextField fname;
    private JTextField lname;
    private JLabel text2; 
    
    public GameGUI(){
        super("Number Guessing Game!"); 
        setLayout(new FlowLayout()); 

        
    }
    
    
    
    private class listener implements ActionListener{
        public void register(ActionEvent event){
            fnameInput = fname.getText();
            lnameInput = lname.getText();
            
        }
    }
} 
