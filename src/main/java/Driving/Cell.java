package Driving;

import java.util.ArrayList;

public class Cell {
    private boolean ischarged;

    public ArrayList<Cell> cells = new ArrayList<>();

    public Cell(){
        this.ischarged = false;
    }

    public boolean charge ()
    {
        if(!ischarged) {
        this.ischarged = true;
        return true;
        }
        else {
            return false;
        }
    }
    public int charge(int amount) {
        return 0;
    }


    public boolean discharge(){
        if(ischarged) {
            this.ischarged = false;
            return true;
        }
        else {
            return false;
        }
    }
    public int discharge(int amount) {
        return 0;
    }

    public void addCell(Cell cell){
        this.cells.add(cell);
    }

    public boolean getCharge() {
        return ischarged;
    }
}
