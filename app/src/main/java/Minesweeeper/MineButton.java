package Minesweeeper;
import java.awt.*;
/**
 * MineButton
 */
public class MineButton extends Button{
    private boolean isBomb;

    public MineButton(String name, boolean isBomb) {
        super(name);
        this.isBomb = isBomb;
    }

    public boolean getIsBomb() {
        return isBomb;
    }
    
}