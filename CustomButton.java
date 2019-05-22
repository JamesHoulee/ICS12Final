import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import javax.swing.JFrame;

public class CustomButton extends JButton implements MouseListener {
  
  private boolean hover = false;
  private boolean click = false;
  private String text = "";
  int sizeX, sizeY;
  int xLocation, yLocation;
  Dimension size = new Dimension(250, 150); // the size of the rectangle
  
  public CustomButton(String text, int sizeX, int sizeY, int xLocation, int yLocation) {
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
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (click) {
      g.setColor(Color.GREEN);
      g.fillRect(xLocation, yLocation, sizeX, sizeY);
      
    } else if (hover) {
      g.setColor(Color.BLUE);
      g.fillRect(xLocation, yLocation, sizeX, sizeY);
      
    } else if (!hover) {
      g.setColor(Color.RED);
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
    return size;
  }
  
  @Override
  public Dimension getMaximumSize() {
    return size;
  }
  
  @Override
  public Dimension getMinimumSize() {
    return size;
  }
  
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
    JFrame frame = new JFrame ();
    frame.add (new LevelOne ());
    frame.setVisible (true);
    frame.setSize (1000,700);
  }
}