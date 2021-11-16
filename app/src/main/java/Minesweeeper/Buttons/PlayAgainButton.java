package Minesweeeper.Buttons;

import Minesweeeper.*;

import java.awt.*;
import java.awt.event.*;

public class PlayAgainButton extends Button {
    ActionListener PlayAgainaction;
    MineField minefield;
    EndField endfield;

    public PlayAgainButton(MineField minefield, EndField endfield) {
        super("Play Again!");
        this.setBounds(150, 100, 200, 150);
        this.addActionListener(setWinButton());
        this.minefield = minefield;
        this.endfield = endfield;

    }

    public ActionListener setWinButton() { // This sets the button press by creating a new action listener
        // ACTION LISTENER 1
        PlayAgainaction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                endfield.dispose();
                minefield.clearMineField();
            }
        };
        return PlayAgainaction;
    }

}
