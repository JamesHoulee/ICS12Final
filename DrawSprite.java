import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.SpringLayout;

/**
 * 
 */
public class DrawSprite extends JPanel {
    private Color color;
    
    private SpringLayout layout;

    public DrawSprite (Color c){
        color = c;
        setVisible (true);
        
        setLayout (layout);
        
    }

    @Override
    public void paintComponent (Graphics g){
        super.paintComponent (g);
        g.setColor (color);
        g.fillRect (0, 0, 100,100);
    }
    
    @Override
    public Dimension getPreferredSize() {
      // so that our GUI is big enough
      return new Dimension(100,100);
   }
}