import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;

/**
 * 
 * @author James Houle and Juan Diego Castano
 * @version 1 05.29.19
 */
public class Inventory extends JPanel {
  
  private static boolean pencilCase;
  
  public Inventory (boolean hasCase){
    
    pencilCase = false;
    
  }
  
  public static boolean getPencilCase (){
    return pencilCase;
  }
  
  @Override
  public void paintComponent (Graphics g){
    g.drawString ("Pencil Case",20,50);
    g.drawRect (1,1,100,80);
  }
  
  @Override
  public Dimension getPreferredSize (){
    return new Dimension (200,200);
  }
}