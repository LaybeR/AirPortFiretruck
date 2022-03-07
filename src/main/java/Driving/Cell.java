package Driving;

import java.util.ArrayList;

public class Cell {
    private boolean ischarged;



    public Cell(){
        this.ischarged = false;
    }

    public boolean charge ()
    {
        if(!this.ischarged) {
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
        if(this.ischarged) {
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


    public boolean getCharge() {
        return ischarged;
    }
}
