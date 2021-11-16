package Minesweeeper.Buttons;

import java.awt.*;
import java.awt.event.*;

public class EndButton extends Button {
    ActionListener EndAction;

    public EndButton() {
        super("Quit Game");
        this.setBounds(150, 100, 200, 150);
        this.addActionListener(setEndButton());

    }

    public ActionListener setEndButton() { // This sets the button press by creating a new action listener
        // ACTION LISTENER 1
        EndAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Runtime.getRuntime().exit(0);
            }
        };
        return EndAction;
    }

}

