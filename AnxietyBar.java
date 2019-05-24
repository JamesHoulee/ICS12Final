import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class AnxietyBar extends JPanel{
  
  private int anxietyPercent;
  
  public AnxietyBar (int percent){
    anxietyPercent = percent;
  }
  
  @Override
  public Dimension getPreferredSize() {
    // so that our GUI is big enough
    return new Dimension(136,41);
  }
    
  @Override
  public void paintComponent (Graphics g){
    g.drawRect (0,0,135,40);
    g.setColor (Color.RED);
    g.fillRect (1,1,134*anxietyPercent/100,39);
  }
  
  public static void main (String [] args){
    JFrame frame = new JFrame ();
    frame.add (new AnxietyBar (50));
    frame.setSize (1000,750);
    frame.setVisible (true);
  }
}