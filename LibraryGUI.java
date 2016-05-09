import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Color;

public class LibraryGUI extends JFrame{
	public OpenGUI(){
		super("Library");
		contents = getContentPane();
		contents.s
	}
	public static void main(String[] args){
		Layout layout = new Layout();
		layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layout.setVisible(true);
		Container content = new layout.getContentPane();
		layout.setLocation(300,300);
		layout.getContentPane();
	}
}
class WelcomeScreen {
   private JPanel mainPanel = new JPanel();
   private JButton baz = new JButton("l");
   private JButton exit = new JButton("Exit");
   private JButton acct = new JButton("Make an account");

   public IntroPanel() {
      mainPanel.setLayout(new FlowLayout());
      baz = new JButton("Search for a book");
      exit = new JButton("Exit");
      acct = new JButton("Make an account");

      mainPanel.add(new JLabel("Welcome to the Jareo Library!"));
      mainPanel.add(baz);
      mainPanel.add(exit);
      mainPanel.add(acct);

      exit.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Window win = SwingUtilities.getWindowAncestor(mainPanel);
            win.dispose();
         }
      });
   }
   
   public void addBazBtnActionListener(ActionListener listener) {
      baz.addActionListener(listener);
   }
   public void addNewAcctActionListener(ActionListener listener){
       acct.addActionListener(listener);
    }
   public JComponent getMainComponent() {
      return mainPanel;
   }

}

class MainMenu {
   private static final Dimension MAIN_SIZE = new Dimension(400, 200);
   private JPanel mainPanel = new JPanel();
   
   private JLabel searchInstruction;
   private JTextField searchField;
   private JButton sButton;
   private JButton back;
   private JComboBox sOptions;
   private JLabel display;
   //private String[] searchOptions = {"Title","Author","Date");

   public GamePanel() {
      mainPanel.setLayout(null);
      searchField = new JTextField("Search for a book");
      sButton = new JButton("Search");
      back = new JButton("return to main menu");
      searchInstruction = new JLabel("Enter search field");
      sOptions = new JComboBox();
      display = new JLabel("The displayed text");
      sOptions.addItem("Title");
      sOptions.addItem("Author");
      sOptions.addItem("Date");
      //searchField.setSize(100,20);
      
      
      //sOptions.setHorizontalAlignment(JLabel.LEFT);
      mainPanel.add(sOptions, BorderLayout.CENTER);
      mainPanel.add(display);
      //sOptions.setHorizontalAlignment(JLabel.CENTER);
      mainPanel.add(searchField, BorderLayout.CENTER);
      searchField.setLocation(100,200);
      //sOptions.setHorizontalAlignment(JLabel.LEFT);
      //sOptions.setVerticalAlignment(JLabel.DOWN);
      mainPanel.add(sButton);
      
      mainPanel.add(back);
      mainPanel.setBackground(Color.black);
      
      searchField.addMouseListener(new MouseAdapter() { 
          public void mousePressed(MouseEvent me) { 
            searchField.setText(""); 
            //searchField.setSize(100,20);
          } 
        }    );
      sOptions.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              display.setText(((JComboBox) e.getSource()).getSelectedItem().toString());
            }
        });
      mainPanel.setPreferredSize(MAIN_SIZE);
   }
   public void clickSearch(MouseEvent e){
       searchField.setText("");
    }
   public void dropDownListener(ActionEvent e){
       //return sOptions.getText();
    }
   
   public JComponent getMainComponent() {
      return mainPanel;
   }

   public void addBackBtnActionListener(ActionListener listener) {
      back.addActionListener(listener);
   }

}
