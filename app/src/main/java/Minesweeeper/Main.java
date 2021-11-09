package Minesweeeper;

public class Main {
    public static void main(String args[]){

        MineField f=new MineField(35, 35);
        f.setLayout(null);//no layout now bydefault BorderLayout
        f.setVisible(true);//now frame willbe visible, bydefault not visible
    }
}
