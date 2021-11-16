package Minesweeeper.Buttons;

import java.awt.*;
import java.awt.event.*;

public class PlayAgainButton extends Button {
    ActionListener PlayAgainaction;

    public PlayAgainButton() {
        super("Play Again!");
        this.setBounds(150, 100, 200, 150);
        this.addActionListener(setWinButton());

    }

    public ActionListener setWinButton() { // This sets the button press by creating a new action listener
        // ACTION LISTENER 1
        PlayAgainaction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Action that button will perform when clicked
            }
        };
        return PlayAgainaction;
    }

}
