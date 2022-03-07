package Driving;

import java.util.ArrayList;

public class MainCell extends Cell{
    ArrayList<SubCell> cells = new ArrayList<>();

    MainCell(){
        for (int i = 0; i < 100 ; i++){
            this.cells.add(new SubCell());
        }
    }
    @Override
    public int charge(int amount) {
        for(int i = 0; i < cells.size() && amount > 0;){
            amount = this.cells.get(i).charge(amount);
        }
        return  amount;
    }
    @Override
    public int discharge(int amount) {
        for(int i = 0; i < cells.size() && amount > 0;){
            boolean success = this.cells.get(i).discharge();
            if(success) amount--;

        }
        return  amount;
    }

    public int getCharged() {
        int charge = 0;
        for (SubCell cell : this.cells) {
            charge = charge + cell.getCharged();
        }
        return charge;
    }
}
