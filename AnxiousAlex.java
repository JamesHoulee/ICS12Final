import javax.swing.JFrame;
import javax.swing.SpringLayout;

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
 *                         used for the information screen
 * 
 * @author James Houle and Juan Diego Castano
 * @version 3 06.05.19
 */
public class AnxiousAlex {
  
  Main mainMenu;
  LevelOne levelOne;
  AlexRoom alexRoom; //add to var dic
  LevelTwoOutside levelTwoOut; //
  LevelTwoHall levelTwoHall; //
  InformationScreen infoScreen;
  PlayScreen playScreen; //add to var dic
  MathClass mathClass; //
  EnglishClass englishClass; //
  
  JFrame mainMenuFrame;
  JFrame playScreenFrame; //add to var dic
  JFrame levelOneFrame;
  JFrame alexRoomFrame; //add to var dic
  JFrame levelTwoOutFrame; //
  JFrame levelTwoHallFrame; //
  JFrame classFrame; //
  JFrame infoScreenFrame;
  
  boolean fromAlexRoom;
  boolean fromHall;
  boolean fromClass;
  boolean fromLv1;
  boolean fromEnglish;
  
  SpringLayout layout;
  
  /**
   * This is the constructor for the AnxiousAlex class. It firsts instantiates mainMenu as an 
   * object of the Main class, as well as instantiating levelOneFrame and infoScreenFrame as 
   * objects of the JFrame class with titles of "The Anxious Life Of Alex Joe" in both. It 
   * then repeatedly calls the checkPath method.
   */
  public AnxiousAlex (){
    
    mainMenu = new Main ();
    
    fromAlexRoom = false;
    fromHall = false;
    fromClass = false;
    fromLv1 = false;
    fromEnglish = false;
    
    Inventory.setPencilCase (false);
    
    layout = new SpringLayout ();
    
    while (true){
      checkPath ();
      checkAnxiety ();
    }
  }
  
