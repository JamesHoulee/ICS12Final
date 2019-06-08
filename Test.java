import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author James Houle and Juan Diego Castano
 * @version V 06.07.19
 */
public class Test extends JDialog implements ActionListener{
  
  SpringLayout layout;
  
  JTextField tip;
  JTextField q1, q2; 
  JButton q1A, q1B, q1C;
  JButton q2A, q2B, q2C;
  
  public Test (JFrame owner, String title){
    super (owner, title);
    
    setVisible (true);
    setSize (310,150);
    setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
    
    layout = new SpringLayout ();
    setLayout (layout);
    
    tip = new JTextField ("Pay attention to your anxiety bar on the main screen");
    q1 = new JTextField ("What is y when x = 2 for the equation: y = 4x + 6");
    q2 = new JTextField ("What are the roots of the equation: y = (x + 5)(x - 2)");
    tip.setEditable (false);
    q1.setEditable (false);
    q2.setEditable (false);
    
    q1A = new JButton ("8");
    q1B = new JButton ("14");
    q1C = new JButton ("22");
    
    q2A = new JButton ("5 and -2");
    q2B = new JButton ("No real roots");
    q2C = new JButton ("-5 and 2");
    
    layout.putConstraint (layout.WEST, tip, 0, layout.WEST, this);
    layout.putConstraint (layout.NORTH, tip, 70, layout.NORTH, this);
    add (tip);
    
    layout.putConstraint (layout.WEST, q1, 0, layout.WEST, this);
    layout.putConstraint (layout.NORTH, q1, 0, layout.NORTH, this);
    add (q1);
    
    layout.putConstraint (layout.WEST, q1A, 0, layout.WEST, this);
    layout.putConstraint (layout.NORTH, q1A, 40, layout.NORTH, this);
    q1A.addActionListener (this);
    add (q1A);
    
    layout.putConstraint (layout.WEST, q1B, 0, layout.EAST, q1A);
    layout.putConstraint (layout.NORTH, q1B, 40, layout.NORTH, this);
    q1B.addActionListener (this);
    add (q1B);
    
    layout.putConstraint (layout.WEST, q1C, 0, layout.EAST, q1B);
    layout.putConstraint (layout.NORTH, q1C, 40, layout.NORTH, this);
    q1C.addActionListener (this);
    add (q1C);
    
    layout.putConstraint (layout.WEST, q2A, 0, layout.WEST, this);
    layout.putConstraint (layout.NORTH, q2A, 40, layout.NORTH, this);
    q2A.addActionListener (this);
    
    layout.putConstraint (layout.WEST, q2B, 0, layout.EAST, q2A);
    layout.putConstraint (layout.NORTH, q2B, 40, layout.NORTH, this);
    q2B.addActionListener (this);
    
    layout.putConstraint (layout.WEST, q2C, 0, layout.EAST, q2B);
    layout.putConstraint (layout.NORTH, q2C, 40, layout.NORTH, this);
    q2C.addActionListener (this);
    
    
    layout.putConstraint (layout.WEST, q2, 0, layout.WEST, this);
    layout.putConstraint (layout.NORTH, q2, 0, layout.NORTH, this);
  }
  
  public void nextQuestion (int questionNumber){
    if (questionNumber == 2){
      remove (q1);
      remove (q1A);
      remove (q1B);
      remove (q1C);
      add (q2);
      add (q2A);
      add (q2B);
      add (q2C);
    }
    repaint ();
    revalidate ();
  }
  
  @Override
  public void actionPerformed (ActionEvent ae){
    if (ae.getActionCommand ().equals ("8")){
      AnxietyBar.increasePercent (5);
      refresh ();
      nextQuestion (2);
    }
    if (ae.getActionCommand ().equals ("14")){
      nextQuestion (2);
    }
    if (ae.getActionCommand ().equals ("22")){
      AnxietyBar.increasePercent (5);
      refresh ();
      nextQuestion (2);
    }
    if (ae.getActionCommand ().equals ("5 and -2")){
      AnxietyBar.increasePercent (5);
      MathClass.closeTest ();
      this.dispose ();
    }
    if (ae.getActionCommand ().equals ("No real roots")){
      AnxietyBar.increasePercent (5);
      MathClass.closeTest ();
      this.dispose ();
    }
    if (ae.getActionCommand ().equals ("-5 and 2")){
      MathClass.closeTest ();
      this.dispose ();
    }
    refresh ();
  }
  
  public void refresh (){
    repaint ();
    revalidate ();
  }

  
  //temp
  public static void main (String [] args){
    new AnxiousAlex ();
  }
}
  
  