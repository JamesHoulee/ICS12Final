import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import javax.swing.SpringLayout;

/**
 * The LevelOne class is a subclass of JPanel and implements both ActionListener and KeyListener. 
 * This class defines the progression of the first level of the game. The controls a character
 * who moves across a background (the background moves behind the player) while they learn how to play 
 * the game. The class defines boundaries in which that player cannot move through and the player can 
 * trigger certain events like the movement of a non-player character or the changing of the main
 * character's anxiety level when the player reaches specific points in the game. 
 * 
 * <p>
 * <b>Instance Variables: </b>
 * <p>
 * <b>sprite </b> This variable holds the information of an Images object representing the player's
 *                sprite
 * <p>
 * <b>background </b> This variable holds the information of an Images object representing the level's
 *                background
 * <p>
 * <b>brotherSprite </b> This variable holds the information of and Images object representing the sprite 
 *                       of the character's big brother 
 * <p>
 * <b>layout </b> This variable holds the information of a SpringLayout object for the layout of the JPanel
 * <p>
 * <b>menuButton </b> This variable holds the information of a MenuButton object that will display a 
 *                    button that allows the player to go back to the main menu.
 * <p>
 * <b>anxietyBar </b> This variable holds the information of an Anxietybar object that will display an
 *                    anxiety bar on the screen.
 * <p>
 * <b>animationNum </b> This variable keeps track of what animation will be performed next on screen
 * <p>
 * <b>timer </b> This variable holds the information of a Timer object 
 * <p>
 * <b>x </b> This variable contains the x value of the player's character relative to it's starting point
 * <p>
 * <b>y </b> This variable contains the y value of the player's character relative to it's starting point
 * <p>
 * <b>dx </b> This variable contains the speed of the player's character in the horizontal directions
 * <p>
 * <b>dy </b> This variable contains the speed of the player's character in the vertical direction 
 * <p>
 * <b>anxietyPercent </b> This varibale contains the percent of the character's anxiety from 0 to 100
 * <p>
 * <b>bigBroX </b> This variable contains the x value of the big brother character relative to the background
 * <p>
 * <b>bigBroY </b> This variable contains the y value of the big brother character relative to the background
 * <p>
 * 
 * @author James Houle and Juan Diego Castano
 * @version 3 05.28.19
 */
public class LevelOne extends JPanel implements ActionListener, KeyListener {
   
  Images sprite;
  Images background;
  Images brotherSprite;
  Images slime;
  Images firstText;
  Images secondText;
  Images thirdText;
  Images fourthText;
  Images fifthText;
  Images sixthText;
  Images seventhText;
  Images eighthText;
  Images ninthText;
  
  SpringLayout layout;
  
  MenuButton menuButton;
  AnxietyBar anxietyBar;
  Inventory inventory;
  
  int animationNum;
  boolean check1;
  boolean slime1Taken;
  
  /**
   * This instantiates a new timer object with parameters 5 and <b>this</b>
   */
  Timer timer = new Timer(5,this);
  private int x, y, dx = 0, dy = 0;
  
  private int bigBroX, bigBroY;
  
