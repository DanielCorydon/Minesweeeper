package Minesweeeper;
import java.awt.*;

class MineField extends Frame{

    MineField(){
        
        int positionx = 0;
        int positiony = 0;
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            positiony = 0;
            positionx += 30;
            for (int j = 0; j < 10; j++) {
                counter++;
                positiony += 30;
                boolean isBomb = (counter % 2 == 0) ? true : false;
                String bombString = (counter % 2 == 0) ? "B" : "X";
                Button b=new MineButton(bombString, isBomb);
                b.setBounds(positionx,positiony,30,30);// setting button position
                add(b);//adding button into frame
            }
        }
        
        setSize(350,350);//frame size 350 width and 350 height
        setLayout(null);//no layout now bydefault BorderLayout
        setVisible(true);//now frame willbe visible, bydefault not visible

    }
}