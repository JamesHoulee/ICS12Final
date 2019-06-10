import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author James Houle and Juan Diego Castano
 * @version 1 _______
 */
public class RestartLevel extends JDialog implements ActionListener {
  
  private JTextField message;
  private JButton close;
  private SpringLayout layout;
  
  /**
   * @param level represents what level is being restarted. When level = 2, LevelTwo is being restarted. When level = 3,
   *        level three is being restarted from the practice speech. When level = 4, level three is being restarted from
   *        the real speech.
   */
  public RestartLevel (int level){
    
    setSize (300,100);
    setVisible (true);
    setDefaultCloseOperation (JDialog.DISPOSE_ON_CLOSE);
    
    layout = new SpringLayout ();
    setLayout (layout);
    
    if (level == 2){
      message = new JTextField ("You had an anxiety attack! You will restart from the beginning of level two!");
    }
    if (level == 3){
      message = new JTextField ("You had an anxiety attack! You will restart from the beginning of level three!");
    }
    if (level == 4){
      
    }
    message.setEditable (false);
    add (message);
    
    close = new JButton ("Ok");
    
    layout.putConstraint (layout.WEST, close, 150, layout.WEST, this);
    layout.putConstraint (layout.NORTH, close, 20, layout.NORTH, this);
    add (close);
    close.addActionListener (this);
    setSize (301,100);
  }
  
  @Override
  public void actionPerformed (ActionEvent e){
    if (e.getActionCommand ().equals ("Ok")){
      this.dispose ();
    }
  }
}
    