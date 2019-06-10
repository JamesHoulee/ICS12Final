import javax.swing.JFrame;

/**
 * The AnxiousAlex class is the Driver class for <i>"The Anxious Life of Alex"</i> video game.
 * When instantiated, it will create a new main menu using the Main class. It will then 
 * repeatedly check to see if the the user's path choice has changed. If it has, it will dispose
 * of the currently open JFrame and open a new one according to the user's path choice. When the
 * user selects quit, the System.exit() method is called and the program closes.
 * 
 * <p>
 * <b>Instance Variables: </b>
 * <p>
 * <b>mainMenu </b> This holds the information from the Main class for the mainMenu
 * <p>
 * <b>playScreen </b> This holds the information from the PlayScreen class for the level selection screen
 * <p>
 * <b>levelOne </b> This holds the information from the LevelOne class for the first level
 * <p>
 * <b>alexRoom </b> This holds the information from the AlexRoom class for Alex's room in the first level
 * <p>
 * <b>levelTwoOut </b> This holds the information from the levelTwoOutside class for the first part of the second level
 * <p>
 * <b>levelTwoHall </b> This holds the information from the levelTwoHall class for the second part of the second level
 * <p>
 * <b>mathClass </b> This holds the information from the MathClass class for the math class in the second level
 * <p>
 * <b>englishClass </b> This holds the information from the EnglishClass class for the english class in the second level
 * <p>
 * <b>infoScreen </b> This holds the information from the InformationScreen class for the information screen
 * <p>
 * <b>teachingAlex </b> This holds the information from the TeachingAlex class for the first part of the third level
 * <p>
 * <b>helpingAlex </b> This holds the information from the HelpingAlex class for the second part of the third level
 * <p>
 * <b>incLvl </b> This hold the information from the IncompleteLevel class that opens a JDialog to tell them that they 
 *                haven't completed the previous levels
 * <p>
 * <b>mainMenuFrame </b> This holds the information from the JFrame class for the JFrame used for the main menu
 * <p>
 * <b>playScreenFrame </b> This holds the information from the JFrame class for the JFrame used for the play screen
 * <p>
 * <b>levelOneFrame </b> This holds the information from the JFrame class for the JFrame used for the first level
 * <p>
 * <b>alexRoomFrame </b> This holds the information from the JFrame class for the JFrame used for Alex's room
 * <p>
 * <b>outsideSchoolFrame </b> This holds the information from the JFrame class for the JFrame used for outside of the school
 * <p>
 * <b>levelTwoHallFrame </b> This holds the information from the JFrame class for the JFrame used for the school hallway
 * <p>
 * <b>classFrame </b> This holds the information from the JFrame class for the JFrame used for the classrooms
 * <p>
 * <b>yardFrame </b> This holds the information from the JFrame class for the JFrame used for the yard
 * <p>
 * <b>infoScreenFrame </b> This holds the information from the JFrame class for the JFrame used for the information screen
 * <p>
 * <b>fromAlexRoom </b> This keeps track of whether the player was last in Alex's room
 * <p>
 * <b>fromHall </b> This keeps track of whether the player was last in the school hall
 * <p>
 * <b>fromClass </b> This keeps track of whether the player was last in a classroom
 * <p>
 * <b>fromLv1 </b> This keeps track of whether the player was last in level one
 * <p>
 * <b>fromEnglish </b> This keeps track of whether the player was last in english class
 * 
 * @author James Houle and Juan Diego Castano
 * @version 3 06.05.19
 */
public class AnxiousAlex {
  
  private Main mainMenu;
  private PlayScreen playScreen;
  private LevelOne levelOne;
  private AlexRoom alexRoom;
  private LevelTwoOutside levelTwoOut;
  private LevelTwoHall levelTwoHall;
  private MathClass mathClass;
  private EnglishClass englishClass;
  private InformationScreen infoScreen;
  private TeachingAlex teachingAlex;
  private HelpingAlex helpingAlex;
  private TeachingAlex2 teachingAlex2;
  private IncompleteLevel incLvl;
  
