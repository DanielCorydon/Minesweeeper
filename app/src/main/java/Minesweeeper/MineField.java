package Minesweeeper;
import java.awt.*;
import java.util.ArrayList;

import org.checkerframework.checker.units.qual.min;

class MineField extends Frame{

    MineField(int width, int height){
        this.setSize(height*10,width*10);//frame size set by arguments
        
    }
    public void initializeField(int bombAmount) {
        ArrayList<Integer> numList = getRandomList(bombAmount);
        ArrayList<ArrayList<MineButton>> bombList = createButtons(numList);
        setNearbyButtons(bombList);
    }

    // Creates ArrayList of [amount] Integers from 0 to [limit]
    private ArrayList<Integer> getRandomList(int amount) {
        System.out.println("getrandomworks");
        ArrayList<Integer> numList = new ArrayList<>();
            while (numList.size() < amount) {
                long randomNum = Math.round(Math.random() * ((this.getHeight() / 10) * (this.getWidth()/10)));
                if (!numList.contains(randomNum)) {
                    numList.add((int)randomNum);
                }
            }
        return numList;
    }
    // Creates an ArrayList of ArrayLists containg boolean values based on the parameter bombLocations
    private ArrayList<ArrayList<MineButton>> createButtons(ArrayList<Integer> bombLocations) {
        System.out.println("createbuttons works");
        ArrayList<ArrayList<MineButton>> buttonList = new ArrayList<ArrayList<MineButton>>();
        for (int i = 0; i < this.getWidth() / 10; i++) {
            buttonList.add(new ArrayList<MineButton>());
            for (int j = 0; j < this.getHeight() / 10; j++) {
                boolean isBomb = bombLocations.contains(i * j);
                MineButton mineButton = new MineButton(isBomb);
                buttonList.get(i).add(mineButton);
                mineButton.setBounds(i*30,j*30,30,30);    
                this.add(mineButton);
            }
        }
        return buttonList;
    }

    private void setNearbyButtons(ArrayList<ArrayList<MineButton>> buttonList) {
        System.out.println("setnearbybuttons works");
        for (int i = 0; i < buttonList.size(); i++) {
            for (int j = 0; j < buttonList.get(i).size(); j++) {
                ArrayList<MineButton> nearbyButtons = new ArrayList<MineButton>();
                int counter = 0;
                for (int k = -1; k < 2; k++) {
                    for (int k2 = -1; k2 < 2; k2++) {
                        if (!(k == 0 && k2 == 0) && i + k >= 0 && j + k2 >= 0 && i + k < buttonList.size() && j + k2 < buttonList.get(i).size() ) {
                            nearbyButtons.add(buttonList.get(i+k).get(j+k2));
                            if (buttonList.get(i+k).get(j+k2).getIsBomb()) {
                                counter++;
                            }
                        }      
                    }
                }
                buttonList.get(i).get(j).getNeighbors(nearbyButtons,counter);
            }
        }
    }
}