  /**
   * This is the constructor for the LevelOne Class. This class instatiates all the required images
   * (sprite, background and brotherSprite) as well as menuButton and anxietyBar. It also instatiates 
   * layout to be a new SpringLayout. Additionally, it sets up the constraints for all the instantiated
   * objects.
   */
  public LevelOne (int x, int y, int animationNumber, int bigX, int bigY){
    
    /**
     * This instantiates a new Images object with a location of "AlexSmile.png" and dimensions of 200 by 200
     */
    sprite = new Images ("AlexSmile.png",200,200);
    /**
     * This instantiates a new Images object with a location of "BackgroundVersion1.png" and dimensions of 
     * 8000 by 750
     */
    background = new Images ("BackgroundVersion1.png",8000,750);
    /**
     * This instantiates a new Images object with a location of "BigBrother.png" and a dimensions 210 by 200
     */
    brotherSprite = new Images ("BigBrother.png",210,200);
    /**
     * This instantiates a new MenuButton object with dimension of 135 by 40
     */
    menuButton = new MenuButton (135,40);
    
    slime = new Images ("Slime.png",150,60);
    firstText = new Images ("LevelOneA.png",390,255); //-------------
    secondText = new Images ("LevelOneB.png",280,145);
    thirdText = new Images ("LevelOneC.png",280,145);
    fourthText = new Images ("LevelOneD.png",280,145);
    fifthText = new Images ("LevelOneE.png",280,145);
    sixthText = new Images ("LevelOneF.png",390,255);
    seventhText = new Images ("LevelOneG.png",280,145);
    eighthText = new Images ("LevelOneH.png",415,205);
    ninthText = new Images ("LevelOneI.png",330,205);
    
    inventory = new Inventory ();
    
    /**
     * This instantiates a new AnxietyBar object which is 0% full
     */
    anxietyBar = new AnxietyBar ();
    
    this.x = x;
    this.y = y;
    animationNum = animationNumber;
    check1 = false;
    slime1Taken = false;
    
    bigBroX = bigX;
    bigBroY = bigY;
    
    //This code is taken from https://www.youtube.com/watch?v=Km81XyczqC4
    timer.start ();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    //End of source code
    
    //setVisible (true);
    layout = new SpringLayout ();
    setLayout (layout);
    
    //applies the constraints for the menu button and adds it to the JPanel
    layout.putConstraint (layout.EAST, menuButton, 25, layout.EAST, this);
    layout.putConstraint (layout.NORTH, menuButton, 10, layout.NORTH, this);
    add (menuButton);
    
    //applies the constraints for the main character's sprite and adds it to the JPanel
    layout.putConstraint (layout.EAST, sprite, 250, layout.WEST, this);
    layout.putConstraint (layout.NORTH, sprite, 450, layout.NORTH, this);
    add (sprite);
    
    //applies the constraints for the big brother's sprite and adds it to the JPanel
    layout.putConstraint (layout.WEST, brotherSprite, 790, layout.WEST, background);
    layout.putConstraint (layout.NORTH, brotherSprite, 405, layout.NORTH, this);
    add (brotherSprite);
    
    layout.putConstraint (layout.SOUTH, firstText, 30, layout.NORTH, brotherSprite);
    layout.putConstraint (layout.EAST, firstText, 115, layout.WEST, brotherSprite); //--------------
    add (firstText);
    
    layout.putConstraint (layout.SOUTH, secondText, 70, layout.NORTH, brotherSprite);
    layout.putConstraint (layout.EAST, secondText, 75, layout.WEST, brotherSprite);
    add (secondText);
    secondText.setVisible (false);
    
    layout.putConstraint (layout.SOUTH, thirdText, 70, layout.NORTH, brotherSprite);
    layout.putConstraint (layout.EAST, thirdText, 75, layout.WEST, brotherSprite);
    add (thirdText);
    thirdText.setVisible (false);
    
    layout.putConstraint (layout.SOUTH, fourthText, 50, layout.NORTH, sprite);
    layout.putConstraint (layout.WEST, fourthText, -50, layout.EAST, sprite);
    add (fourthText);
    fourthText.setVisible (false); 
    
    layout.putConstraint (layout.SOUTH, fifthText, 70, layout.NORTH, brotherSprite);
    layout.putConstraint (layout.EAST, fifthText, 75, layout.WEST, brotherSprite);
    add (fifthText);
    fifthText.setVisible (false);
    
    layout.putConstraint (layout.SOUTH, sixthText, 30, layout.NORTH, brotherSprite);
    layout.putConstraint (layout.EAST, sixthText, 115, layout.WEST, brotherSprite); //--------------
    add (sixthText);
    sixthText.setVisible (false);
    
    layout.putConstraint (layout.SOUTH, seventhText, 50, layout.NORTH, sprite);
    layout.putConstraint (layout.WEST, seventhText, -50, layout.EAST, sprite);
    add (seventhText);
    seventhText.setVisible (false);
    
    layout.putConstraint (layout.SOUTH, ninthText, 30, layout.NORTH, brotherSprite);
    layout.putConstraint (layout.EAST, ninthText, 115, layout.WEST, brotherSprite); //--------------
    add (ninthText);
    ninthText.setVisible (false);
    
    layout.putConstraint (layout.SOUTH, eighthText, 30, layout.NORTH, brotherSprite);
    layout.putConstraint (layout.EAST, eighthText, 115, layout.WEST, brotherSprite); //--------------
    add (eighthText);
    eighthText.setVisible (false);
    
    //applies the constraints for the anxiety bar and adds it to the JPanel
    layout.putConstraint (layout.WEST, anxietyBar, 25, layout.WEST, this);
    layout.putConstraint (layout.NORTH, anxietyBar, 10, layout.NORTH, this);
    add (anxietyBar);
    
    layout.putConstraint (layout.WEST, slime, 6620, layout.WEST, background);
    layout.putConstraint (layout.SOUTH, slime, -160, layout.SOUTH, background);
    add (slime);
    slime.setVisible (false);
    
    layout.putConstraint (layout.SOUTH, inventory, 115, layout.SOUTH, this);
    layout.putConstraint (layout.WEST, inventory, 0, layout.WEST, this);
    add (inventory);
    
    //applies the constraints for the background and adds it to the JPanel
    layout.putConstraint (layout.WEST, background, 0, layout.WEST, this);
    layout.putConstraint (layout.NORTH, background, 0, layout.NORTH, this);
    add (background);
  }
  
