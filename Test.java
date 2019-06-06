import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author James Houle and Juan Diego Castano
 * @version 1 06.05.19
 */
public class Test extends JDialog implements ActionListener{
  
  SpringLayout layout;
  
  JTextField q1, q2; 
  JButton button, button2;// 
  
  public Test (JFrame owner, String title){
    super (owner, title);
    
    setVisible (true);
    setSize (300,200);
    setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
    
    layout = new SpringLayout ();
    setLayout (layout);
    
    q1 = new JTextField ("What is y when x = 2 for the equation: y = 4x + 6");
    q2 = new JTextField ("What are the roots of the equation: y = (x + 5)(x - 2)");
    q1.setEditable (false);
    q2.setEditable (false);
    
    button = new JButton ("Ok");
    button2 = new JButton ("Bye");
    
    layout.putConstraint (layout.WEST, q1, 0, layout.WEST, this);
    layout.putConstraint (layout.NORTH, q1, 0, layout.NORTH, this);
    add (q1);
    
    layout.putConstraint (layout.WEST, q2, 0, layout.WEST, this);
    layout.putConstraint (layout.NORTH, q2, 0, layout.NORTH, this);
    
    layout.putConstraint (layout.WEST, button, 0, layout.WEST, this);
    layout.putConstraint (layout.NORTH, button, 40, layout.NORTH, this);
    button.addActionListener(this);
    add (button);
    
    layout.putConstraint (layout.WEST, button2, 0, layout.WEST, this);
    layout.putConstraint (layout.NORTH, button2, 40, layout.NORTH, this);
    button2.addActionListener(this);
  }
  
  public void nextQuestion (int questionNumber){
    if (questionNumber == 2){
      remove (q1);
      remove (button);
      add (q2);
      add (button2);
    }
    repaint ();
    revalidate ();
  }
  
  @Override
  public void actionPerformed (ActionEvent ae){
    if (ae.getActionCommand ().equals ("Ok")){
      nextQuestion (2);
    }
    if (ae.getActionCommand ().equals ("Bye")){
      MathClass.closeTest ();
      this.dispose ();
    }
  }

  
  //temp
  public static void main (String [] args){
    new AnxiousAlex ();
  }
}
  
  