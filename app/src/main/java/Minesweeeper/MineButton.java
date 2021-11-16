package Minesweeeper;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * MineButton
 */

public class MineButton extends Button {
    
    private int nearbyBombs;                        //This int tracks how many of the nearbyButtons are bombs
    
    private ArrayList<MineButton> nearbyButtons;    //This arraylist contains up to eight MineButtons, which represents the adjacent MineButtons to this one
    private ActionListener buttonpress;             //This Actionlistener will be used to press the button

    private boolean isClicked;                      //This boolean checks whether this button has been clicked
    private boolean isBomb;                         //This boolean checks if THIS MineButton is a bomb


    public MineButton(boolean isBomb) {             //Constructor
        super("X");
        this.isBomb = isBomb;
        setActionListener();
        isClicked = false;

    }

    
    public boolean getClicked() {
        return isClicked;                               //Returns whether the button is clicked or not.
    }       

    public void buttonIsClicked(boolean isClicked) {
        this.isClicked = isClicked;                     //Mutator method to change if the button is clicked
    }

    public boolean getIsBomb() {                        //Returns true / false depending on whether this MineButton is a bomb
        return isBomb;
    }

    public int getNearbyBombs() {                     //Returns int of how many Buttons adjacent are bombs.
        return nearbyBombs;
    }

    public ActionListener getThisAction() {             //This returns the actionlistener which is used for the button press
        return buttonpress;
    }

    public void buttonClicked() {                       //Method to call when the button is clicked. Should contain three logic statements, one if it is a bomb, one if it has nearby bombs, and one if there are no nearby bombs
        
        if (this.isClicked==false) {                         //Checks if this button is clicked

        if (isBomb) {                                     //If this is a bomb
        
            System.out.println("Boom goes the mine - You are dead.");
            this.isClicked=true;
        
        }
        
        else if (nearbyBombs!=0){                               //If this has nearby bombs
            
            this.setLabel(Integer.toString(nearbyBombs));
            this.isClicked=true;
        
        }

        else {                                           //If no nearby buttons are bombs
            this.setLabel(" ");
            this.isClicked=true;
            clickNearby();
        }
        }
        

    }

    public void clickNearby() {                         //Click all nearby buttons (this is only called if none of them are bombs)
        int counter = 0;
        for (MineButton mineButton : nearbyButtons) {
            if (nearbyButtons.get(counter).getClicked()==false && mineButton.isBomb==false) {
            nearbyButtons.get(counter).buttonClicked();
            }
            counter++;
        }
    }

    public void setActionListener() {                   //This sets the button press by creating a new action listener
        //ACTION LISTENER 1
        buttonpress = new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                 buttonClicked();
                 
            }
        };
    }

    public void getNeighbors(ArrayList<MineButton> neighbors, int nearbyBombs) {    //This method gets the nearby button boolean values and stores them in an arraylist.
        nearbyButtons = neighbors;
        this.nearbyBombs = nearbyBombs;
    }
}