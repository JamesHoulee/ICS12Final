import java.awt.event.MouseEvent; 

/**
 * @author James Houle & Juan Diego Castano 
 */
public class LevelOneButton extends CustomButton{

    public LevelOneButton (int width, int height){
        super ("Level One", width, height);
      }
      
      @Override
      public void mouseClicked (MouseEvent e){
        setPath(4);
      }
}