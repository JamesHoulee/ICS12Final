import javax.swing.JPanel; 

/**
 * 
 * 
 */

public class InformationScreen extends JPanel{

    CustomButton button; 
    private String text = "";

    public InformationScreen (){
        setSize(1000,750); 
        setVisible (true); 
        button = new CustomButton ("Back", 250, 150); 
    }  
    /*
    public void paintComponent (Graphics g){
        g.setColor(Color.BLACK); 
        g.setFont (Font.decode ("arial-BOLD-24")); 
        g.drawString ("Just Testing", 100,100); 
    }*/

}