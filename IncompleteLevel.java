import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 */
public class IncompleteLevel extends JDialog implements ActionListener {
  
  private JTextField message;
  private JButton close;
  private SpringLayout layout;
  
  /**
   * 
   */
  public IncompleteLevel (int level){
    
    setSize (400,100);
    setVisible (true);
    setDefaultCloseOperation (JDialog.DISPOSE_ON_CLOSE);
    
    layout = new SpringLayout ();
    setLayout (layout);
    
    if (level == 1){
      message = new JTextField ("You must complete level one before moving to level two");
    }
    if (level == 2){
      message = new JTextField ("You must complete levels one and two before moving to level three");
    }
    message.setEditable (false);
    add (message);
    
    close = new JButton ("Close");
    layout.putConstraint (layout.WEST, close, 150, layout.WEST, this);
    layout.putConstraint (layout.NORTH, close, 20, layout.NORTH, this);
    add (close);
    close.addActionListener(this);
    
    setSize (401,100);
  }
    
  @Override
  public void actionPerformed (ActionEvent e){
    if (e.getActionCommand ().equals ("Close")){
      dispose ();
    }
  }
}
    
    