  /**
   * 
   */
  public void checkPath (){
    if (CustomButton.getPath () == 1){
      playScreenFrame = new JFrame ("The Anxious Life Of Alex Joe");
      
      playScreen = new PlayScreen ();
      playScreenFrame.add (playScreen);
      playScreenFrame.setSize (1000,750);
      playScreenFrame.setVisible (true);
      playScreenFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
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
      
      boolean checkScreen = true;
      while (checkScreen){
        infoScreen.checkScreen ();
        if (infoScreen.screen == 3)
          checkScreen = false;
      }
    }
    else if (CustomButton.getPath () == 3){
      System.exit(0);
    }
    else if (CustomButton.getPath () == 4){
      levelOneFrame = new JFrame ("The Anxious Life Of Alex Joe");
      
      if (fromAlexRoom == false){
        levelOne = new LevelOne (0,0,0,790,405);
        playScreenFrame.dispose ();
      }
      else {
        levelOne = new LevelOne (2030,-360,2,3000,80);
        alexRoomFrame.dispose ();
        fromAlexRoom = false;
      }
      
      levelOneFrame.setSize (1000,750);
      levelOneFrame.setVisible (true);
      levelOneFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      levelOneFrame.add (levelOne);
      mainMenu.button.setPath (0);
      fromLv1 = true;
    }
    else if (CustomButton.getPath () == 5){
      levelTwoOutFrame = new JFrame ("The Anxious Life Of Alex Joe");
      
      levelTwoOut = new LevelTwoOutside ();
      levelTwoOutFrame.add (levelTwoOut);
      levelTwoOutFrame.setSize (1000,750);
      levelTwoOutFrame.setVisible (true);
      levelTwoOutFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      if (fromHall == true){
        levelTwoHallFrame.dispose ();
        fromHall = false;
      }
      else if (fromLv1 == true){
        levelOneFrame.dispose ();
        fromLv1 = false;
      }
      else {
        playScreenFrame.dispose ();
      }
      mainMenu.button.setPath (0);
    }
    else if (CustomButton.getPath () == 7){
      alexRoomFrame = new JFrame ("The Anxious Life Of Alex Joe");
      
      alexRoom = new AlexRoom ();
      alexRoomFrame.add (alexRoom);
      alexRoomFrame.setSize (1000,750);
      alexRoomFrame.setVisible (true);
      alexRoomFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      levelOneFrame.dispose ();
      mainMenu.button.setPath (0);
      
      fromAlexRoom = true;
    }
    else if (CustomButton.getPath () == 8){
      levelTwoHallFrame = new JFrame ("The Anxious Life Of Alex Joe");
      
      levelTwoHall = new LevelTwoHall ();
      levelTwoHallFrame.add (levelTwoHall);
      levelTwoHallFrame.setSize (1000,750);
      levelTwoHallFrame.setVisible (true);
      levelTwoHallFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      if (fromClass == false){
        levelTwoOutFrame.dispose ();
      }
      else {
        classFrame.dispose ();
        fromClass = false;
      }
      mainMenu.button.setPath (0);
      fromHall = true;
    }
    else if (CustomButton.getPath () == 9){     
      classFrame = new JFrame ("The Anxious Life Of Alex Joe");
      
      mathClass = new MathClass ();
      classFrame.add (mathClass);
      classFrame.setSize (1000,750);
      classFrame.setVisible (true);
      classFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      levelTwoHallFrame.dispose ();
      mainMenu.button.setPath (0);
      fromClass = true;
      
      boolean checkTest = true;
      while (checkTest){
        System.out.print ("");
        if (mathClass.testOpen () == true){
          Test test = new Test (classFrame, "Math Test");
          checkTest = false;
        }
      }
    }
    else if (CustomButton.getPath () == 10){
      classFrame = new JFrame ("The Anxious Life Of Alex Joe");
      
      englishClass = new EnglishClass ();
      classFrame.add (englishClass);
      classFrame.setSize (1000,750);
      classFrame.setVisible (true);
      classFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      levelTwoHallFrame.dispose ();
      mainMenu.button.setPath (0);
      fromClass = true;
      fromEnglish = true;
    }
    else if (CustomButton.getPath () == -999){
      mainMenuFrame = new JFrame ("The Anxious Life Of Alex Joe");
      
      mainMenuFrame.add (mainMenu);
      mainMenuFrame.setSize (1000,750);
      mainMenuFrame.setVisible (true);
      mainMenuFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      disposeAll ();
      mainMenu.button.setPath (0);
    }
    else
      System.out.print ("");
  }
  
  private void checkAnxiety (){
    if (AnxietyBar.getPercent () == 100){
      if (fromEnglish == false){
        System.out.println ("remove me!");
      }
      else {
        System.out.println ("presentation failed");
      }
    }
    
  }
  
  private void disposeAll (){
    try {
      playScreenFrame.dispose ();
    }
    catch (NullPointerException e){
      levelOneFrame = new JFrame ();
      levelOneFrame.dispose ();
    }
    
    try {
      levelOneFrame.dispose ();
    }
    catch (NullPointerException e){
      playScreenFrame = new JFrame ();
      playScreenFrame.dispose ();
    }
    
    try {
      alexRoomFrame.dispose ();
    }
    catch (NullPointerException e){
      alexRoomFrame = new JFrame ();
      alexRoomFrame.dispose ();
    }
    
    try {
      levelTwoOutFrame.dispose ();
    }
    catch (NullPointerException e){
      levelTwoOutFrame = new JFrame ();
      levelTwoOutFrame.dispose ();
    }
    
    try {
      levelTwoHallFrame.dispose ();
    }
    catch (NullPointerException e){
      levelTwoHallFrame = new JFrame ();
      levelTwoHallFrame.dispose ();
    }
    
    try {
      classFrame.dispose ();
    }
    catch (NullPointerException e){
      classFrame = new JFrame ();
      classFrame.dispose ();
    }
    
    try {
      infoScreenFrame.dispose ();
    }
    catch (NullPointerException e){
      infoScreenFrame = new JFrame ();
      infoScreenFrame.dispose ();
    }
  }

  /**
   * The main method creates a new instance of the AnxiousAlex class. 
   */
  public static void main (String [] main){
    new AnxiousAlex ();
  }
}