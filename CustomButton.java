import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 * 
 */
public class CustomButton extends JButton implements MouseListener {
  
  protected boolean hover = false;
  protected boolean click = false;
  protected String text = "";
  protected int sizeX, sizeY;
  
  protected static int path = -999;
  
  public CustomButton (){}
  /**
   * 
   */
  public CustomButton (String text, int sizeX, int sizeY){
    setVisible(true);
    setBorderPainted(false);
    
    this.text = text;
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    
    addMouseListener(this);
  }
  /**
   * 
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (click) {
      g.setColor(new Color (217,217,219));
      g.fillRect(0, 0, sizeX, sizeY);  
    }
    else if (hover) {
      g.setColor(new Color (143,144,145));
      g.fillRect(0, 0, sizeX, sizeY);
    }
    else {
      g.setColor(new Color (177,178,181));
      g.fillRect(0, 0, sizeX, sizeY);
    }
    
    g.setColor(Color.WHITE);
    g.setFont(Font.decode("arial-BOLD-24"));
    FontMetrics metrics = g.getFontMetrics();
    int width = metrics.stringWidth(text);
    g.drawString(text, sizeX/2 - width / 2, 85); // xSize/2 , size/2
  } 
  /**
   * 
   */
  public void redraw() {
    this.repaint();
  }
  /**
   * 
   */
  @Override
  public Dimension getPreferredSize() {
    return new Dimension (sizeX, sizeY);
  }
  /**
   * 
   */
  public void setButtonText(String text) {
    this.text = text;
    
  }
  /**
   * 
   */
  public String setButtonText() {
    return text;
  }
  /**
   * 
   */
  @Override
  public void mouseEntered(MouseEvent e) {
    hover = true;
  }
  /**
   * 
   */
  @Override
  public void mousePressed(MouseEvent e) {
    click = true;
  }
  /**
   * 
   */
  @Override
  public void mouseExited(MouseEvent e) {
    hover = false;
  }
  /**
   * 
   */
  @Override
  public void mouseReleased(MouseEvent e) {
    click = false;
  }
  /**
   * 
   */
  @Override
  public void mouseClicked(MouseEvent e) {}
  /**
   * 
   */
  public static int getPath (){
    return path;
  }
  /**
   * 
   */
  public void setPath (int newPath){
    path = newPath;
  }
}