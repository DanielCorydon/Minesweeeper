package Minesweeeper;

import java.awt.*;
import java.util.ArrayList;

import Minesweeeper.Buttons.EndButton;
import Minesweeeper.Buttons.PlayAgainButton;

import java.awt.event.*;

public class EndField extends Frame {

Label winText;
Label loseText;

ActionListener winButton;

boolean isWon;

    public EndField(boolean isWon, MineField minefield) {                    //Constructor

        if (isWon) {
            this.isWon = isWon;
            this.setSize(500, 250);
            makeWindowClosable();
            createWinLabels();
            //createPlayAgain();
            this.setLayout(null);
            this.setVisible(true);
            //this.add(new EndButton());
            this.add(new PlayAgainButton(minefield, this));
        }
        else {
            this.isWon = isWon;
            this.setSize(500, 250);
            makeWindowClosable();
            createLoseLabels();
            //createPlayAgain();
            this.setLayout(null);
            this.setVisible(true);
            this.add(new PlayAgainButton(minefield, this));   
        }
        

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

    
    public void createLoseLabels() {

        winText = new Label ("Aww you lost!");
        winText.setBounds(150, 0, 200, 150);
        
        this.add(winText);

    }

    
    
/*     public void createPlayAgain() {

        StartButton win = new StartButton("Play again", actionlistener.get(3));
        win.setBounds(150, 100, 200, 150);
        
        this.add(win);


    } */

    public void setWinButton() {                   //This sets the button press by creating a new action listener
        //ACTION LISTENER 1
        winButton = new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                 
                
                 
            }
        };
    }




    

}