  /**
   * The actionPerformed method defines how the game reacts to a players specific input. This method 
   * defines the boundaries of the game, the movement of the jump, and how the playeer is allowed to 
   * move around stairs. It also defines the locations of events in the game like when the anxiety
   * bar has to change, and when and how the non-player characters will move. 
   * 
   * @param e is an object of the ActionEvent class
   */
  public void actionPerformed (ActionEvent e){
    //stops player from leaving boundries
    if (x < 0){
      dx = 0;
      x = 0;
    }
    if (x > 7580){
      dx = 0;
      x = 7580;
    }
    
    //defines the movement of the jump pre/post stairs
    if (x <= 1075 || x >= 4155){
      if (dy == -2 && y < -200){
        dy = 2;
        y = -200;
      }
      if (dy == 2 && y > 0){
        dy = 0;
        y = 0;
        dx = 0;
      }
    
      if (y == -90 && dy == 0)
        y = 0;
    }
    //Stop the players from walking through the steps
    //Step one
    if (x>1075 && x <=1170){
      if (y == 0){
        dx = 0;
        x = 1075;
      }
      if (y > -90 && x>1075){
        dy = 0;
        y = -90;
      }
      if (dy == -2 && y < -290){
        dy = 2;
        y = -290;
      }
      
      if (x <1170 && y == -180 && dy == 0)
        y = -90;
    }
    //step two
    if (x>1170 && x <= 1265){
      if (y == -90){
        dx = 0;
        x = 1170;
      }
      if (y > -180 && x > 1170){
        dy = 0;
        y = -180;
      }
      if (dy == -2 && y < -380){
        dy = 2;
        y = -380;
      }
      
      if (x < 1265 && y == -270 && dy == 0)
        y = -180;
    }
    //step three
    if (x>1265 && x <=1360){
      if (y == -180){
        dx = 0;
        x = 1265;
      }
      if (y > -270 && x > 1265){
        dy = 0;
        y = -270;
      }
      if (dy == -2 && y < -470){
        dy = 2;
        y = -470;
      }
      
      if (x <1360 && y == -360 && dy == 0)
        y = -270;
    }
    //top
    if (x>1360 && x <3870){
      if (y == -270 && x < 3800){
        dx = 0;
        x = 1360;
      }
      if (y > -360 && x > 1360){
        dy = 0;
        y = -360;
      }
      if (dy == -2 && y < -560){
        dy = 2;
        y = -560;
      }
      if (dy == 2 && y >= -365){
        dy = 0;
        y = -360;
        dx = 0;
      }
    }
    
    //going down the stairs
    //first step
    if (x >= 3870 && x < 3965){
      if (y == -270 && dy != -2 && x < 3880 && dx == -3){
        x = 3870;
        dx = 0;
      }
      if (dy == -2 && y < -470){
        dy = 2;
        y = -470;
      }
      if (dy == 2 && y > -270){
        dy = 0;
        y = -270;
        dx = 0;
      }
      if (dy == 0)
        y = -270; 
    }
    //second step
    if (x >= 3965 && x < 4060){
      if (y == -180 && dy != -2 && x < 3975 && dx == -3){
        x = 3965;
        dx = 0;
      }
      if (dy == -2 && y < -380){
        dy = 2;
        y = -380;
      }
      if (dy == 2 && y > -180){
        dy = 0;
        y = -180;
        dx = 0;
      }
      if (dy == 0)
        y = -180;
    }
    //third step
    if (x >= 4065 && x < 4155){
      if (y == -90 && dy != -2 && x < 4075 && dx == -3){
        x = 4065;
        dx = 0;
      }
      if (dy == -2 && y < -290){
        dy = 2;
        y = -290;
      }
      if (dy == 2 && y > -90){
        dy = 0;
        y = -90;
        dx = 0;
      }
      if (dy == 0)
        y = -90;
    }
    //bottom
    if (y == 0 && dy != -2 && x >= 4155 && x <4165 && dx == -3){
      x = 4155;
      dx = 0;
    }
    
    //ALL OF THE UPDATE CHECKERS COULD PROBABLY BE THEIR OWN METHODS
    
    //slime updates
    if (x >= 6400 && x <= 6402 && slime1Taken == false){
      anxietyBar.setPercent (anxietyBar.getPercent () - 15);
      update ();
      slime1Taken = true;
      remove (slime);
    }
    
    //Anxiety bar updates
    if (x >= 2000 && x <= 2002 && check1 == false){
      anxietyBar.setPercent (15);
      check1 = true;
    }
    
    //moving big bro
    if (x >= 500 && x <1350)
      animationNum = 1;
    else if (x >= 1350 && x < 2550)
      animationNum = 2;
    else if (x >= 2550 && x < 3400)
      animationNum = 3;
    else if (x >= 3400 && x < 4250)
      animationNum = 4;
    else if (x >= 4250 && x < 5300)
      animationNum = 5;
    else if (x >= 5300)
      animationNum = 6;
    else 
      animationNum = 0;
    
    if (animationNum == 1){
      firstText.setVisible (false);
      if (bigBroX < 1125)
        bigBroX+=3;
      if (bigBroX >= 1125 && bigBroX < 1600 && bigBroY > 80){
        bigBroX +=2;
        bigBroY -=2;
      }
      if (bigBroX < 1800 && bigBroY <= 80)
        bigBroX +=3;
      if (bigBroY == 81)
        secondText.setVisible (true);
    }
    
    if (animationNum == 2){
      firstText.setVisible (false);
      secondText.setVisible (false);
      if (bigBroX <= 3000)
        bigBroX += 3;
      if (bigBroX >= 2600)
        thirdText.setVisible (true);
    }
    
    if (animationNum == 3){
      if (bigBroX > 2550 && bigBroX < 4000){
        fourthText.setVisible (true);
        thirdText.setVisible (false);
      }
      if (bigBroX <= 3730)
        bigBroX += 3;
      if (bigBroX == 3732){
        fourthText.setVisible (false);
        fifthText.setVisible (true);
      }
    }
    
    if (animationNum == 4){
      if (bigBroX <= 4600)
        bigBroX += 3;
      if (bigBroX <3930)
        bigBroY = 80;
      else if (bigBroX < 4020) 
        bigBroY = 170;
      else if (bigBroX < 4110)
        bigBroY = 260;
      else if (bigBroX < 4200)
        bigBroY = 350;
      else
        bigBroY = 460;
      if (bigBroX == 4602){
        fifthText.setVisible (false);
        sixthText.setVisible (true);
      }
    }
    if (animationNum == 5){
      sixthText.setVisible (false);
      seventhText.setVisible (true);
      eighthText.setVisible (true);
      if (bigBroX <= 5700)
        bigBroX += 3;
    }
    if (animationNum == 6){
      seventhText.setVisible (false);
      if (bigBroX <= 6800)
        bigBroX += 3;
      if (bigBroX == 6102)
        eighthText.setVisible (false);
      if (bigBroX == 6801){
        ninthText.setVisible (true);
        slime.setVisible (true);
      }
    }
    
    update(); 
    x = x + dx;
    y = y + dy;
    repaint();
  }
  
