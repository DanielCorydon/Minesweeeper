package Minesweeeper.Buttons;
import java.awt.*;
import java.awt.event.*;


public class StartButton extends Button {
    ActionListener StartAction;

    public StartButton() {
        super("Play Now!");
        this.setBounds(150, 100, 200, 150);
        this.addActionListener(setStartButton());

    }

    public ActionListener setStartButton() { // This sets the button press by creating a new action listener
        // ACTION LISTENER 1
        StartAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Action that button will perform when clicked
            }
        };
        return StartAction;
    }

}
