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
        for(int i = 0; i < cells.size() && amount > 0;i++){
            amount = this.cells.get(i).charge(amount);
        }
        return  amount;
    }
    @Override
    public int discharge(int amount) {
        int result = 0;
        for(int i = cells.size(); i > 0 && amount > 0;i--){
            result += this.cells.get(i-1).discharge(amount-result);

        }
        return  result;
    }

    public int getCharged() {
        int charge = 0;
        for (SubCell cell : this.cells) {
            charge = charge + cell.getCharged();
        }
        return charge;
    }

    public ArrayList<SubCell> getCells() {
        return cells;
    }
}
