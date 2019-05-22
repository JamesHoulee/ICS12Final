import javax.swing.JFrame;

public class AnxiousAlex extends JFrame {
  
  JFrame frame;
  Main mainMenu;
  LevelOne levelOne;
  
  boolean check;
  
  public AnxiousAlex (){
    
    mainMenu = new Main ();
    check = true;
    
    add (mainMenu);
    setSize (1000,750);
    setVisible (true);
    setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
    
    while (check){
      checkPath ();
    }
  }
  
  public void checkPath (){
    if (mainMenu.button.getPath () == 1){
      JFrame frame = new JFrame ("Test");
      
      levelOne = new LevelOne ();
      frame.add (levelOne);
      frame.setSize (1000,750);
      frame.setVisible (true);
      frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
      this.dispose ();
      check = false;
    }
    else //HOW THE HECK DO I FIX THIS WHY DOESNT IT WORK IF I REMOVE THIS IF STATEMENT
      System.out.print ("");
  }
      
  public static void main (String [] main){
    new AnxiousAlex ();
  }
}