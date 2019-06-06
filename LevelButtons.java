import java.awt.event.MouseEvent; 

/**
 * @author James Houle & Juan Diego Castano 
 */
public class LevelButtons extends CustomButton{
      private int path; 
   
      public LevelButtons (int width, int height, String buttonText, int path){
        super (buttonText, width, height);
        this.path = path; 
      }
      
      @Override
      public void mouseClicked (MouseEvent e){
        setPath(path); // level 1 = 4; level 2 = 5; level 3 = 6 
      }
}