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
  
  public Inventory (){}
  
  public static boolean getPencilCase (){
    return pencilCase;
  }
  
  public static void setPencilCase (boolean hasCase){
    pencilCase = hasCase;
  }
  
  @Override
  public void paintComponent (Graphics g){
    g.drawRect (1,1,100,80);
    if (pencilCase == true)
      g.drawString ("Pencil Case",20,50);
    
  }
  
  @Override
  public Dimension getPreferredSize (){
    return new Dimension (200,200);
  }
}