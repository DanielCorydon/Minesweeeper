package Minesweeeper;

public class Main {
    public static void main(String args[]){

        MineField mineField=new MineField(35, 35);
        mineField.initializeField(30);
        mineField.setLayout(null);//no layout now bydefault BorderLayout
        mineField.setVisible(true);//now frame willbe visible, bydefault not visible
    }
}
