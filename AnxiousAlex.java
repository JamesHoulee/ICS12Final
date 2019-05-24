import javax.swing.JFrame;

public class AnxiousAlex {
  
  JFrame frame;
  Main mainMenu;
  LevelOne levelOne;
  InformationScreen infoScreen;
  
  JFrame mainMenuFrame;
  JFrame levelOneFrame;
  JFrame infoScreenFrame;
  
  public AnxiousAlex (){
    
    mainMenu = new Main ();
    
    levelOneFrame = new JFrame ("Level One");
    infoScreenFrame = new JFrame ("Info Screen");
    
    while (true){
      checkPath ();
    }
  }
  
  public void checkPath (){
    if (mainMenu.button.getPath () == 1){
      levelOneFrame = new JFrame ("Level One");
      
      levelOne = new LevelOne ();
      levelOneFrame.add (levelOne);
      levelOneFrame.setSize (1000,750);
      levelOneFrame.setVisible (true);
      levelOneFrame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
      mainMenuFrame.dispose ();
      mainMenu.button.setPath (0);
    }
    else if (mainMenu.button.getPath () == 2){
      infoScreenFrame = new JFrame ("Instructions");
      
      infoScreen = new InformationScreen ();
      infoScreenFrame.add (infoScreen);
      infoScreenFrame.setSize (1000,750);
      infoScreenFrame.setVisible (true);
      infoScreenFrame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
      mainMenuFrame.dispose ();
      mainMenu.button.setPath (0);
    }
    else if (mainMenu.button.getPath () == -999){
      mainMenuFrame = new JFrame ("The Anxious Life Of Alex Joe");
      
      mainMenuFrame.add (mainMenu);
      mainMenuFrame.setSize (1000,750);
      mainMenuFrame.setVisible (true);
      mainMenuFrame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
      levelOneFrame.dispose ();
      infoScreenFrame.dispose ();
      mainMenu.button.setPath (0);
    }
    else if (mainMenu.button.getPath () == 3){
      System.exit(0);
    }
    else
      System.out.print ("");
  }
      
  public static void main (String [] main){
    new AnxiousAlex ();
  }
}