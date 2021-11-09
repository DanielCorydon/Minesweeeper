package Minesweeeper;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * MineButton
 */
public class MineButton extends Button {
    private boolean isBomb;                         //This boolean checks if THIS MineButton is a bomb
    private int nearbyBombs;                        //This int tracks how many of the nearbyButtons are bombs
    private ArrayList<MineButton> nearbyButtons;    //This arraylist contains up to eight MineButtons, which represents the adjacent MineButtons to this one
    private ActionListener buttonpress;             //This Actionlistener will be used to press the button

    public MineButton(boolean isBomb) { //Constructor
        super("X");
        this.isBomb = isBomb;
        int nearbyBombs = 0;
        setActionListener();

    }

    public boolean getIsBomb() {                    //Returns true / false depending on whether this MineButton is a bomb
        return isBomb;
    }

    public int getNearbyBombs() {                   //Returns int of how many Buttons adjacent are bombs.
        return nearbyBombs;
    }

    public void addNearbyButtons(MineButton mineButton) {   //Adds nearbyButtons to the arraylist
        if (nearbyButtons.size()<9) {
            nearbyButtons.add(mineButton);
        }
    }

    public void buttonClicked() {                       //Method to call when the button is clicked. Should contain three logic statements, one if it is a bomb, one if it has nearby bombs, and one if there are no nearby bombs
        
                           
        if (nearbyBombs==0) {                           //If no nearby buttons are bombs
            
            clickNearby();
        }
    }

    public void clickNearby() {                         //Click all nearby buttons (this is only called if none of them are bombs)
        for (MineButton mineButton : nearbyButtons) {
            mineButton.buttonClicked();
        }
    }

    public ActionListener getThisAction() {
        return buttonpress;
    }

    public void setActionListener() {
        //ACTION LISTENER 1
        buttonpress = new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                 System.out.println("This Works");
            }
        };
    }

    public void getNeighbors(ArrayList<MineButton> neighbors) {
        nearbyButtons = neighbors;
    }
}