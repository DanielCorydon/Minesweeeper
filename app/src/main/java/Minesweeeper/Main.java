package Minesweeeper;

public class Main {
    public static void main(String args[]){

        MineField f=new MineField();
        f.setSize(350,350);//frame size 350 width and 350 height
        f.setLayout(null);//no layout now bydefault BorderLayout
        f.setVisible(true);//now frame willbe visible, bydefault not visible
    }
}
