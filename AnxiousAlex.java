import javax.swing.JFrame;

public class AnxiousAlex {
  public static void main (String [] main){
    
    //Main m = new Main ();
    
    JFrame frame = new JFrame ("Test");
    frame.add (new Main ());
    //frame.add(new LevelOne ());
    frame.setSize (1000,700);
    frame.setVisible (true);
  }
}