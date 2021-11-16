package Minesweeeper;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

//      import org.checkerframework.checker.units.qual.min; 
//      import org.w3c.dom.events.MouseEvent;
//      ARE THESE TWO USED?

class MineField extends Frame {
    private int buttonsX;
    private int buttonsY;
    private MouseAdapter buttonPressedRight;
    private ArrayList<Integer> numList;
    private ArrayList<ArrayList<MineButton>> bombList;
    private ArrayList<ArrayList<MineButton>> buttonList;
    private int amountCorrectBombs;
    private int bombAmount;

    MineField(int width, int height) {
        this.setSize(height * 30 + 60, width * 30 + 60);    // frame size set by arguments
        this.buttonsX = width;
        this.buttonsY = height;
        setMouseListener();                                 //Creates mouseAdapter for the right click to track flags.
        makeWindowClosable();                               //Adds window closing functionality.
    }

    public void initializeField(int bombAmount) {           // Main function which initiatiates the entire field with buttons
        this.bombAmount = bombAmount;                   
        this.numList = getRandomList(bombAmount);           // Get list of [bombAmount] random numbers between 0 and buttonX * ButtonsY
        this.bombList = createButtons(numList);             // Make an ArrayList of ArrayLists containing MineButtons
        setNearbyButtons(bombList);                         // Adds the field of NearbyBombs to the existing buttons
    }

    // Creates ArrayList of [amount] Integers from 0 to [limit]
    private ArrayList<Integer> getRandomList(int amount) {
        ArrayList<Integer> numList = new ArrayList<>();
        while (numList.size() < amount) {
            long randomNum = Math.round(Math.random() * (buttonsX * buttonsY)); // Get random number between 0 and buttonX * ButtonsY
            if (!numList.contains(randomNum)) {
                numList.add((int) randomNum);
            }
        }
        return numList;
    }

    // Creates an ArrayList of ArrayLists containg boolean values based on the
    // parameter bombLocations
    private ArrayList<ArrayList<MineButton>> createButtons(ArrayList<Integer> bombLocations) {
        this.buttonList = new ArrayList<ArrayList<MineButton>>();
        for (int i = 0; i < buttonsX; i++) {
            buttonList.add(new ArrayList<MineButton>());
            for (int j = 0; j < buttonsY; j++) {
                boolean isBomb = bombLocations.contains(i*buttonsX+(j));
                MineButton mineButton = new MineButton(isBomb);
                mineButton.addActionListener(mineButton.getThisAction());   // Adds left click
                mineButton.addMouseListener(buttonPressedRight);            // Adds right click
                buttonList.get(i).add(mineButton); 
                mineButton.setBounds((i + 1) * 30, (j + 1) * 30, 30, 30);   // Set position and size of button
                this.add(mineButton);                                       // Add the button to the MineField
            }
        }
        return buttonList;
    }

    private void setNearbyButtons(ArrayList<ArrayList<MineButton>> buttonList) {
        System.out.println("setnearbybuttons works");
        for (int i = 0; i < buttonList.size(); i++) {
            for (int j = 0; j < buttonList.get(i).size(); j++) {
                ArrayList<MineButton> nearbyButtons = new ArrayList<MineButton>();
                int counter = 0;
                for (int k = -1; k < 2; k++) {
                    for (int k2 = -1; k2 < 2; k2++) {
                        if (!(k == 0 && k2 == 0) && i + k >= 0 && j + k2 >= 0 && i + k < buttonList.size()
                                && j + k2 < buttonList.get(i).size()) {
                            nearbyButtons.add(buttonList.get(i + k).get(j + k2));
                            if (buttonList.get(i + k).get(j + k2).getIsBomb()) {
                                counter++;
                            }
                        }
                    }
                }
                buttonList.get(i).get(j).getNeighbors(nearbyButtons, counter);
            }
        }
    }
                                                       //CAN A LOT OF THIS SECTION GO TO THE MINEBUTTON CLASS?
    public void setMouseListener() {                   //This sets the rightbutton press by creating a new MouseListener
                                                       //Mouse Adapter
        buttonPressedRight = new MouseAdapter() {

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                
                if (e.getButton()==3) {                             //checks if the input is a right click
                    
                    var buttonInfo = e.getSource().toString();         //checks object source
                    String[] getInfo = buttonInfo.split(",");           //Splits it and gets coordinates
                    int xCord = Integer.parseInt(getInfo[1])/30;        //X coordinate
                    int yCord = Integer.parseInt(getInfo[2])/30;        //Y coordinate
                    if (!buttonList.get(xCord-1).get(yCord-1).getClicked() || buttonList.get(xCord-1).get(yCord-1).getLabel()=="F") {   //checks if the button has been clicked already

                        if (buttonList.get(xCord-1).get(yCord-1).getLabel()!="F") { //checks if it isnt a flag
                            if (buttonList.get(xCord-1).get(yCord-1).getIsBomb()) { //if it is a bomb execute this and add to amount of bombs
                                amountCorrectBombs+=1;
                                if (gameWon()) {               //Win condition

                                    System.out.println("Congratulations, you won!"); 
                                
                                }

                            }
                            else {
                                amountCorrectBombs-=1;
                            }
                            
                            buttonList.get(xCord-1).get(yCord-1).setLabel("F");     //SETS BUTTON TO F EVEN IF IT ISNT A BOMB
                            buttonList.get(xCord-1).get(yCord-1).buttonIsClicked(true);
                        }

                        else if (buttonList.get(xCord-1).get(yCord-1).getLabel()=="F") {
                            if (buttonList.get(xCord-1).get(yCord-1).getIsBomb()) { //REMOVES F FROM BUTTON also removes amount of correct bombs if it was a bomb
                                amountCorrectBombs-=1;
                            }
                            else {
                                amountCorrectBombs+=1;
                            }
                            buttonList.get(xCord-1).get(yCord-1).setLabel("X");     //Returns the button to X
                            buttonList.get(xCord-1).get(yCord-1).buttonIsClicked(false);
                        }
                    }
                    else {

                        System.out.println("You can only flag buttons which aren't clicked!");  //If an already pressed button is flagged.
                    
                    }
                System.out.println(amountCorrectBombs);
                }
            }
        };
    }                   //END OF MOUSE LISTENER CLASS DEF

    public boolean gameWon() {
        if (amountCorrectBombs==bombAmount) {
            EndField end = new EndField(true);              //Checks victory condition and makes new endscreen window
            end.setLayout(null);
            end.setVisible(true);
            return true;
        }
        else {
            return false;
        }
    }

    public void makeWindowClosable() {
        addWindowListener (new WindowAdapter() {            //Makes main window closable
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        });    
    }



    

}