  private JFrame mainMenuFrame;
  private JFrame playScreenFrame;
  private JFrame levelOneFrame;
  private JFrame alexRoomFrame;
  private JFrame outsideSchoolFrame;
  private JFrame levelTwoHallFrame;
  private JFrame classFrame;
  private JFrame yardFrame;
  private JFrame infoScreenFrame;
  
  private boolean fromAlexRoom;
  private boolean fromHall;
  private boolean fromClass;
  private boolean fromLv1;
  private boolean fromEnglish;
  private boolean restartLevel2;
  private boolean restartLevel3;
  private boolean level3;
  
  /**
   * This is the constructor for the AnxiousAlex class. It firsts instantiates mainMenu as an 
   * object of the Main class, as well as setting all the from___ variables to be false. It then repeatedly
   * checks to see the path and the anxiety level
   */
  public AnxiousAlex (){
    
    mainMenu = new Main ();
    
    Inventory.setPencilCase (false);
    
    while (true){
      checkPath ();
      checkAnxiety ();
    }
  }
  
  /**
   * The checkPath method checks what path the player has selected to go to and creates the path's respective frame
   */
  private void checkPath (){
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
      if (fromHall == true){
        levelTwoOut = new LevelTwoOutside (1);
        levelTwoHallFrame.dispose ();
        fromHall = false;
      }
      else if (fromLv1 == true){        
        levelTwoOut = new LevelTwoOutside (0);
        levelOneFrame.dispose ();
        fromLv1 = false;
      }
      else {
        if (LevelOne.levelComplete () == true){
          levelTwoOut = new LevelTwoOutside (0);
          playScreenFrame.dispose ();
        }
        else{
          incLvl = new IncompleteLevel (1);
        }
      }
      if (LevelOne.levelComplete () == true){
        outsideSchoolFrame = new JFrame ("The Anxious Life Of Alex Joe");
        outsideSchoolFrame.add (levelTwoOut);
        outsideSchoolFrame.setSize (1000,750);
        outsideSchoolFrame.setVisible (true);
        outsideSchoolFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        if (restartLevel2 == true)
            new RestartLevel (2);
      }
      mainMenu.button.setPath (0);
    }
    else if (CustomButton.getPath () == 6){
      if (EnglishClass.levelComplete () == true){
        alexRoomFrame = new JFrame ("The Anxious Life Of Alex Joe");
        teachingAlex = new TeachingAlex ();
        level3 = true;
        alexRoomFrame.add (teachingAlex);
        alexRoomFrame.setSize (1000,750);
        alexRoomFrame.setVisible (true);
        alexRoomFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        if (restartLevel3 == true)
          new RestartLevel (3);
      }
      if (fromEnglish == true){
        classFrame.dispose ();
        fromEnglish = false;
      }
      else {
        if (EnglishClass.levelComplete () == true){
          playScreenFrame.dispose ();
        }
        else{
          incLvl = new IncompleteLevel (2);
        }
      }
      mainMenu.button.setPath(0);
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
      if (fromClass == false){
        outsideSchoolFrame.dispose ();
        levelTwoHall = new LevelTwoHall (0);
      }
      else {
        levelTwoHall = new LevelTwoHall (1);
        classFrame.dispose ();
        fromClass = false;
      }
      levelTwoHallFrame.add (levelTwoHall);
      levelTwoHallFrame.setSize (1000,750);
      levelTwoHallFrame.setVisible (true);
      levelTwoHallFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
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
        if (CustomButton.getPath () == 8){
          checkTest = false;
        }
        System.out.print ("");
        if (mathClass.testOpen () == true){
          Test test = new Test (classFrame, "Math Test");
          checkTest = false;
        }
      }
    }
    else if (CustomButton.getPath () == 10){
      classFrame = new JFrame ("The Anxious Life Of Alex Joe");
      englishClass = new EnglishClass (1);
      classFrame.add (englishClass);
      classFrame.setSize (1000,750);
      classFrame.setVisible (true);
      classFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      levelTwoHallFrame.dispose ();
      mainMenu.button.setPath (0);
      fromClass = true;
      fromEnglish = true;
    }
    else if (CustomButton.getPath () == 11){
      fromClass = false;
      helpingAlex = new HelpingAlex ();
      yardFrame.add (helpingAlex);
      yardFrame.setSize (1000,750);
      yardFrame.setVisible (true);
      yardFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      alexRoomFrame.dispose ();
      mainMenu.button.setPath (0);
    }
    else if (CustomButton.getPath () == 12){
      yardFrame.dispose ();
      outsideSchoolFrame = new JFrame ("The Anxious Life Of Alex Joe");
      teachingAlex2 = new TeachingAlex2 ();
      outsideSchoolFrame.add (teachingAlex2);
      outsideSchoolFrame.setSize (1000,750);
      outsideSchoolFrame.setVisible (true);
      outsideSchoolFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      mainMenu.button.setPath (0);
    }
    else if (CustomButton.getPath () == 13){
      outsideSchoolFrame.dispose ();
      levelTwoHallFrame = new JFrame ("The Anxious Life Of Alex Joe");
      levelTwoHall = new LevelTwoHall (3);
      levelTwoHallFrame.add (levelTwoHall);
      levelTwoHallFrame.setSize (1000,750);
      levelTwoHallFrame.setVisible (true);
      levelTwoHallFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      mainMenu.button.setPath (0);
    }
    else if (CustomButton.getPath () == 14){
      fromEnglish = true;
      levelTwoHallFrame.dispose ();
      classFrame = new JFrame ("The Anxious Life Of Alex Joe");
      englishClass = new EnglishClass (3);
      classFrame.add (englishClass);
      classFrame.setSize (1000,750);
      classFrame.setVisible (true);
      classFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      mainMenu.button.setPath (0);
    }
    else if (CustomButton.getPath () == -999){
      mainMenuFrame = new JFrame ("The Anxious Life Of Alex Joe");
      mainMenuFrame.add (mainMenu);
      mainMenuFrame.setSize (1000,750);
      mainMenuFrame.setVisible (true);
      mainMenuFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      disposeAll ();
      mainMenu.button.setPath (0);
      level3 = false;
    }
    else
      System.out.print ("");
  }
  
  /**
   * The checkAnxiety method checks to see whether or not the player's anxiety has reached max. If it has, it will
   * cause the player to restart their level.
   */
  private void checkAnxiety (){
    if (AnxietyBar.getPercent () >= 100){
      if (fromEnglish == false){
        if (AnxietyBar.getPercent () >= 100){
          if (fromClass == true){
            AnxietyBar.setPercent (0);
            fromClass = false;
            fromHall = false;
            mathClass.timer.stop();
            classFrame.dispose ();
            mainMenu.button.setPath (5);
            restartLevel2 = true;
          }
          if (helpingAlex.inYard () == true){
            AnxietyBar.setPercent (0);
            yardFrame.remove (helpingAlex);
            helpingAlex.timer.stop();
            helpingAlex.leaveYard ();
            yardFrame.dispose ();
            mainMenu.button.setPath (6);
            restartLevel3 = true;
          }
        }
      }
      else {
        if (level3 == false){
          englishClass.timer.stop();
          englishClass.completeLevel ();
          mainMenu.button.setPath (6);
        }
        else {
          AnxietyBar.setPercent (0);
          classFrame.remove (helpingAlex);
          englishClass.timer.stop();
          classFrame.dispose ();
          classFrame.remove (englishClass);
          mainMenu.button.setPath (6);
          restartLevel3 = true;
          fromEnglish = false;
        }
      }
    }
  }
  
  /**
   * The disposeAll method attempts to close every single frame except for the main menu frame.
   */
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
      outsideSchoolFrame.dispose ();
    }
    catch (NullPointerException e){
      outsideSchoolFrame = new JFrame ();
      outsideSchoolFrame.dispose ();
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
    
    try {
      yardFrame.dispose ();
    }
    catch (NullPointerException e){
      yardFrame = new JFrame ();
      yardFrame.dispose ();
    }      
  }

  /**
   * The main method creates a new instance of the AnxiousAlex class. 
   */
  public static void main (String [] main){
    new AnxiousAlex ();
  }
}