  /**
   * The update method redefines the constraints of any objects that can move or change
   */
  public void update (){
    
    //This redefines the constraints of anxietyBar
    layout.putConstraint (layout.WEST, anxietyBar, 25, layout.WEST, this);
    layout.putConstraint (layout.NORTH, anxietyBar, 10, layout.NORTH, this);
    
    //This redefines the constraints of sprite
    layout.putConstraint (layout.NORTH, sprite, 450+y, layout.NORTH, this);
    layout.putConstraint (layout.EAST, sprite, 250, layout.WEST, this);
    
    //This redefines the constraints of background
    layout.putConstraint (layout.WEST, background, 0-x, layout.WEST, this);
    layout.putConstraint (layout.NORTH, background, 0, layout.NORTH, this);
    
    //This redefines the constraints of brotherSprite
    layout.putConstraint (layout.WEST, brotherSprite, bigBroX, layout.WEST, background);
    layout.putConstraint (layout.NORTH, brotherSprite, bigBroY, layout.NORTH, this);
    
    refresh();
  }
  
  /**
   * The refresh method calls upon the repaint and revalidate methods
   */
  public void refresh (){
      repaint ();
      revalidate ();
  }
  
  /**
   * The keyPressed method defines how the program will react when certain keys are pressed
   * 
   * @param e is a KeyEvent object
   * @source https://www.youtube.com/watch?v=Km81XyczqC4
   */
  public void keyPressed (KeyEvent e){ //put override?
    int c = e.getKeyCode();
    
    if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A) {
      dx = -3;
    }
    if (c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D){
      dx = 3;
    }
    if ((c == KeyEvent.VK_UP || c == KeyEvent.VK_W )&& (y == 0 || y == -90 || y == -180 || y == -270 || y == - 360)){
      dy = -2;
      update();
    }
    if (c == KeyEvent.VK_E && (x >= 2030 && x <2060)){
      menuButton.setPath (7);
    }
    if (c == KeyEvent.VK_E && x >= 7540 && x <= 7580){
      menuButton.setPath (5);
    }
  }
  
  /**
   * The keyTyped method is an inherited method with no uses in this class
   * 
   * @param e is a KeyEvent object
   */
  public void keyTyped (KeyEvent e){} //put override?

  /**
   * The keyReleased method defines what happens when the player releases whatver key they were pressing
   * 
   * @param e is a KeyEvent object
   */
  public void keyReleased (KeyEvent e){ //put override?
    int c = e.getKeyCode();
    if (c != KeyEvent.VK_E){
      if (dy == -2 || dy == 2){
        if (dx == -3)
          dx = -3;
        else if (dx == 3)
          dx = 3;
      }
      else 
        dx = 0;
    }
  }
  
  //temp
  public static void main (String [] args){
    new AnxiousAlex ();
  }
}