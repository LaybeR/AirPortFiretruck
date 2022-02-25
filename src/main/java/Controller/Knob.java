package Controller;

import Enums.KnobType;

public class Knob {
    private KnobType type;
    private int level;
    private int maxLevel;

    public Knob(KnobType type, int maxLevel) {
        this.type = type;
        this.maxLevel = maxLevel;
        level = 1;
    }

    public void turnClockwise() {
        if (maxLevel > level) {
            level++;
        }
        System.out.println("Neues Level: " + level);
    }

    public void turnCounterClockwise() {
        if (level > 1) {
            level--;
        }
        System.out.println("Neues Level: " + level);
    }

    public int getKnobPosition() {return level;}
}
