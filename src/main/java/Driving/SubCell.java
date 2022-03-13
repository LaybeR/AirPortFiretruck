package Driving;

import java.util.ArrayList;

public class SubCell extends Cell{
    ArrayList<Cell> cells = new ArrayList<>();

    public SubCell(){
        for (int i = 0; i < 10 ; i++){
            this.cells.add(new Cell());
        }
    }

    @Override
    public int charge(int amount) {
        for(int i = 0; i < cells.size() && amount > 0;i++){
            boolean success = this.cells.get(i).charge();
            if(success) amount--;

        }
        return  amount;
    }

    @Override
    public int discharge(int amount) {
        int result = 0;
        for(int i = cells.size(); i > 0 && result < amount;i--){
            boolean success = this.cells.get(i-1).discharge();
            if(success) result++;

        }
        return  result;
    }


    public int getCharged() {
        int charge = 0;
        for (Cell cell : this.cells) {
            if (cell.getCharge()) charge++;
        }
        return charge;
    }
}
