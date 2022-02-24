package Controller;

import Enums.SwitchType;

public class Switch {
    public final SwitchType type;
    private boolean isOn;

    public Switch(SwitchType type) {
        this.type = type;
    }

    public void press() {
        isOn = !isOn;
        System.out.println("Schalter ist nun" + (isOn ? " an." : " aus."));
    }

    public boolean isPressed() {return isOn;}
}
