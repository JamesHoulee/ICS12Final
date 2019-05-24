import javax.swing.JPanel; 

/**
 * 
 * 
 */

public class InformationScreen extends JPanel{

    MenuButton button; 
    private String text = "";

    public InformationScreen (){
        setSize(1000,750); 
        setVisible (true); 
        
        //added by james for proof of concept
        button = new MenuButton (100,100);
        add (button);
        
        //button = new CustomButton ("Back", 250, 150); 
    }  
    /*
    public void paintComponent (Graphics g){
        g.setColor(Color.BLACK); 
        g.setFont (Font.decode ("arial-BOLD-24")); 
        g.drawString ("Just Testing", 100,100); 
    }*/

}