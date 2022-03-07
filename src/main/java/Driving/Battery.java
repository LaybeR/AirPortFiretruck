package Driving;

import java.util.ArrayList;
import java.util.Arrays;

public class Battery {
    ArrayList<MainCell> cells = new ArrayList<>();
    int charge;


    Battery(){
        create();
    }

    void create(){
        for (int i = 0; i < 100 ; i++){
        this.cells.add(new MainCell());
        }
    }

    int getMaxCharge() {
        return 100000;
    }

    int charge(int amount){
            for(int i = cells.size(); i > 0 && amount > 0;i--){
                amount = this.cells.get(i-1).charge(amount);
            }
            return  amount;
    }

    public int takeOut(int amount) {
        for(int i = 0; i < this.cells.size() && amount > 0;i++){
            amount = this.cells.get(i).discharge(amount);

        }
        return  amount;
    }

    public void addCell(int amount){
        for (int i = 0; i < amount ; i++){
            this.cells.add(new MainCell());
        }
    }
    public int getCharge(){

            this.charge = 0;
        for (MainCell cell : this.cells) {
            this.charge = this.charge + cell.getCharged();
        }
            return charge;

    }

}
