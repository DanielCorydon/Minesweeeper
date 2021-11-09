package Minesweeeper;
import java.awt.*;
import java.util.ArrayList;

class MineField extends Frame{

    MineField(int width, int height){
        this.setSize(height*10,width*10);//frame size 350 width and 350 height
        
    }
    public void initializeField(int bombAmount) {
        
    }

    // Creates ArrayList of [amount] Integers from 0 to [limit]
    private ArrayList<Integer> getRandomList(int amount) {
        ArrayList<Integer> numList = new ArrayList<>();
            while (numList.size() < amount) {
                int randomNum = Math.round( (long) Math.random() * (this.getHeight() * this.getWidth()));
                if (!numList.contains(randomNum)) {
                    numList.add(randomNum);
                }
            }
        return numList;
    }
    // Creates an ArrayList of ArrayLists containg boolean values based on the parameter bombLocations
    private ArrayList<ArrayList<Boolean>> createButtonInfo(ArrayList<Integer> bombLocations) {
        ArrayList<ArrayList<Boolean>> buttonList = new ArrayList<ArrayList<Boolean>>();
        for (int i = 0; i < this.getWidth(); i++) {
            for (int j = 0; j < this.getHeight(); j++) {
                boolean isBomb = (bombLocations.contains(i * 10 + j)) ? true : false;
                buttonList.get(i).add(j, isBomb);
            }
        }
        return buttonList;
    }

    private void createButtons(ArrayList<ArrayList<Boolean>> buttonList) {
        for (int i = 0; i < buttonList.size(); i++) {
            for (int j = 0; j < buttonList.get(i).size(); j++) {
                ArrayList<MineButton> nearbyButtons = new ArrayList<MineButton>();
                Button b=new MineButton(buttonList.get(i).get(j));
                b.setBounds(i * 30,j * 30,30,30);// setting button position
                add(b);//adding button into frame
            }
        }
    }
}