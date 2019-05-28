import javax.swing.JFrame;

/**
 * The AnxiousAlex class is the Driver class for <i>The Anxious Life of Alex"</i> video game.
 * When instantiated, it will create a new main menu using the Main class. It then instantiates
 * a JFrame for each of the other menu options: level one and information screen. It will then 
 * repeatedly check to see if the the user's path choice has changed. If it has, it will dispose
 * of the currently open JFrame and open a new one according to the user's path choice. When the
 * user selects quit, the System.exit() method is called and the program closes.
 * 
 * <p>
 * <b>Instance Variables: </b>
 * <p>
 * <b>mainMenu </b> This holds the information from the Main class for the mainMenu
 * <p>
 * <b>levelOne </b> This holds the information from the LevelOne class for the first level
 * <p>
 * <b>infoScreen </b> This holds the information from the InformationScreen class for the
 *                    information screen
 * <p>
 * <b>mainMenuFrame </b> This holds the information from the JFrame class for the 
 *                       JFrame used for the main menu
 * <p>
 * <b>levelOneFrame </b> This holds the information from the JFrame class for the JFrame 
 *                       used for the first level
 * <p>
 * <b>infoScreenFrame </b> This holds the information from the JFrame class for the JFrame
 *                         used fot the information screen
 * 
 * @author James Houle
 * @version 2 05.28.19
 */
public class AnxiousAlex {
  
  Main mainMenu;
  LevelOne levelOne;
  InformationScreen infoScreen;
  
  JFrame mainMenuFrame;
  JFrame levelOneFrame;
  JFrame infoScreenFrame;
  
  /**
   * This is the constructor for the AnxiousAlex class. It firsts instantiates mainMenu as an 
   * object of the Main class, as well as instantiating levelOneFrame and infoScreenFrame as 
   * objects of the JFrame class with titles of "The Anxious Life Of Alex Joe" in both. It 
   * then repeatedly calls the checkPath method.
   */
  public AnxiousAlex (){
    
    mainMenu = new Main ();
    
    levelOneFrame = new JFrame ("The Anxious Life Of Alex Joe");
    infoScreenFrame = new JFrame ("The Anxious Life Of Alex Joe");
    
    while (true){
      checkPath ();
    }
  }
  
  /**
   * The checkPath method checks the value of the path variable from the CustomButton class to 
   * determine which part of the game the player will go to next. 
   * <p>
   * If the path variable equals
   * 1, the player will start the game. The levelOneFrame variable is instantiated as a JFrame
   * object with the title "The Anxious Life Of Alex Joe" and the levelOne variable is 
   * instantiated as a new LevelOne object. levelOne is added to the levelOneFrame JFrame and 
   * the frame's size is set to 1000 by 750, is set to be visible and its default close 
   * operation is set to EXIT_ON_CLOSE. The mainMenuFrame is then disposed and the path is set
   * back to 0.
   * <p>
   * If the path variable equals 2, the player will go to the information screen. The 
   * infoScreenFrame variable is instantiated as a JFrame
   * object with the title "The Anxious Life Of Alex Joe" and the infoScreen variable is 
   * instantiated as a new InformationScreen object. infoScreen is added to the infoScreenFrame JFrame and 
   * the frame's size is set to 1000 by 750, is set to be visible and its default close 
   * operation is set to EXIT_ON_CLOSE. The mainMenuFrame is then disposed and the path is set
   * back to 0.
   * <p>
   * If the path variable equals 3, the game will finish and exit.
   * <p>
   * If the path variable equals -999, the player will go to the mainMenu screen. The 
   * mainMenuFrame variable is instantiated as a JFrame
   * object with the title "The Anxious Life Of Alex Joe" and the mainMenu variable is 
   * instantiated as a new Main object. mainMenu is added to the mainMenuFrame JFrame and 
   * the frame's size is set to 1000 by 750, is set to be visible and its default close 
   * operation is set to EXIT_ON_CLOSE. The all other frames are then disposed and the path is set
   * back to 0.
   */
  public void checkPath (){
    if (CustomButton.getPath () == 1){
      levelOneFrame = new JFrame ("The Anxious Life Of Alex Joe");
      
      levelOne = new LevelOne ();
      levelOneFrame.add (levelOne);
      levelOneFrame.setSize (1000,750);
      levelOneFrame.setVisible (true);
      levelOneFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      mainMenuFrame.dispose ();
      mainMenu.button.setPath (0);
    }
    else if (CustomButton.getPath () == 2){
      infoScreenFrame = new JFrame ("The Anxious Life Of Alex Joe");
      
      infoScreen = new InformationScreen ();
      infoScreenFrame.add (infoScreen);
      infoScreenFrame.setSize (1000,750);
      infoScreenFrame.setVisible (true);
      infoScreenFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      mainMenuFrame.dispose ();
      mainMenu.button.setPath (0);
    }
    else if (CustomButton.getPath () == -999){
      mainMenuFrame = new JFrame ("The Anxious Life Of Alex Joe");
      
      mainMenuFrame.add (mainMenu);
      mainMenuFrame.setSize (1000,750);
      mainMenuFrame.setVisible (true);
      mainMenuFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      levelOneFrame.dispose ();
      infoScreenFrame.dispose ();
      mainMenu.button.setPath (0);
    }
    else if (CustomButton.getPath () == 3){
      System.exit(0);
    }
    else
      System.out.print ("");
  }

  /**
   * The main method creates a new instance of the AnxiousAlex class. 
   */
  public static void main (String [] main){
    new AnxiousAlex ();
  }
}