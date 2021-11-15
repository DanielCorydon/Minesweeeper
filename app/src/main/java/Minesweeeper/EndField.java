package Minesweeeper;

import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

public class EndField extends Frame {

boolean isWon;

    public EndField(boolean isWon) { //Constructor
        this.isWon = isWon;
        this.setSize(100, 30);
        makeWindowClosable();



    }


    public void makeWindowClosable() {                  //Makes the window closable.
        addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        });   
    }


}
