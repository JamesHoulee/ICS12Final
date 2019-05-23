import javax.swing.JFrame;

public class AnxiousAlex extends JFrame {
  
  JFrame frame;
  Main mainMenu;
  LevelOne levelOne;
  InformationScreen infoScreen;
  
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
      JFrame frame = new JFrame ("Level One");
      
      levelOne = new LevelOne ();
      frame.add (levelOne);
      frame.setSize (1000,750);
      frame.setVisible (true);
      frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
      this.dispose ();
      check = false;
    }
    else if (mainMenu.button2.getPath () == 2){
      JFrame frame = new JFrame ("Instructions");
      
      infoScreen = new InformationScreen ();
      frame.add (infoScreen);
      frame.setSize (1000,750);
      frame.setVisible (true);
      frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
      this.dispose ();
      check = false;
    }
    else
      System.out.print ("");
  }
      
  public static void main (String [] main){
    new AnxiousAlex ();
  }
}