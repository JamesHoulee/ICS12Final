import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.SpringLayout;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.io.File;

public class Images extends JLabel {
  
  private int imageWidth, imageHeight;
  private SpringLayout layout;
  BufferedImage background;
  JLabel backgroundLabel;
  
  public Images (String img, int imgWidth, int imgHeight){
    
    imageWidth = imgWidth;
    imageHeight = imgHeight;
    
    layout = new SpringLayout ();
    setLayout (layout);
    
    setVisible (true);  
    
    try{
      background = ImageIO.read (new File (img));
      backgroundLabel = new JLabel (new ImageIcon (background));
      add (backgroundLabel);
    }
    catch (IOException e){}
  } 
  
  @Override
  public Dimension getPreferredSize() {
    // so that our GUI is big enough
    return new Dimension(imageWidth,imageHeight);
  }
}