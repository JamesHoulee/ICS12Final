import javax.swing.JFrame;

public class AnxiousAlex {
  public static void main (String [] main){
    //mainMenu m = new mainMenu ();
    LevelOne l1 = new LevelOne();
    JFrame frame = new JFrame ("Test");
    frame.add(new LevelOne ());
    frame.setSize (1000,700);
    frame.setVisible (true);
  }
}