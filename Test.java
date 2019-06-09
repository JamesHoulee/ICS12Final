import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The Test class extends JDialog and implements ActionListener. This class creates a new JDialog representing the 
 * player's math test. It lays out questions for the player to answer. Wrong answers make Alex more anxious.
 * 
 * <p>
 * <b>Instance Variable: </b>
 * <p>
 * <b>layout </b> This variable represents the layout for the JDialog.
 * <p>
 * <b>tip </b> This variable represents the tip that the player gets.
 * <p>
 * <b>q1 </b> This variable represents the first question
 * <p>
 * <b>q2 </b> This variable represents the second question
 * <p>
 * <b>q1A </b> This variable represents the first option for the first question
 * <p>
 * <b>q1B </b> This variable represents the second option for the first question
 * <p>
 * <b>q1C </b> This variable represents the third option for the first question
 * <p>
 * <b>q2A </b> This variable represents the first option for the second question
 * <p>
 * <b>q2B </b> This variable represents the second option for the second question
 * <p>
 * <b>q2C </b> This variable represents the third option for the second question
 * 
 * @author James Houle and Juan Diego Castano
 * @version 1 06.07.19
 */
public class Test extends JDialog implements ActionListener{
  
  private SpringLayout layout;
  
  private JTextField tip;
  private JTextField q1, q2; 
  private JButton q1A, q1B, q1C;
  private JButton q2A, q2B, q2C;
  
  /**
   * This is the constructor for the Test class. This constructor instatiates all the required text fields and buttons
   * and it sets up the constraints for all the instantiated objects.
   */
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
  
  /**
   * The nextQuestion method sets the screen for the next question
   * 
   * @param questionNumber represents the next question number.
   */
  private void nextQuestion (int questionNumber){
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
  
  /**
   * The actionPerformed method defines how the game reacts to a players specific input. This method 
   * defines the boundaries of the game. It also defines the locations of events in the game such as when the anxiety
   * bar has to change. 
   * 
   * @param e is an object of the ActionEvent class
   */
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
  
  /**
   * The refresh method calls the repaint and revalidate methods.
   */
  public void refresh (){
    repaint ();
    revalidate ();
  }
}
  
  