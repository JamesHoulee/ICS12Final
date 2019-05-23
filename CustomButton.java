import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 */

public class CustomButton extends JButton implements MouseListener {
  
  private boolean hover = false;
  private boolean click = false;
  private String text = "";
  int sizeX, sizeY;
  int xLocation, yLocation;
  
  private int path = 0;
  
  public CustomButton (String text, int sizeX, int sizeY){
    setVisible(true);
    setFocusable(true);
    setContentAreaFilled(false);
    setBorderPainted(false);
    
    this.text = text;
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    
    addMouseListener(this);
  }
    
  
 /* public CustomButton(String text, int sizeX, int sizeY, int xLocation, int yLocation) {
    setVisible(true);
    setFocusable(true);
    setContentAreaFilled(false);
    setBorderPainted(false);
    
    this.text = text;
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    this.xLocation = xLocation;
    this.yLocation = yLocation;
    
    addMouseListener(this);
  } */
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (click) {
      g.setColor(new Color (217,217,219));
      g.fillRect(xLocation, yLocation, sizeX, sizeY);
      
    } else if (hover) {
      g.setColor(new Color (143,144,145));
      g.fillRect(xLocation, yLocation, sizeX, sizeY);
      
    } else if (!hover) {
      g.setColor(new Color (177,178,181));
      g.fillRect(xLocation, yLocation, sizeX, sizeY);
      
    } else {
      g.setColor(Color.YELLOW);
      g.fillRect(xLocation, yLocation, sizeX, sizeY);
      
    }
    
    g.setColor(Color.WHITE);
    g.setFont(Font.decode("arial-BOLD-24"));
    FontMetrics metrics = g.getFontMetrics();
    int width = metrics.stringWidth(text);
    g.drawString(text, 125 - width / 2, 85); // xSize/2 , size/2
  }
  
  public void redraw() {
    this.repaint();
  }
  
  @Override
  public Dimension getPreferredSize() {
    return new Dimension (sizeX, sizeY);
  }
  
 /* @Override
  public Dimension getMaximumSize() {
    return size;
  }
  
  @Override
  public Dimension getMinimumSize() {
    return size;
  } */
  
  public void setButtonText(String text) {
    this.text = text;
    
  }
  
  public String setButtonText() {
    return text;
  }
  
  @Override
  public void mouseEntered(MouseEvent e) {
    hover = true;
  }
  
  @Override
  public void mousePressed(MouseEvent e) {
    click = true;
  }
  
  @Override
  public void mouseExited(MouseEvent e) {
    hover = false;
  }
  
  @Override
  public void mouseReleased(MouseEvent e) {
    click = false;
  }
  
  @Override
  public void mouseClicked(MouseEvent e) {
    if (text.equals ("Play")){
      path = 1;
    }
    if (text.equals ("Instructions")){
      path = 2;
    }
  }
  
  
  public int getPath (){
    return path;
  }
}