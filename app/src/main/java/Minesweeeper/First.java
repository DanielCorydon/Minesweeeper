package Minesweeeper;
import java.awt.*;

class First extends Frame{

First(){
Button b=new Button("click me");
b.setBounds(30,100,80,30);// setting button position

add(b);//adding button into frame
setSize(300,300);//frame size 300 width and 300 height
setLayout(null);//no layout now bydefault BorderLayout
setVisible(true);//now frame willbe visible, bydefault not visible

}
public static void main(String args[]){

First f=new First();

}
}