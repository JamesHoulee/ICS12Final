import java.awt.event.MouseEvent; 
import java.awt.event.MouseAdapter; 

public class ClickListener extends MouseAdapter{

    @Override 
    public void mouseClicked (MouseEvent event){
        System.out.println (event.getX() + " "+event.getY ()); 
    }
}
