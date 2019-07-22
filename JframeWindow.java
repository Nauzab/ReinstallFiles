
package dicegame;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;


public class Window extends Canvas{
    
    public Window(int width, int heigth, String title, Game game){
        JFrame frame = new JFrame(title);
        
        frame.setPreferredSize(new Dimension(width, heigth));
        frame.setMaximumSize(new Dimension(width, heigth));
        frame.setMinimumSize(new Dimension(width, heigth));
          
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Correcly closes window on x button
        frame.setResizable(false); //dont allow resize window
        frame.setLocationRelativeTo(null); //windows pop up in middle on screen
        frame.add(game);//adding game class into frame
        frame.setVisible(true);//set frame to visiable
        game.start(); //starts frame
    }
}
