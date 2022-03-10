package Lights;

import Enums.LightColour;
import Tanks.ITankListener;

public class FillGaugeLED implements ITankListener {

    private LightColour colour;
    private boolean on;

    public FillGaugeLED() {
        colour = LightColour.YELLOW;
        on = false;
    }

    @Override
    public void update(float ratio) {
        if (ratio > 0.5) {
            on = false;
        } else if (ratio > 0.25) {
            on = true;
            colour = LightColour.YELLOW;
        } else if (ratio > 0.1) {
            on = true;
            colour = LightColour.ORANGE;
        } else {
            on = true;
            colour = LightColour.RED;
        }
    }

    public void printStatus() {
        String print = "Die LED ist " + (on ? "an und leuchtet " : "aus.");
        if (on) {
            switch (colour) {
                case YELLOW -> print += "gelb.";
                case ORANGE -> print += "orange.";
                case RED -> print += "rot.";
            }
        }
        System.out.println("");
    }
}
