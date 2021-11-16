package Minesweeeper;

import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

public class EndField extends Frame {

Label winText;
Label loseText;

ActionListener winButton;

boolean isWon;

    public EndField(boolean isWon) {                    //Constructor
        this.isWon = isWon;
        this.setSize(500, 250);
        makeWindowClosable();
        createWinLabels();
        createPlayAgain();
        this.setLayout(null);
        this.setVisible(true);

        

    }


    public void makeWindowClosable() {                  //Makes the window closable.
        addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        });   
    }

    public void createWinLabels() {

        winText = new Label ("Congratulations, you won!");
        winText.setBounds(150, 0, 200, 150);
        
        this.add(winText);

    }

    public void createPlayAgain() {

        Button win = new Button("Play again");
        win.setBounds(150, 100, 200, 150);
        
        this.add(win);


    }

    public void setWinButton() {                   //This sets the button press by creating a new action listener
        //ACTION LISTENER 1
        winButton = new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                 
                
                 
            }
        };
    }




    

}
