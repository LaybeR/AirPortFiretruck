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
    }

    public void turnCounterClockwise() {
        if (level > 1) {
            level--;
        }
    }

    public int getKnobPosition() {return level;}

    public KnobType getKnobType() {return type;}
}
